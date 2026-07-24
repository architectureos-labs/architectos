package com.architectureoslabs.engine;

import com.architectureoslabs.engine.analyzer.RepositoryAnalyzer;
import com.architectureoslabs.engine.model.ArchitectureGraph;

/**
 * Main entry point for ArchitectOS Analysis Engine.
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
                import com.company.user.UserService;

                public class PaymentService {

                }

                """;

        ArchitectureGraph graph =
                analyzer.analyze(sourceCode);

        System.out.println();

        System.out.println("Components");

        graph.getComponents()
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Dependencies");

        graph.getDependencies()
                .forEach(System.out::println);

    }

}
