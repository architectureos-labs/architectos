package com.architectureoslabs.engine.architecture.layer;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


/**
 * Tests component layer classification.
 */
public class ComponentLayerClassifierTest {


    @Test
    void shouldClassifyController() {


        ComponentLayerClassifier classifier =
                new ComponentLayerClassifier();


        assertEquals(
                ArchitectureLayer.CONTROLLER,
                classifier.classify(
                        "OrderController"
                )
        );

    }



    @Test
    void shouldClassifyRepository() {


        ComponentLayerClassifier classifier =
                new ComponentLayerClassifier();


        assertEquals(
                ArchitectureLayer.REPOSITORY,
                classifier.classify(
                        "OrderRepository"
                )
        );

    }

}