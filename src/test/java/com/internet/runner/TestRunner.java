package com.internet.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/internet/stepDefinitions", "com/internet/apphooks"},
        tags= "@Functional" ,//or @Regression",
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", //"timeline:test-output-thread/,"
                 "rerun:src/test/resources/failedScenario.txt"
        }
)
public class TestRunner {
}
