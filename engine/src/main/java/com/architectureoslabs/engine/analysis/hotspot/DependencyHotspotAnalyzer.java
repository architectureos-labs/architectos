package com.architectureoslabs.engine.analysis.hotspot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.Dependency;

/**
 * Analyzes architecture graphs to find dependency hotspots.
 */
public class DependencyHotspotAnalyzer {

    public List<DependencyHotspot> analyze(
            ArchitectureGraph graph
    ) {

        Map<String, Integer> incoming
                = new HashMap<>();

        Map<String, Integer> outgoing
                = new HashMap<>();

        for (Dependency dependency
                : graph.getDependencies()) {

            outgoing.put(
                    dependency.getSource(),
                    outgoing.getOrDefault(
                            dependency.getSource(),
                            0
                    ) + 1
            );

            incoming.put(
                    dependency.getTarget(),
                    incoming.getOrDefault(
                            dependency.getTarget(),
                            0
                    ) + 1
            );

        }

        List<DependencyHotspot> hotspots
                = new ArrayList<>();

        for (String component
                : outgoing.keySet()) {

            ComponentCouplingMetrics metrics
                    = new ComponentCouplingMetrics(
                            component,
                            incoming.getOrDefault(
                                    component,
                                    0
                            ),
                            outgoing.get(component)
                    );

            hotspots.add(
                    new DependencyHotspot(
                            metrics,
                            calculateRisk(
                                    metrics.getCouplingScore()
                            )
                    )
            );

        }

        hotspots.sort(
                Comparator.comparingInt(
                        (DependencyHotspot hotspot)
                        -> hotspot.getMetrics()
                                .getCouplingScore()
                )
                        .reversed()
        );

        return hotspots;
    }

    private String calculateRisk(
            int couplingScore
    ) {

        if (couplingScore >= 10) {

            return "HIGH";

        }

        if (couplingScore >= 5) {

            return "MEDIUM";

        }

        return "LOW";

    }

}
