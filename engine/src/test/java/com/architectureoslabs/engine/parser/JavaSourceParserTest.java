package com.architectureoslabs.engine.parser;


import com.architectureoslabs.engine.model.ParsedJavaFile;
import com.architectureoslabs.engine.model.SoftwareComponent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests Java source parsing behavior.
 */
public class JavaSourceParserTest {


    @Test
    void shouldExtractClassNameFromJavaSource() {


        JavaSourceParser parser =
                new JavaSourceParser();


        String sourceCode = """

                public class PaymentService {

                }

                """;


        ParsedJavaFile parsedFile =
                parser.parse(sourceCode);


        SoftwareComponent component =
                parsedFile.getComponent();


        assertNotNull(component);


        assertEquals(
                "PaymentService",
                component.getName()
        );


        assertEquals(
                "class",
                component.getType()
        );

    }


    @Test
    void shouldExtractImportsAsDependencies() {


        JavaSourceParser parser =
                new JavaSourceParser();


        String sourceCode = """

                import com.company.repository.PaymentRepository;
                import com.company.user.UserService;


                public class PaymentService {

                }

                """;


        ParsedJavaFile parsedFile =
                parser.parse(sourceCode);


        assertNotNull(parsedFile);


        assertEquals(
                2,
                parsedFile.getDependencies().size()
        );


        assertEquals(
                "PaymentRepository",
                parsedFile.getDependencies()
                        .get(0)
                        .getTarget()
        );


        assertEquals(
                "UserService",
                parsedFile.getDependencies()
                        .get(1)
                        .getTarget()
        );

    }

}
