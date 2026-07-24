package com.architectureoslabs.engine.rules;


import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.Dependency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests circular dependency detection.
 */
public class CircularDependencyRuleTest {


    @Test
    void shouldDetectCircularDependency() {


        ArchitectureGraph graph =
                new ArchitectureGraph();



        graph.addDependency(
                new Dependency(
                        "UserService",
                        "AccountService"
                )
        );



        graph.addDependency(
                new Dependency(
                        "AccountService",
                        "UserService"
                )
        );



        CircularDependencyRule rule =
                new CircularDependencyRule();



        RuleResult result =
                rule.evaluate(graph);



        assertTrue(
                result.isViolated()
        );


        assertTrue(
                result.getMessage()
                        .contains(
                                "Circular dependency"
                        )
        );

    }

}
