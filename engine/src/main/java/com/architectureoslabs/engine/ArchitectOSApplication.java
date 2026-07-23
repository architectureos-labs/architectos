package com.architectureoslabs.engine;

import com.architectureoslabs.engine.analyzer.RepositoryAnalyzer;
import com.architectureoslabs.engine.model.SoftwareComponent;


/**
 * Main entry point for ArchitectOS Analysis Engine.
 *
 * This class initializes the architecture analysis platform.
 */
public class ArchitectOSApplication {


    public static void main(String[] args) {


        System.out.println(
                "ArchitectOS Analysis Engine initialized"
        );


        RepositoryAnalyzer analyzer =
                new RepositoryAnalyzer();


        SoftwareComponent component =
                analyzer.analyze(
                        "sample-repository"
                );


        System.out.println(
                "Analysis Result:"
        );


        System.out.println(component);

    }

}
