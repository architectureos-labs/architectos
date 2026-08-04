package com.architectureoslabs.engine.analysis.hotspot;


/**
 * Represents an architectural dependency hotspot.
 */
public class DependencyHotspot {


    private final ComponentCouplingMetrics metrics;


    private final String riskLevel;



    public DependencyHotspot(
            ComponentCouplingMetrics metrics,
            String riskLevel
    ) {

        this.metrics = metrics;
        this.riskLevel = riskLevel;

    }



    public ComponentCouplingMetrics getMetrics() {

        return metrics;

    }



    public String getRiskLevel() {

        return riskLevel;

    }

}