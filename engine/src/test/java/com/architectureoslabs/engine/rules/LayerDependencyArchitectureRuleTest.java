package com.architectureoslabs.engine.rules;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.Dependency;


/**
 * Tests layer dependency architecture rule.
 */
public class LayerDependencyArchitectureRuleTest {


    @Test
    void shouldDetectRepositoryDependingOnController() {


        ArchitectureGraph graph =
                new ArchitectureGraph();


        graph.addDependency(
                new Dependency(
                        "OrderRepository",
                        "OrderController"
                )
        );


        LayerDependencyArchitectureRule rule =
                new LayerDependencyArchitectureRule();


        RuleResult result =
                rule.evaluate(
                        graph
                );


        assertTrue(
                result.isViolated()
        );


        assertEquals(
                "HIGH",
                result.getSeverity()
        );

    }



    @Test
    void shouldAllowServiceToRepository() {


        ArchitectureGraph graph =
                new ArchitectureGraph();


        graph.addDependency(
                new Dependency(
                        "OrderService",
                        "OrderRepository"
                )
        );


        LayerDependencyArchitectureRule rule =
                new LayerDependencyArchitectureRule();


        RuleResult result =
                rule.evaluate(
                        graph
                );


        assertFalse(
                result.isViolated()
        );

    }

}