package helpers;

import base.BaseTest;
import pages.CartPagePO;

public class CartPageHelper extends BaseTest {

    private CartPagePO cartPagePO;

    public CartPageHelper(){
        cartPagePO = new CartPagePO();
    }
    public boolean verifyCartItems(String products_To_Add){
        try{
            getWaitUtil().waitForVisible(cartPagePO.pageTitle);
            System.out.println("Verified Cart Page: " + getWaitUtil().waitForVisible(cartPagePO.pageTitle).getText());
            String[] products = products_To_Add.split(",");
            for(String product: products){
                cartPagePO.getProductLocator(product);
                System.out.println("Verified " + product + " in the cart");
                cartPagePO.addQuantityButton(product).click();
                Thread.sleep(500);
                System.out.println("Increased Quantity for product: " + product);
            }
            return true;
        }
        catch (Exception e){
            System.out.println("Error validating Cart items: " + e.getMessage());
            return false;
        }
    }

    public boolean clickCheckoutButton(){
        try{
            getWaitUtil().scrollElementIntoView(cartPagePO.checkoutButton);
            getWaitUtil().waitForVisible(cartPagePO.checkoutButton);
            getWaitUtil().waitForClickable(cartPagePO.checkoutButton).click();
            System.out.println("Clicked Checkout Button");
            return true;
        }
        catch (Exception e){
            System.out.println("Error clicking Checkout button: " + e.getMessage());
            return false;
        }
    }
}
