package helpers;

import base.BaseTest;
import pages.CheckoutInfoPagePO;

public class CheckoutInfoPageHelper extends BaseTest {

    CheckoutInfoPagePO checkoutInfoPagePO;

    public CheckoutInfoPageHelper(){
        checkoutInfoPagePO = new CheckoutInfoPagePO(driver);
    }

    public boolean verifyCheckoutInfoPage(){
        try{
            waitUtil.waitForVisible(checkoutInfoPagePO.pageTitle);
            System.out.println("Verified Checkout Information Page: " + waitUtil.waitForVisible(checkoutInfoPagePO.pageTitle).getText());
            return true;
        }
        catch (Exception e){
            System.out.println("Error validating Checkout Info page: " + e.getMessage());
            return false;
        }
    }

    public boolean enterUserDetails(String firstname, String lastname){
        try{
            waitUtil.waitForVisible(checkoutInfoPagePO.firstNameInput).sendKeys(firstname);
            System.out.println("Entered user's firstname: " + firstname);
            waitUtil.waitForVisible(checkoutInfoPagePO.lastNameInput).sendKeys(lastname);
            System.out.println("Entered user's lastname: " + lastname);
            waitUtil.waitForVisible(checkoutInfoPagePO.zipcodeInput);
            System.out.println("ZipCode displayed");
            waitUtil.scrollElementIntoView(checkoutInfoPagePO.continueButton);
            waitUtil.waitForVisible(checkoutInfoPagePO.continueButton);
            waitUtil.waitForClickable(checkoutInfoPagePO.continueButton).click();
            System.out.println("Clicked Continue button");
            return true;
        }
        catch (Exception e){
            System.out.println("Error entering User details: " + e.getMessage());
            return false;
        }
    }
}
