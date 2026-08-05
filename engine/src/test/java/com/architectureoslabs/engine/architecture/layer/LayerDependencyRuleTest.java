package com.architectureoslabs.engine.architecture.layer;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.architectureoslabs.engine.model.Dependency;


/**
 * Tests layer dependency validation.
 */
public class LayerDependencyRuleTest {


    @Test
    void shouldDetectInvalidDependencyDirection() {


        LayerDependencyRule rule =
                new LayerDependencyRule();


        Dependency dependency =
                new Dependency(
                        "OrderRepository",
                        "OrderController"
                );


        assertTrue(
                rule.isViolation(
                        dependency
                )
        );

    }



    @Test
    void shouldAllowServiceToRepositoryDependency() {


        LayerDependencyRule rule =
                new LayerDependencyRule();


        Dependency dependency =
                new Dependency(
                        "OrderService",
                        "OrderRepository"
                );


        assertFalse(
                rule.isViolation(
                        dependency
                )
        );

    }

}