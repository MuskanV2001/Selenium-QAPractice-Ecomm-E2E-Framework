package helpers;

import base.BaseTest;
import pages.LoginPagePO;

public class LoginPageHelper extends BaseTest {

    LoginPagePO loginPagePO;

    public LoginPageHelper(){
        this.loginPagePO = new LoginPagePO(driver);
    }

    public boolean launchApplication(){
        try{
            launchApp();
            return true;
        }
        catch (Exception e){
            System.out.println("Error launching Application: " + e.getMessage());
            return false;
        }
    }

    public boolean verifyLoginPage(){
        try {
            waitUtil.waitForVisible(loginPagePO.pageLogo);
            System.out.println("Verified Login Page Logo");
            waitUtil.waitForVisible(loginPagePO.pageTitle);
            System.out.println("Verified Login Page Title");
            return true;
        }
        catch (Exception e) {
            System.out.println("Error validating login Page: " + e.getMessage());
            return false;
        }
    }

    public boolean login(String email, String password){
        try{
            waitUtil.waitForVisible(loginPagePO.emailInput).sendKeys(email);
            System.out.println("Entered email id: " + email);
            waitUtil.waitForVisible(loginPagePO.passwordInput).sendKeys(password);
            System.out.println("Entered password: " + password);
            waitUtil.waitForVisible(loginPagePO.loginButton);
            waitUtil.waitForClickable(loginPagePO.loginButton).click();
            System.out.println("Clicked Login Button");
            return true;
        }
        catch (Exception e){
            System.out.println("Error logging in: " + e.getMessage());
            return false;
        }
    }
}
