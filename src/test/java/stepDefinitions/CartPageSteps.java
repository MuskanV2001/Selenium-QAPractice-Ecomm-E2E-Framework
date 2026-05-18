package stepDefinitions;

import helpers.CartPageHelper;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class CartPageSteps {

    CartPageHelper cartPageHelper;

    public CartPageSteps(){
        this.cartPageHelper = new CartPageHelper();
    }

    @And("User opens the cart to verify {string} items on Cart page")
    public void user_opens_cart_to_verify_cart_items(String productsToAdd){
        Assert.assertTrue(cartPageHelper.verifyCartItems(productsToAdd));
        Assert.assertTrue(cartPageHelper.clickCheckoutButton());
    }
}
