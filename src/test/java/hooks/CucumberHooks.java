package hooks;

import io.cucumber.java.*;

public class CucumberHooks {

    @Before
    public void beforeScenario(Scenario scenario){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("STARTING SCENARIO  " + scenario.getName());
        System.out.println("------------------------------------------------------------------------------------------");
    }

    @After
    public void afterScenario(Scenario scenario){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("FINISHED SCENARIO  " + scenario.getName());
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
