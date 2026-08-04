package com.architectureoslabs.engine.report.diagram;

import java.util.LinkedHashSet;
import java.util.Set;

import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.Dependency;

/**
 * Renders an ArchitectureGraph as Mermaid.
 */
public class MermaidDiagramRenderer {

    public String render(
            ArchitectureGraph graph
    ) {

        if (graph == null) {

            throw new DiagramRenderException(
                    "Architecture graph cannot be null."
            );

        }

        StringBuilder diagram
                = new StringBuilder();

        diagram.append(
                "```mermaid\n"
        );

        diagram.append(
                "graph TD\n\n"
        );

        Set<String> components
                =  new LinkedHashSet<>();

        for (Dependency dependency
                : graph.getDependencies()) {

            components.add(
                    dependency.getSource()
            );

            components.add(
                    dependency.getTarget()
            );

        }

        // Render nodes
        for (String component
                : components) {

            diagram.append(
                    component
            );

            diagram.append(
                    "[\""
            );

            diagram.append(
                    component
            );

            diagram.append(
                    "\"]\n\n"
            );

        }

        // Render relationships
        for (Dependency dependency
                : graph.getDependencies()) {

            diagram.append(
                    dependency.getSource()
            );

            diagram.append(
                    " --> "
            );

            diagram.append(
                    dependency.getTarget()
            );

            diagram.append(
                    "\n"
            );

        }

        diagram.append(
                "```\n"
        );

        return diagram.toString();

    }
}
