package com.architectureoslabs.engine.config;


import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;


/**
 * Loads architecture rules from YAML configuration.
 */
public class ArchitectureRuleConfigLoader {


    public ArchitectureRuleConfiguration load() {


        Yaml yaml =
                new Yaml();


        InputStream input =
                getClass()
                        .getClassLoader()
                        .getResourceAsStream(
                                "architecture-rules.yaml"
                        );


        if (input == null) {

            throw new IllegalStateException(
                    "architecture-rules.yaml not found"
            );

        }


        Map<String, Object> data =
                yaml.load(input);


        Map<String, Object> layers =
                (Map<String, Object>)
                        data.get("layers");


        Map<String, List<String>> allowed =
                new java.util.HashMap<>();


        for (Map.Entry<String, Object> entry
                : layers.entrySet()) {


            Map<String, Object> layerConfig =
                    (Map<String, Object>)
                            entry.getValue();


            List<String> allowedLayers =
                    (List<String>)
                            layerConfig.get(
                                    "allowed"
                            );


            allowed.put(
                    entry.getKey(),
                    allowedLayers
            );

        }


        return new ArchitectureRuleConfiguration(
                allowed
        );

    }

}