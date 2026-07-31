package com.architectureoslabs.engine.analyzer;


import com.architectureoslabs.engine.model.ArchitectureGraph;

import org.junit.jupiter.api.Test;


import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;



public class RepositoryAnalyzerTest {


    @Test
    void shouldAnalyzeJavaFiles()
            throws Exception {


        Path directory =
                Files.createTempDirectory(
                        "architectos-analyzer-test"
                );


        Path javaFile =
                directory.resolve(
                        "PaymentService.java"
                );


        Files.writeString(
                javaFile,
                """
                public class PaymentService {

                }
                """
        );



        RepositoryAnalyzer analyzer =
                new RepositoryAnalyzer();



        ArchitectureGraph graph =
                analyzer.analyze(
                        List.of(javaFile)
                );



        assertNotNull(
                graph
        );

    }

}