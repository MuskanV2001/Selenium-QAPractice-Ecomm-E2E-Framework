package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/features",
        glue = {"stepDefinitions", "base"},
        tags = "@E2E",
        monochrome = true,
        plugin = {}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
