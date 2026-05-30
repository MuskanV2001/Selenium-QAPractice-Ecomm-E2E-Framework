package helpers;

import base.BaseTest;
import pages.CheckoutInfoPagePO;
import pages.CheckoutReviewPagePO;

public class CheckoutInfoPageHelper extends BaseTest {

    private CheckoutInfoPagePO checkoutInfoPagePO;

    public CheckoutInfoPageHelper(){
        checkoutInfoPagePO = new CheckoutInfoPagePO();
    }

    public boolean verifyCheckoutInfoPage(){
        try{
            getWaitUtil().waitForVisible(checkoutInfoPagePO.pageTitle);
            System.out.println("Verified Checkout Information Page: " + getWaitUtil().waitForVisible(checkoutInfoPagePO.pageTitle).getText());
            return true;
        }
        catch (Exception e){
            System.out.println("Error validating Checkout Info page: " + e.getMessage());
            return false;
        }
    }

    public boolean enterUserDetails(String firstname, String lastname){
        try{
            getWaitUtil().waitForVisible(checkoutInfoPagePO.firstNameInput).sendKeys(firstname);
            System.out.println("Entered user's firstname: " + firstname);
            getWaitUtil().waitForVisible(checkoutInfoPagePO.lastNameInput).sendKeys(lastname);
            System.out.println("Entered user's lastname: " + lastname);
            getWaitUtil().waitForVisible(checkoutInfoPagePO.zipcodeInput);
            System.out.println("ZipCode displayed");
            getWaitUtil().scrollElementIntoView(checkoutInfoPagePO.continueButton);
            getWaitUtil().waitForVisible(checkoutInfoPagePO.continueButton);
            getWaitUtil().waitForClickable(checkoutInfoPagePO.continueButton).click();
            System.out.println("Clicked Continue button");
            return true;
        }
        catch (Exception e){
            System.out.println("Error entering User details: " + e.getMessage());
            return false;
        }
    }
}
