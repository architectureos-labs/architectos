package com.architectureoslabs.engine.report;


import com.architectureoslabs.engine.rules.RuleResult;

import java.util.List;


/**
 * Generates human-readable architecture reports.
 */
public class ArchitectureReportGenerator {


    /**
     * Generate Markdown report.
     *
     * @param results architecture rule results
     * @return markdown content
     */
    public String generateMarkdown(
            List<RuleResult> results
    ) {


        StringBuilder report =
                new StringBuilder();



        report.append(
                "# ArchitectOS Architecture Report\n\n"
        );



        report.append(
                "## Summary\n\n"
        );


        report.append(
                "Rules Executed: "
        );


        report.append(
                results.size()
        );


        report.append(
                "\n\n"
        );



        long violations =
                results.stream()
                        .filter(
                                RuleResult::isViolated
                        )
                        .count();



        report.append(
                "Violations Found: "
        );


        report.append(
                violations
        );


        report.append(
                "\n\n"
        );



        report.append(
                "## Findings\n\n"
        );



        for (RuleResult result : results) {


            report.append(
                    "### "
            );


            report.append(
                    result.getRuleName()
            );


            report.append(
                    "\n\n"
            );


            report.append(
                    "Severity: "
            );


            report.append(
                    result.getSeverity()
            );


            report.append(
                    "\n\n"
            );


            report.append(
                    "Status: "
            );


            report.append(
                    result.isViolated()
                    ? "FAILED"
                    : "PASSED"
            );


            report.append(
                    "\n\n"
            );


            report.append(
                    "Message: "
            );


            report.append(
                    result.getMessage()
            );


            report.append(
                    "\n\n"
            );

        }


        return report.toString();

    }

}
