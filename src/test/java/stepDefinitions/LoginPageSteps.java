package stepDefinitions;

import helpers.LoginPageHelper;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginPageSteps {

    LoginPageHelper loginPageHelper;

    public LoginPageSteps(){
        this.loginPageHelper = new LoginPageHelper();
    }

    @Given("^User is on the login page$")
    public void user_on_login_page(){
        Assert.assertTrue(loginPageHelper.launchApplication());
        Assert.assertTrue(loginPageHelper.verifyLoginPage());
    }

    @And("User logins into the application using {string} and {string}")
    public void user_logins_into_website(String email, String password){
        Assert.assertTrue(loginPageHelper.login(email, password));
    }
}
