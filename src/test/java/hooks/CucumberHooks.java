package hooks;

import base.BaseTest;
import io.cucumber.java.*;

public class CucumberHooks extends BaseTest{

    @Before
    public void beforeScenario(Scenario scenario){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("STARTING SCENARIO  " + scenario.getName());
        System.out.println("------------------------------------------------------------------------------------------");
    }

    @After
    public void tear_down(Scenario scenario){
        if (driver != null) {
            driver.quit();
        }
        System.out.println("AFTER HOOK EXECUTED - TEAR DOWN");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("FINISHED SCENARIO  " + scenario.getName());
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
