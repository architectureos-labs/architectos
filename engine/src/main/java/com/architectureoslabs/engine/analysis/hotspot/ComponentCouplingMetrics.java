package com.architectureoslabs.engine.analysis.hotspot;


/**
 * Represents coupling metrics for a software component.
 */
public class ComponentCouplingMetrics {


    private final String componentName;


    private final int incomingDependencies;


    private final int outgoingDependencies;



    public ComponentCouplingMetrics(
            String componentName,
            int incomingDependencies,
            int outgoingDependencies
    ) {

        this.componentName = componentName;
        this.incomingDependencies = incomingDependencies;
        this.outgoingDependencies = outgoingDependencies;

    }



    public String getComponentName() {

        return componentName;

    }



    public int getIncomingDependencies() {

        return incomingDependencies;

    }



    public int getOutgoingDependencies() {

        return outgoingDependencies;

    }



    public int getCouplingScore() {

        return incomingDependencies
                + outgoingDependencies;

    }

}