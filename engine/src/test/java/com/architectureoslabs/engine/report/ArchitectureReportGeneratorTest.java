package com.architectureoslabs.engine.report;


import com.architectureoslabs.engine.rules.RuleResult;

import org.junit.jupiter.api.Test;

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


        ArchitectureReportGenerator generator =
                new ArchitectureReportGenerator();



        String report =
                generator.generateMarkdown(
                        List.of(result)
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
