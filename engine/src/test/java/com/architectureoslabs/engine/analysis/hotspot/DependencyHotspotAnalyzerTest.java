package com.architectureoslabs.engine.analysis.hotspot;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.Dependency;

/**
 * Tests dependency hotspot analysis.
 */
public class DependencyHotspotAnalyzerTest {

    @Test
    void shouldDetectCouplingHotspot() {

        ArchitectureGraph graph
                = new ArchitectureGraph();

        graph.addDependency(
                new Dependency(
                        "OrderService",
                        "PaymentService"
                )
        );

        graph.addDependency(
                new Dependency(
                        "OrderService",
                        "InventoryService"
                )
        );

        graph.addDependency(
                new Dependency(
                        "OrderController",
                        "OrderService"
                )
        );

        DependencyHotspotAnalyzer analyzer
                = new DependencyHotspotAnalyzer();

        List<DependencyHotspot> hotspots
                = analyzer.analyze(
                        graph
                );

        DependencyHotspot hotspot
                = hotspots.stream()
                        .filter(
                                h
                                -> h.getMetrics()
                                        .getComponentName()
                                        .equals(
                                                "OrderService"
                                        )
                        )
                        .findFirst()
                        .orElseThrow();

        assertEquals(
                1,
                hotspot.getMetrics()
                        .getIncomingDependencies()
        );

        assertEquals(
                2,
                hotspot.getMetrics()
                        .getOutgoingDependencies()
        );

        assertEquals(
                3,
                hotspot.getMetrics()
                        .getCouplingScore()
        );

    }

    @Test
    void shouldSortHotspotsByCouplingScoreDescending() {

        ArchitectureGraph graph
                = new ArchitectureGraph();

        graph.addDependency(
                new Dependency(
                        "A",
                        "B"
                )
        );

        graph.addDependency(
                new Dependency(
                        "A",
                        "C"
                )
        );

        graph.addDependency(
                new Dependency(
                        "A",
                        "D"
                )
        );

        graph.addDependency(
                new Dependency(
                        "E",
                        "A"
                )
        );

        DependencyHotspotAnalyzer analyzer
                = new DependencyHotspotAnalyzer();

        List<DependencyHotspot> hotspots
                = analyzer.analyze(
                        graph
                );

        assertEquals(
                "A",
                hotspots.get(0)
                        .getMetrics()
                        .getComponentName()
        );

    }

}
