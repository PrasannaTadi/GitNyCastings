package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed_scenarios.txt",  // Note the '@' sign
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty"},
        monochrome = true
)
public class FailedTestRunner {
}
