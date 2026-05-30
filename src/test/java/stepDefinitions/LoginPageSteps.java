package stepDefinitions;

import helpers.LoginPageHelper;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginPageSteps {

    private LoginPageHelper loginPageHelper;

    public LoginPageSteps(){
        loginPageHelper = new LoginPageHelper();
    }

    @Given("^User is on the login page$")
    public void user_on_login_page(){
        Assert.assertTrue(loginPageHelper.verifyLoginPage());
    }

    @And("User logins into the application using {string} and {string}")
    public void user_logins_into_website(String email, String password){
        Assert.assertTrue(loginPageHelper.login(email, password));
    }
}
