package helpers;

import base.BaseTest;
import pages.CartPagePO;

public class CartPageHelper extends BaseTest {

    CartPagePO cartPagePO;

    public CartPageHelper(){
        this.cartPagePO = new CartPagePO(driver);
    }
    public boolean verifyCartItems(String products_To_Add){
        try{
            waitUtil.waitForVisible(cartPagePO.pageTitle);
            System.out.println("Verified Cart Page: " + waitUtil.waitForVisible(cartPagePO.pageTitle).getText());
            String[] products = products_To_Add.split(",");
            for(String product: products){
                cartPagePO.getProductLocator(product);
                System.out.println("Verified " + product + " in the cart");
                cartPagePO.addQuantityButton(product).click();
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
            waitUtil.waitForVisible(cartPagePO.checkoutButton);
            waitUtil.waitForClickable(cartPagePO.checkoutButton).click();
            System.out.println("Clicked Checkout Button");
            return true;
        }
        catch (Exception e){
            System.out.println("Error clicking Checkout button: " + e.getMessage());
            return false;
        }
    }
}
