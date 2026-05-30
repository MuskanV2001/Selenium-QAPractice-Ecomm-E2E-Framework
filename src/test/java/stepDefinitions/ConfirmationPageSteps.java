package stepDefinitions;

import helpers.ConfirmationPageHelper;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ConfirmationPageSteps {

    private ConfirmationPageHelper confirmationPageHelper;

    public ConfirmationPageSteps(){
        confirmationPageHelper = new ConfirmationPageHelper();
    }

    @Then("User is navigated to the Order Confirmation Page")
    public void user_navigates_Order_confirmation_page(){
        Assert.assertTrue(confirmationPageHelper.verifyOrderConfirmation());
    }

    @And("User clicks on the Continue Shopping button to land back on the Dashboard page")
    public void user_clicks_continue_shopping_button(){
        Assert.assertTrue(confirmationPageHelper.clickContinueShopping());
    }
}
