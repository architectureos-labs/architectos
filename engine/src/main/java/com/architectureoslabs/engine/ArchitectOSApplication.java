package com.architectureoslabs.engine;


import com.architectureoslabs.engine.analyzer.RepositoryAnalyzer;
import com.architectureoslabs.engine.model.ParsedJavaFile;


/**
 * Main entry point for ArchitectOS Analysis Engine.
 *
 * This class initializes the architecture analysis platform.
 */
public class ArchitectOSApplication {


    public static void main(String[] args) {


        System.out.println(
                "ArchitectOS Analysis Engine initialized"
        );


        RepositoryAnalyzer analyzer =
                new RepositoryAnalyzer();



        String sourceCode = """

                import com.company.repository.PaymentRepository;


                public class PaymentService {

                }

                """;



        ParsedJavaFile result =
                analyzer.analyze(
                        sourceCode
                );



        System.out.println(
                "Analysis Result:"
        );



        System.out.println(
                "Component: "
                        + result.getComponent()
        );



        System.out.println(
                "Dependencies: "
                        + result.getDependencies()
        );

    }

}
