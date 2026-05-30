package helpers;

import base.BaseTest;
import pages.LoginPagePO;

public class LoginPageHelper extends BaseTest {

    private LoginPagePO loginPagePO;

    public LoginPageHelper(){
        loginPagePO = new LoginPagePO();
    }

    public boolean verifyLoginPage(){
        try {
            getWaitUtil().waitForVisible(loginPagePO.pageLogo);
            System.out.println("Verified Login Page Logo");
            getWaitUtil().waitForVisible(loginPagePO.pageTitle);
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
            getWaitUtil().waitForVisible(loginPagePO.emailInput).sendKeys(email);
            System.out.println("Entered email id: " + email);
            getWaitUtil().waitForVisible(loginPagePO.passwordInput).sendKeys(password);
            System.out.println("Entered password: " + password);
            Thread.sleep(1000);
            getWaitUtil().scrollElementIntoView(loginPagePO.loginButton);
            getWaitUtil().waitForVisible(loginPagePO.loginButton);
            getWaitUtil().waitForClickable(loginPagePO.loginButton).click();
            System.out.println("Clicked Login Button");
            return true;
        }
        catch (Exception e){
            System.out.println("Error logging in: " + e.getMessage());
            return false;
        }
    }
}
