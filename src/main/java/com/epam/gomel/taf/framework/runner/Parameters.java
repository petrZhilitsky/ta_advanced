package com.epam.gomel.taf.framework.runner;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.Parameter;
import com.epam.gomel.taf.framework.enums.*;
import org.apache.log4j.xml.DOMConfigurator;

public class Parameters {
    private static Parameters instance;

    @Parameter(names = "--help", help = false, description = "Help")
    private boolean help;

    @Parameter(names = {"--headless", "-h"}, description = "Headless launch")
    private boolean headless = false;

    @Parameter(names = {"--browser", "-b"}, description = "Browser type", converter = BrowserTypeConverter.class, required = true)
    private static BrowserType browserType = BrowserType.CHROME;

    @Parameter(names = {"--suite", "-s"}, description = "Suite type", converter = SuiteTypeConverter.class, required = true)
    private static SuiteType suiteType = SuiteType.ALL;

    @Parameter(names = {"--all", "-a"}, description = "Path to All test suite")
    private static String allSuite = "src/main/resources/testng-all.xml";

    @Parameter(names = {"--parallel", "-pa"}, description = "Path to Parallel test suite")
    private static String parallelSuite = "src/main/resources/testng-parallel.xml";

    @Parameter(names = {"--smoke", "-sm"}, description = "Path to Smoke test suite")
    private static String smokeSuite = "src/main/resources/testng-smoke.xml";

    @Parameter(names = {"--junit", "-ju"}, description = "Path to Junit test suite")
    private static String junitSuite = "src/main/resources/testng-junit.xml";

    @Parameter(names = {"--properties", "-pr"}, description = "Path to log4j.xml")
    private static String properties = "src/main/resources/log4j.xml";

    private Parameters() {
    }

    public static synchronized Parameters instance() {
        if (instance == null) {
            instance = new Parameters();
        }
        return instance;
    }

    public boolean isHelp() {
        return help;
    }

    public boolean isHeadless() {
        return headless;
    }

    public BrowserType getBrowserType() {
        return browserType;
    }

    public String getProperties() {
        DOMConfigurator.configure("src/main/resources/log4j.xml");
        return properties;
    }

    public SuiteType getSuiteType() {
        return suiteType;
    }

    public String getAllSuite() {
        return allSuite;
    }

    public String getParallelSuite() {
        return parallelSuite;
    }

    public String getSmokeSuite() {
        return smokeSuite;
    }

    public String getJunitSuite() {
        return junitSuite;
    }

    public static class BrowserTypeConverter implements IStringConverter<BrowserType> {
        public BrowserType convert(String s) {
            return BrowserType.valueOf(s.toUpperCase());
        }
    }

    public static class SuiteTypeConverter implements IStringConverter<SuiteType> {
        public SuiteType convert(String s) {
            return SuiteType.valueOf(s.toUpperCase());
        }
    }
}
