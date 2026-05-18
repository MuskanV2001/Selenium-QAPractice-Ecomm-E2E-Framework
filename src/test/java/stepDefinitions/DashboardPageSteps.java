package stepDefinitions;

import helpers.DashboardPageHelper;
import helpers.LoginPageHelper;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class DashboardPageSteps {

    DashboardPageHelper dashboardPageHelper;
    LoginPageHelper loginPageHelper;

    public DashboardPageSteps(){
        this.dashboardPageHelper = new DashboardPageHelper();
        this.loginPageHelper = new LoginPageHelper();
    }
    @And("User lands on the Dashboard page to view items")
    public void user_lands_on_dashboard_to_view_items(){
        Assert.assertTrue(dashboardPageHelper.verifyDashboardPage());
    }

    @And("User selects the products {string} and adds them into cart")
    public void user_select_products_and_adds_to_cart(String productsToAdd){
        Assert.assertTrue(dashboardPageHelper.selectProducts(productsToAdd));
    }

    @And("User clicks Logout button to logout of the website")
    public void user_clicks_logout_button(){
        Assert.assertTrue(dashboardPageHelper.logout());
        Assert.assertTrue(loginPageHelper.verifyLoginPage());
    }
}
