package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = "src/main/features",
        glue = {"stepDefinitions", "src/main/base", "hooks"},
        tags = "@E2E",
        monochrome = true,
        plugin = {"json:target/cucumberReports/cucumber.json"}
)
@Listeners(listeners.TestNGListener.class)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    // Separates each feature file scenario as an isolated test for parallel execution
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
