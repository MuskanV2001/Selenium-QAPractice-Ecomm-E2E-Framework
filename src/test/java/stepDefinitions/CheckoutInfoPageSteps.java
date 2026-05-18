package stepDefinitions;

import helpers.CheckoutInfoPageHelper;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class CheckoutInfoPageSteps {

    CheckoutInfoPageHelper checkoutInfoPageHelper;

    public CheckoutInfoPageSteps(){
        this.checkoutInfoPageHelper = new CheckoutInfoPageHelper();
    }

    @And("User navigates to the Checkout information details page to enter {string},{string}")
    public void user_navigates_checkoutInfo_to_enter_details(String firstname, String lastname){
        Assert.assertTrue(checkoutInfoPageHelper.verifyCheckoutInfoPage());
        Assert.assertTrue(checkoutInfoPageHelper.enterUserDetails(firstname, lastname));
    }
}
