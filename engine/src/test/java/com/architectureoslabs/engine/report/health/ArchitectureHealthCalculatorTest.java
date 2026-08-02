package com.architectureoslabs.engine.report.health;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.architectureoslabs.engine.model.ArchitectureHealth;
import com.architectureoslabs.engine.rules.RuleResult;


/**
 * Tests architecture health calculation.
 */
public class ArchitectureHealthCalculatorTest {


    @Test
    void shouldReturnHealthyArchitecture() {


        ArchitectureHealthCalculator calculator =
                new ArchitectureHealthCalculator();


        ArchitectureHealth health =
                calculator.calculate(
                        List.of()
                );


        assertEquals(
                100,
                health.getScore()
        );


        assertEquals(
                "HEALTHY",
                health.getRating()
        );

    }



    @Test
    void shouldReduceScoreForCircularDependency() {


        RuleResult violation =
                new RuleResult(
                        "CircularDependencyRule",
                        "HIGH",
                        true,
                        "Cycle detected"
                );


        ArchitectureHealthCalculator calculator =
                new ArchitectureHealthCalculator();



        ArchitectureHealth health =
                calculator.calculate(
                        List.of(violation)
                );



        assertEquals(
                70,
                health.getScore()
        );


        assertEquals(
                "WARNING",
                health.getRating()
        );

    }

}