package com.epam.gomel.taf.framework.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "com.epam.gomel.taf.test.steps",
        tags = "@cucumber",
        plugin = {
                "pretty", "json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        }
)

public class CucumberRunner {
}
