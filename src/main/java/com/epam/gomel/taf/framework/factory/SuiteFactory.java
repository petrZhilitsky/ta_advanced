package com.epam.gomel.taf.framework.factory;

import com.epam.gomel.taf.framework.runner.Parameters;
import org.testng.TestNG;

import java.util.Collections;

public class SuiteFactory {
    private SuiteFactory() {
    }

    public static TestNG getSuite() {
        TestNG testNG = new TestNG();
        switch (Parameters.instance().getSuiteType()) {
            case ALL -> testNG.setTestSuites(Collections.singletonList(Parameters.instance().getAllSuite()));
            case PARALLEL -> testNG.setTestSuites(Collections.singletonList(Parameters.instance().getParallelSuite()));
            case SMOKE -> testNG.setTestSuites(Collections.singletonList(Parameters.instance().getSmokeSuite()));
            default -> testNG.setTestSuites(Collections.singletonList(Parameters.instance().getAllSuite()));
        }
        return testNG;
    }
}
