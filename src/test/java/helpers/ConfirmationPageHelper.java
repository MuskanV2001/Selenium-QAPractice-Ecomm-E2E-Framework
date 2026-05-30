package helpers;

import base.BaseTest;
import pages.ConfirmationPagePO;

public class ConfirmationPageHelper extends BaseTest {

    private ConfirmationPagePO confirmationPagePO;

    public ConfirmationPageHelper(){
        confirmationPagePO = new ConfirmationPagePO();
    }

    public boolean verifyOrderConfirmation(){
        try{
            getWaitUtil().waitForVisible(confirmationPagePO.pageTitle);
            System.out.println("Verified Confirmation Page: " + getWaitUtil().waitForClickable(confirmationPagePO.pageTitle).getText());
            getWaitUtil().waitForVisible(confirmationPagePO.confirmationMessage);
            System.out.println("Verified Confirmation Message: " + getWaitUtil().waitForVisible(confirmationPagePO.confirmationMessage).getText());
            getWaitUtil().waitForVisible(confirmationPagePO.infoMessage);
            System.out.println("Verified Informational Message: " + getWaitUtil().waitForVisible(confirmationPagePO.infoMessage).getText());
            return true;
        }
        catch (Exception e){
            System.out.println("Error verifying order confirmation: " + e.getMessage());
            return false;
        }
    }

    public boolean clickContinueShopping(){
        try{
            getWaitUtil().waitForVisible(confirmationPagePO.continueShoppingButton);
            getWaitUtil().waitForClickable(confirmationPagePO.continueShoppingButton).click();
            System.out.println("Clicked Continue Shopping button");
            return true;
        }
        catch (Exception e){
            System.out.println("Error clicking Continue Shopping button: " + e.getMessage());
            return false;
        }
    }
}
