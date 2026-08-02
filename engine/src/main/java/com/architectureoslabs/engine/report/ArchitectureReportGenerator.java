package com.architectureoslabs.engine.report;


import com.architectureoslabs.engine.model.ArchitectureReport;
import com.architectureoslabs.engine.report.renderer.MarkdownReportRenderer;


/**
 * Generates architecture reports.
 *
 * Coordinates report creation and rendering.
 */
public class ArchitectureReportGenerator {


    private final MarkdownReportRenderer renderer;


    public ArchitectureReportGenerator() {

        this.renderer =
                new MarkdownReportRenderer();

    }



    /**
     * Generate Markdown report.
     *
     * @param report architecture report model
     * @return markdown content
     */
    public String generateMarkdown(
            ArchitectureReport report
    ) {

        return renderer.render(
                report
        );

    }

}