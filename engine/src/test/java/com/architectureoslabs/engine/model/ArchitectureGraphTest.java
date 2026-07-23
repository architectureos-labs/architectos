package com.architectureoslabs.engine.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests ArchitectureGraph behavior.
 */
public class ArchitectureGraphTest {



    @Test
    void shouldStoreComponentsAndDependencies() {


        ArchitectureGraph graph =
                new ArchitectureGraph();



        SoftwareComponent paymentService =
                new SoftwareComponent(
                        "PaymentService",
                        "class"
                );



        Dependency dependency =
                new Dependency(
                        "PaymentService",
                        "PaymentRepository"
                );



        graph.addComponent(
                paymentService
        );



        graph.addDependency(
                dependency
        );



        assertEquals(
                1,
                graph.getComponents()
                        .size()
        );



        assertEquals(
                1,
                graph.getDependencies()
                        .size()
        );

    }

}
