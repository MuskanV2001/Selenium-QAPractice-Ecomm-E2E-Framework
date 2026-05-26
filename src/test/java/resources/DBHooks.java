package resources;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DBTestDataContext;

import java.util.Map;

public class DBHooks {

    @Before
    public void beforeScenario(Scenario scenario){
        Map<Object, Object> record = DBTestDataContext.nextRecord();
        if(record != null){
            System.out.println("[DBHooks] Scenario '" + scenario.getName() + "' will run with DB record: " + record);
        } else {
            System.out.println("[DBHooks] No DB record available for scenario '" + scenario.getName() + "'.");
        }
    }

    @After
    public void afterScenario(Scenario scenario){
        // cleanup thread-local
        DBTestDataContext.clear();
    }
}

