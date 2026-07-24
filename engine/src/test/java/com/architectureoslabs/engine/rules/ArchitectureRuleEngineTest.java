package com.architectureoslabs.engine.rules;


import com.architectureoslabs.engine.model.ArchitectureGraph;
import com.architectureoslabs.engine.model.Dependency;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests rule engine execution.
 */
public class ArchitectureRuleEngineTest {


    @Test
    void shouldExecuteRegisteredRules() {


        ArchitectureGraph graph =
                new ArchitectureGraph();



        graph.addDependency(
                new Dependency(
                        "A",
                        "B"
                )
        );



        graph.addDependency(
                new Dependency(
                        "B",
                        "A"
                )
        );



        ArchitectureRuleEngine engine =
                new ArchitectureRuleEngine();



        engine.registerRule(
                new CircularDependencyRule()
        );



        List<RuleResult> results =
                engine.analyze(graph);



        assertEquals(
                1,
                results.size()
        );



        assertTrue(
                results.get(0)
                        .isViolated()
        );

    }

}
