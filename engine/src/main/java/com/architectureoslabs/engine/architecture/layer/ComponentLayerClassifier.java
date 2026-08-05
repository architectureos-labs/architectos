package com.architectureoslabs.engine.architecture.layer;


/**
 * Classifies components into architecture layers.
 */
public class ComponentLayerClassifier {


    public ArchitectureLayer classify(
            String componentName
    ) {

        return classify(
                componentName,
                ""
        );

    }



    public ArchitectureLayer classify(
            String componentName,
            String packageName
    ) {

        String name =
                componentName == null
                        ? ""
                        : componentName.toLowerCase();

        String pkg =
                packageName == null
                        ? ""
                        : packageName.toLowerCase();

        if (pkg.contains("controller")
                || name.endsWith("controller")) {

            return ArchitectureLayer.CONTROLLER;

        }

        if (pkg.contains("service")
                || name.endsWith("service")) {

            return ArchitectureLayer.SERVICE;

        }

        if (pkg.contains("repository")
                || name.endsWith("repository")) {

            return ArchitectureLayer.REPOSITORY;

        }

        if (pkg.contains("domain")
                || pkg.contains("entity")
                || pkg.contains("model")
                || name.endsWith("entity")
                || name.endsWith("model")) {

            return ArchitectureLayer.DOMAIN;

        }

        return ArchitectureLayer.UNKNOWN;

    }

}