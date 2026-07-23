package com.architectureoslabs.engine.model;

/**
 * Represents a software component discovered during architecture analysis.
 *
 * A component can represent:
 *
 * - Application module
 * - Package
 * - Service
 * - Logical architecture unit
 */
public class SoftwareComponent {

    private final String name;

    private final String type;


    public SoftwareComponent(String name, String type) {
        this.name = name;
        this.type = type;
    }


    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }


    @Override
    public String toString() {

        return "SoftwareComponent{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
