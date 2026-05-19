package helpers;

import base.BaseTest;
import pages.ConfirmationPagePO;

public class ConfirmationPageHelper extends BaseTest {

    ConfirmationPagePO confirmationPagePO;

    public ConfirmationPageHelper(){
        confirmationPagePO = new ConfirmationPagePO(driver);
    }

    public boolean verifyOrderConfirmation(){
        try{
            waitUtil.waitForVisible(confirmationPagePO.pageTitle);
            System.out.println("Verified Confirmation Page: " + waitUtil.waitForClickable(confirmationPagePO.pageTitle).getText());
            waitUtil.waitForVisible(confirmationPagePO.confirmationMessage);
            System.out.println("Verified Confirmation Message: " + waitUtil.waitForVisible(confirmationPagePO.confirmationMessage).getText());
            waitUtil.waitForVisible(confirmationPagePO.infoMessage);
            System.out.println("Verified Informational Message: " + waitUtil.waitForVisible(confirmationPagePO.infoMessage).getText());
            return true;
        }
        catch (Exception e){
            System.out.println("Error verifying order confirmation: " + e.getMessage());
            return false;
        }
    }

    public boolean clickContinueShopping(){
        try{
            waitUtil.waitForVisible(confirmationPagePO.continueShoppingButton);
            waitUtil.waitForClickable(confirmationPagePO.continueShoppingButton).click();
            System.out.println("Clicked Continue Shopping button");
            return true;
        }
        catch (Exception e){
            System.out.println("Error clicking Continue Shopping button: " + e.getMessage());
            return false;
        }
    }
}
