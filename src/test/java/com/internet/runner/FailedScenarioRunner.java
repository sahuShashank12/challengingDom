package com.internet.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@src/test/resources/failedScenario.txt",
        glue = {"com/internet/stepDefinitions", "com/internet/apphooks"},
        tags= "@Functional", //@Regression or
        monochrome = true,
        plugin = {"pretty",
                "rerun:target/failedScenario.txt"
        }
)
public class FailedScenarioRunner {
}
