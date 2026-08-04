package com.architectureoslabs.engine.report.diagram;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.Dependency;

/**
 * Tests Mermaid diagram rendering.
 */
public class MermaidDiagramRendererTest {

    @Test
    void shouldRenderDependencyGraph() {

        ArchitectureGraph graph
                = new ArchitectureGraph();

        graph.addDependency(
                new Dependency(
                        "UserService",
                        "OrderService"
                )
        );

        MermaidDiagramRenderer renderer
                = new MermaidDiagramRenderer();

        String diagram
                = renderer.render(
                        graph
                );

        assertTrue(
                diagram.contains(
                        "graph TD"
                )
        );

        assertTrue(
                diagram.contains(
                        "UserService --> OrderService"
                )
        );

    }

    @Test
    void shouldThrowExceptionForNullGraph() {

        MermaidDiagramRenderer renderer
                = new MermaidDiagramRenderer();

        assertThrows(
                DiagramRenderException.class,
                () -> renderer.render(
                        null
                )
        );

    }

    @Test
    void shouldRenderNodes() {

        ArchitectureGraph graph
                = new ArchitectureGraph();

        graph.addDependency(
                new Dependency(
                        "UserService",
                        "UserRepository"
                )
        );

        MermaidDiagramRenderer renderer
                = new MermaidDiagramRenderer();

        String diagram
                = renderer.render(
                        graph
                );

        assertTrue(
                diagram.contains(
                        "UserService[\"UserService\"]"
                )
        );

        assertTrue(
                diagram.contains(
                        "UserRepository[\"UserRepository\"]"
                )
        );

    }

}
