package stepDefinitions;

import helpers.CheckoutReviewPageHelper;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class CheckoutReviewPageSteps {

    CheckoutReviewPageHelper checkoutReviewPageHelper;

    public CheckoutReviewPageSteps(){
        this.checkoutReviewPageHelper = new CheckoutReviewPageHelper();
    }

    @And("User navigates to the Checkout Review Page")
    public void user_navigates_to_Checkout_Review_page(){
        Assert.assertTrue(checkoutReviewPageHelper.verifyCheckoutReviewPage());
    }

    @And("User verifies the order details on Checkout Review Page")
    public void user_verifies_order_details(){
        Assert.assertTrue(checkoutReviewPageHelper.verifyOrderDetails());
    }

    @When("User clicks on the Finish button on Review page")
    public void user_clicks_finish_button(){
        Assert.assertTrue(checkoutReviewPageHelper.finishToSubmit());
    }
}
