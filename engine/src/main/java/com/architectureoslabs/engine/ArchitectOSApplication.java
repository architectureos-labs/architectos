package com.architectureoslabs.engine;


import com.architectureoslabs.engine.analyzer.RepositoryAnalyzer;
import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.report.ArchitectureReportGenerator;
import com.architectureoslabs.engine.report.ReportWriter;
import com.architectureoslabs.engine.scanner.RepositoryScanner;
import com.architectureoslabs.engine.rules.ArchitectureRuleEngine;
import com.architectureoslabs.engine.rules.CircularDependencyRule;
import com.architectureoslabs.engine.rules.RuleResult;


import java.util.List;
import java.nio.file.Path;



/**
 * Main entry point for ArchitectOS.
 */
public class ArchitectOSApplication {


    public static void main(String[] args)
            throws Exception {



        String repository =
                ".";



        RepositoryScanner scanner =
                new RepositoryScanner();



        List<Path> files =
                scanner.scan(
                        repository
                );



        RepositoryAnalyzer analyzer =
                new RepositoryAnalyzer();



        ArchitectureGraph graph =
                analyzer.analyze(
                        files
                );



        ArchitectureRuleEngine engine =
                new ArchitectureRuleEngine();



        engine.registerRule(
                new CircularDependencyRule()
        );



        List<RuleResult> results =
                engine.analyze(
                        graph
                );



        ArchitectureReportGenerator generator =
                new ArchitectureReportGenerator();



        String report =
                generator.generateMarkdown(
                        results
                );



        new ReportWriter()
                .write(
                        "architectos-report.md",
                        report
                );



        System.out.println(
                "Analyzed files: "
                        + files.size()
        );


        System.out.println(
                "Report generated: architectos-report.md"
        );

    }

}