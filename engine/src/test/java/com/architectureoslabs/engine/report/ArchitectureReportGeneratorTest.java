package com.architectureoslabs.engine.report;


import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.report.model.ArchitectureMetrics;
import com.architectureoslabs.engine.report.model.ArchitectureReport;
import com.architectureoslabs.engine.rules.RuleResult;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests architecture report generation.
 */
public class ArchitectureReportGeneratorTest {


    @Test
    void shouldGenerateMarkdownReport() {


        RuleResult result =
                new RuleResult(
                        "CircularDependencyRule",
                        "HIGH",
                        true,
                        "Circular dependency detected"
                );


        ArchitectureMetrics metrics =
                new ArchitectureMetrics(
                        5,
                        4,
                        3
                );


        ArchitectureReport architectureReport =
                new ArchitectureReport(
                        "test-repository",
                        LocalDateTime.now(),
                        new ArchitectureGraph(),
                        List.of(result),
                        metrics
                );


        ArchitectureReportGenerator generator =
                new ArchitectureReportGenerator();


        String report =
                generator.generateMarkdown(
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