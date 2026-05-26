package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = "src/main/features",
        glue = {"stepDefinitions", "src/main/base", "hooks"},
        tags = "@E2E",
        monochrome = true,
        plugin = {}
)
@Listeners(listeners.TestNGListener.class)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
