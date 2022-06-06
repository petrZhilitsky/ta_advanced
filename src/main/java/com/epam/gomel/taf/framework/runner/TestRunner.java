package com.epam.gomel.taf.framework.runner;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import com.epam.gomel.taf.framework.factory.SuiteFactory;
import org.apache.log4j.PropertyConfigurator;

import static com.epam.gomel.taf.framework.logger.Log.info;
import static com.epam.gomel.taf.framework.logger.Log.debug;
import static com.epam.gomel.taf.framework.logger.Log.error;

public class TestRunner {
    public static void main(String[] args) {
        info("Parse CLIs");
        parseCLI(args);
        info("Set log4j.xml");
        PropertyConfigurator.configure(Parameters.instance().getProperties());
        info("Start app");
        SuiteFactory.getSuite().run();
        info("Finish app");
    }

    private static void parseCLI(String[] args) {
        debug("Parsing CLIs using JCommander");
        JCommander jCommander = new JCommander(Parameters.instance());
        try {
            jCommander.parse(args);
        } catch (ParameterException e) {
            error(e.getMessage());
            System.exit(1);
        }
        if (Parameters.instance().isHelp()) {
            jCommander.usage();
            System.exit(0);
        }
    }
}
