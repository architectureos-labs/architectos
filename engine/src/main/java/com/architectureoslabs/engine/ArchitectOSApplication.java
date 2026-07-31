package com.architectureoslabs.engine;


import com.architectureoslabs.engine.analyzer.RepositoryAnalyzer;
import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.report.ArchitectureReportGenerator;
import com.architectureoslabs.engine.report.ReportWriter;
import com.architectureoslabs.engine.rules.ArchitectureRuleEngine;
import com.architectureoslabs.engine.rules.CircularDependencyRule;
import com.architectureoslabs.engine.rules.RuleResult;


import java.util.List;



/**
 * Main entry point for ArchitectOS Analysis Engine.
 */
public class ArchitectOSApplication {


    public static void main(String[] args)
            throws Exception {


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



        ArchitectureRuleEngine engine =
                new ArchitectureRuleEngine();



        engine.registerRule(
                new CircularDependencyRule()
        );



        List<RuleResult> results =
                engine.analyze(graph);



        ArchitectureReportGenerator generator =
                new ArchitectureReportGenerator();



        String report =
                generator.generateMarkdown(
                        results
                );



        ReportWriter writer =
                new ReportWriter();



        writer.write(
                "architectos-report.md",
                report
        );



        System.out.println(
                "Architecture report generated:"
        );


        System.out.println(
                "architectos-report.md"
        );

    }

}
