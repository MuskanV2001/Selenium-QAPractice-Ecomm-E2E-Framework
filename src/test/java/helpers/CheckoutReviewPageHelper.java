package helpers;

import base.BaseTest;
import pages.CheckoutReviewPagePO;

public class   CheckoutReviewPageHelper extends BaseTest {

    private CheckoutReviewPagePO checkoutReviewPagePO;

    public CheckoutReviewPageHelper(){
        checkoutReviewPagePO = new CheckoutReviewPagePO();
    }

    public boolean verifyCheckoutReviewPage(){
        try{
            getWaitUtil().waitForVisible(checkoutReviewPagePO.pageTitle);
            System.out.println("Verified Checkout Review Page: " + getWaitUtil().waitForVisible(checkoutReviewPagePO.pageTitle).getText());
            return true;
        }
        catch (Exception e){
            System.out.println("Error validating Checkout Review Page" + e.getMessage());
            return false;
        }
    }

    public boolean verifyOrderDetails(){
        try{
            getWaitUtil().waitForVisible(checkoutReviewPagePO.paymentInfoHeader);
            System.out.println("Verified Payment Info Header");
            getWaitUtil().waitForVisible(checkoutReviewPagePO.paymentInfo);
            System.out.println("Verified Payment Info: " + getWaitUtil().waitForVisible(checkoutReviewPagePO.paymentInfo).getText());
            getWaitUtil().waitForVisible(checkoutReviewPagePO.shippingInfoHeader);
            System.out.println("Verified Shipping Info Header");
            getWaitUtil().waitForVisible(checkoutReviewPagePO.shippingInfo);
            System.out.println("Verified Shipping Info: " + getWaitUtil().waitForVisible(checkoutReviewPagePO.shippingInfo).getText());
            getWaitUtil().waitForVisible(checkoutReviewPagePO.priceTotalHeader);
            System.out.println("Verified Price Total Header");
            getWaitUtil().waitForVisible(checkoutReviewPagePO.itemTotal);
            System.out.println("Verified Item Total amount: " + getWaitUtil().waitForVisible(checkoutReviewPagePO.itemTotal).getText());
            getWaitUtil().waitForVisible(checkoutReviewPagePO.taxAmount);
            System.out.println("Verified tax amount: " + getWaitUtil().waitForVisible(checkoutReviewPagePO.taxAmount).getText());
            getWaitUtil().waitForVisible(checkoutReviewPagePO.totalAmount);
            System.out.println("Verified total amount: " + getWaitUtil().waitForVisible(checkoutReviewPagePO.totalAmount).getText());
            return true;
        }
        catch (Exception e){
            System.out.println("Error verifying order items: " + e.getMessage());
            return false;
        }
    }

    public boolean finishToSubmit(){
        try{
            getWaitUtil().scrollElementIntoView(checkoutReviewPagePO.finishButton);
            getWaitUtil().waitForVisible(checkoutReviewPagePO.finishButton);
            getWaitUtil().waitForClickable(checkoutReviewPagePO.finishButton).click();
            System.out.println("Clicked Finish to submit order");
            return true;
        }
        catch (Exception e){
            System.out.println("Error clicking Finish button: " + e.getMessage());
            return false;
        }
    }
}
