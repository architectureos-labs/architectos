package com.architectureoslabs.engine.report.renderer;


import com.architectureoslabs.engine.report.model.ArchitectureMetrics;
import com.architectureoslabs.engine.report.model.ArchitectureReport;
import com.architectureoslabs.engine.rules.RuleResult;


/**
 * Renders an ArchitectureReport as Markdown.
 */
public class MarkdownReportRenderer {


    public String render(
            ArchitectureReport report
    ) {


        StringBuilder markdown =
                new StringBuilder();



        markdown.append(
                "# ArchitectOS Architecture Report\n\n"
        );



        markdown.append(
                "## Repository Summary\n\n"
        );


        markdown.append(
                "Repository: "
        )
        .append(
                report.getRepositoryName()
        )
        .append(
                "\n\n"
        );



        ArchitectureMetrics metrics =
                report.getMetrics();



        markdown.append(
                "Files Analyzed: "
        )
        .append(
                metrics.getFilesAnalyzed()
        )
        .append(
                "\n\n"
        );



        markdown.append(
                "Components: "
        )
        .append(
                metrics.getComponents()
        )
        .append(
                "\n\n"
        );



        markdown.append(
                "Dependencies: "
        )
        .append(
                metrics.getDependencies()
        )
        .append(
                "\n\n"
        );



        markdown.append(
                "## Rule Summary\n\n"
        );



        markdown.append(
                "Rules Executed: "
        )
        .append(
                report.getRuleResults().size()
        )
        .append(
                "\n\n"
        );



        long violations =
                report.getRuleResults()
                        .stream()
                        .filter(
                                RuleResult::isViolated
                        )
                        .count();



        markdown.append(
                "Violations Found: "
        )
        .append(
                violations
        )
        .append(
                "\n\n"
        );



        markdown.append(
                "## Findings\n\n"
        );



        for (RuleResult result :
                report.getRuleResults()) {


            markdown.append(
                    "### "
            )
            .append(
                    result.getRuleName()
            )
            .append(
                    "\n\n"
            );


            markdown.append(
                    "Severity: "
            )
            .append(
                    result.getSeverity()
            )
            .append(
                    "\n\n"
            );


            markdown.append(
                    "Status: "
            )
            .append(
                    result.isViolated()
                            ? "FAILED"
                            : "PASSED"
            )
            .append(
                    "\n\n"
            );


            markdown.append(
                    "Message: "
            )
            .append(
                    result.getMessage()
            )
            .append(
                    "\n\n"
            );

        }



        return markdown.toString();

    }

}