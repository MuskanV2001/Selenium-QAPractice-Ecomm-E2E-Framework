package helpers;

import base.BaseTest;
import pages.CheckoutReviewPagePO;

public class   CheckoutReviewPageHelper extends BaseTest {

    CheckoutReviewPagePO checkoutReviewPagePO;

    public CheckoutReviewPageHelper(){
        checkoutReviewPagePO = new CheckoutReviewPagePO(driver);
    }

    public boolean verifyCheckoutReviewPage(){
        try{
            waitUtil.waitForVisible(checkoutReviewPagePO.pageTitle);
            System.out.println("Verified Checkout Review Page: " + waitUtil.waitForVisible(checkoutReviewPagePO.pageTitle).getText());
            return true;
        }
        catch (Exception e){
            System.out.println("Error validating Checkout Review Page" + e.getMessage());
            return false;
        }
    }

    public boolean verifyOrderDetails(){
        try{
            waitUtil.waitForVisible(checkoutReviewPagePO.paymentInfoHeader);
            System.out.println("Verified Payment Info Header");
            waitUtil.waitForVisible(checkoutReviewPagePO.paymentInfo);
            System.out.println("Verified Payment Info: " + waitUtil.waitForVisible(checkoutReviewPagePO.paymentInfo).getText());
            waitUtil.waitForVisible(checkoutReviewPagePO.shippingInfoHeader);
            System.out.println("Verified Shipping Info Header");
            waitUtil.waitForVisible(checkoutReviewPagePO.shippingInfo);
            System.out.println("Verified Shipping Info: " + waitUtil.waitForVisible(checkoutReviewPagePO.shippingInfo).getText());
            waitUtil.waitForVisible(checkoutReviewPagePO.priceTotalHeader);
            System.out.println("Verified Price Total Header");
            waitUtil.waitForVisible(checkoutReviewPagePO.itemTotal);
            System.out.println("Verified Item Total amount: " + waitUtil.waitForVisible(checkoutReviewPagePO.itemTotal).getText());
            waitUtil.waitForVisible(checkoutReviewPagePO.taxAmount);
            System.out.println("Verified tax amount: " + waitUtil.waitForVisible(checkoutReviewPagePO.taxAmount).getText());
            waitUtil.waitForVisible(checkoutReviewPagePO.totalAmount);
            System.out.println("Verified total amount: " + waitUtil.waitForVisible(checkoutReviewPagePO.totalAmount).getText());
            return true;
        }
        catch (Exception e){
            System.out.println("Error verifying order items: " + e.getMessage());
            return false;
        }
    }

    public boolean finishToSubmit(){
        try{
            waitUtil.scrollElementIntoView(checkoutReviewPagePO.finishButton);
            waitUtil.waitForVisible(checkoutReviewPagePO.finishButton);
            waitUtil.waitForClickable(checkoutReviewPagePO.finishButton).click();
            System.out.println("Clicked Finish to submit order");
            return true;
        }
        catch (Exception e){
            System.out.println("Error clicking Finish button: " + e.getMessage());
            return false;
        }
    }
}
