package com.architectureoslabs.engine;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

import com.architectureoslabs.engine.analysis.hotspot.DependencyHotspot;
import com.architectureoslabs.engine.analysis.hotspot.DependencyHotspotAnalyzer;
import com.architectureoslabs.engine.analyzer.RepositoryAnalyzer;
import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.ArchitectureHealth;
import com.architectureoslabs.engine.model.ArchitectureMetrics;
import com.architectureoslabs.engine.model.ArchitectureReport;
import com.architectureoslabs.engine.report.ArchitectureReportGenerator;
import com.architectureoslabs.engine.report.ReportWriter;
import com.architectureoslabs.engine.report.diagram.MermaidDiagramRenderer;
import com.architectureoslabs.engine.report.health.ArchitectureHealthCalculator;
import com.architectureoslabs.engine.rules.ArchitectureRuleEngine;
import com.architectureoslabs.engine.rules.CircularDependencyRule;
import com.architectureoslabs.engine.rules.RuleResult;
import com.architectureoslabs.engine.scanner.RepositoryScanner;

/**
 * Main entry point for ArchitectOS.
 */
public class ArchitectOSApplication {

    public static void main(String[] args)
            throws Exception {

        String repository
                = args.length > 0
                        ? args[0]
                        : ".";

        RepositoryScanner scanner
                = new RepositoryScanner();

        List<Path> files
                = scanner.scan(
                        repository
                );

        RepositoryAnalyzer analyzer
                = new RepositoryAnalyzer();

        ArchitectureGraph graph
                = analyzer.analyze(
                        files
                );

        ArchitectureRuleEngine engine
                = new ArchitectureRuleEngine();

        engine.registerRule(
                new CircularDependencyRule()
        );

        List<RuleResult> results
                = engine.analyze(
                        graph
                );

        ArchitectureMetrics metrics
                = new ArchitectureMetrics(
                        files.size(),
                        graph.getComponents().size(),
                        graph.getDependencies().size()
                );

        String repositoryName
                = Path.of(repository)
                        .getFileName()
                        .toString();

        ArchitectureHealthCalculator healthCalculator
                = new ArchitectureHealthCalculator();

        ArchitectureHealth health
                = healthCalculator.calculate(
                        results
                );

        DependencyHotspotAnalyzer hotspotAnalyzer
                = new DependencyHotspotAnalyzer();

        List<DependencyHotspot> hotspots
                = hotspotAnalyzer.analyze(
                        graph
                );

        MermaidDiagramRenderer diagramRenderer
                = new MermaidDiagramRenderer();

        String architectureDiagram
                = diagramRenderer.render(
                        graph
                );

        ArchitectureReport architectureReport
                = new ArchitectureReport(
                        repositoryName,
                        LocalDateTime.now(),
                        graph,
                        results,
                        metrics,
                        health,
                        architectureDiagram,
                        hotspots
                );

        ArchitectureReportGenerator generator
                = new ArchitectureReportGenerator();

        String report
                = generator.generateMarkdown(
                        architectureReport
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
