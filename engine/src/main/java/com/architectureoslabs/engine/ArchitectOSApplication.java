package com.architectureoslabs.engine;


import com.architectureoslabs.engine.analyzer.RepositoryAnalyzer;
import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.rules.ArchitectureRuleEngine;
import com.architectureoslabs.engine.rules.CircularDependencyRule;
import com.architectureoslabs.engine.rules.RuleResult;



/**
 * Main entry point for ArchitectOS Analysis Engine.
 */
public class ArchitectOSApplication {


    public static void main(String[] args) {


        System.out.println(
                "================================="
        );


        System.out.println(
                "ArchitectOS Analysis Engine"
        );


        System.out.println(
                "================================="
        );



        RepositoryAnalyzer analyzer =
                new RepositoryAnalyzer();



        String sourceCode = """

                import com.company.user.UserService;


                public class PaymentService {

                }

                """;



        ArchitectureGraph graph =
                analyzer.analyze(
                        sourceCode
                );



        ArchitectureRuleEngine ruleEngine =
                new ArchitectureRuleEngine();



        ruleEngine.registerRule(
                new CircularDependencyRule()
        );



        System.out.println();

        System.out.println(
                "Architecture Components:"
        );


        graph.getComponents()
                .forEach(
                        System.out::println
                );



        System.out.println();

        System.out.println(
                "Dependencies:"
        );


        graph.getDependencies()
                .forEach(
                        System.out::println
                );



        System.out.println();

        System.out.println(
                "Architecture Analysis:"
        );



        for (RuleResult result :
                ruleEngine.analyze(graph)) {


            System.out.println(
                    result.getMessage()
            );

        }


        System.out.println();

        System.out.println(
                "Analysis Completed"
        );

    }

}
