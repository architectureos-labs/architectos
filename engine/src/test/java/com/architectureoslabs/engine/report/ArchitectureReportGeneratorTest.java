package com.architectureoslabs.engine.report;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.ArchitectureHealth;
import com.architectureoslabs.engine.model.ArchitectureMetrics;
import com.architectureoslabs.engine.model.ArchitectureReport;
import com.architectureoslabs.engine.rules.RuleResult;

/**
 * Tests architecture report generation.
 */
public class ArchitectureReportGeneratorTest {

    @Test
    void shouldGenerateMarkdownReport() {

        RuleResult result
                = new RuleResult(
                        "CircularDependencyRule",
                        "HIGH",
                        true,
                        "Circular dependency detected"
                );

        ArchitectureMetrics metrics
                = new ArchitectureMetrics(
                        5,
                        4,
                        3
                );

        ArchitectureHealth health
                = new ArchitectureHealth(
                        100,
                        "HEALTHY"
                );

        ArchitectureReport architectureReport
                = new ArchitectureReport(
                        "test-repository",
                        LocalDateTime.now(),
                        new ArchitectureGraph(),
                        List.of(result),
                        metrics,
                        health,
                        "```mermaid\ngraph TD\n```"
                );

        ArchitectureReportGenerator generator
                = new ArchitectureReportGenerator();

        String report
                = generator.generateMarkdown(
                        architectureReport
                );

        assertTrue(
                report.contains(
                        "ArchitectOS Architecture Report"
                )
        );

        assertTrue(
                report.contains(
                        "CircularDependencyRule"
                )
        );

        assertTrue(
                report.contains(
                        "HIGH"
                )
        );

    }

}
