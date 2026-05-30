package hooks;

import base.BaseTest;
import io.cucumber.java.*;
import utils.BrowserDriverManager;

public class CucumberHooks extends BaseTest{

    @Before
    public void beforeScenario(Scenario scenario){
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("STARTING SCENARIO | THREAD ID: %d | %s \n" ,Thread.currentThread().getId(),scenario.getName());
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        // Launching the Application
        launchApp();
    }

    @After
    public void tear_down(Scenario scenario){
        try {
            tearDown();
        } catch (Exception e) {
            System.out.println("Error in tear_down: " + e.getMessage());
        }
        System.out.println("AFTER HOOK COMPLETED - TEAR DOWN");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println("FINISHED SCENARIO  " + scenario.getName());
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    }
}
