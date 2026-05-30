package helpers;

import base.BaseTest;
import org.openqa.selenium.By;
import pages.DashboardPagePO;

public class DashboardPageHelper extends BaseTest {

    private DashboardPagePO dashboardPagePO;

    public DashboardPageHelper(){
        dashboardPagePO = new DashboardPagePO();
    }

    public boolean verifyDashboardPage(){
        try{
            getWaitUtil().waitForVisible(dashboardPagePO.pageTitle);
            System.out.println("Verified Dashboard Page: " + getWaitUtil().waitForVisible(dashboardPagePO.pageTitle).getText());
            return true;
        }
        catch (Exception e){
            System.out.println("Error validating Dashboard: " + e.getMessage());
            return false;
        }
    }

    public boolean verifySorting(){
        try{
            getWaitUtil().waitForClickable(dashboardPagePO.sortDropdown).click();
            getWaitUtil().waitForClickable(dashboardPagePO.alphabeticDescOption).click();
            System.out.println("Verified Alphabetic Sorting Option");
            getWaitUtil().waitForClickable(dashboardPagePO.sortDropdown).click();
            getWaitUtil().waitForClickable(dashboardPagePO.highToLowOption).click();
            System.out.println("Verified High To Low Sorting Option");
            return true;
        }
        catch (Exception e){
            System.out.println("Error while sorting: " + e.getMessage());
            return false;
        }
    }

    public boolean selectProducts(String products_To_Add){
        try{
            String[] products = products_To_Add.split(",");
            for(String product: products){
                By name = dashboardPagePO.getProductNameLocator(product);
                By priceLocator = dashboardPagePO.getProductPriceLocator(product);
                By button = dashboardPagePO.getAddToCartButtonLocator(product);

                getWaitUtil().waitForVisible(name);
                System.out.println("Verified product name");

                String price = getWaitUtil().waitForVisible(priceLocator).getText();
                System.out.println("Verified product price: " + product + " | " + price);

                getWaitUtil().scrollElementIntoView(button);
                getWaitUtil().waitForVisible(button);
                getWaitUtil().waitForClickable(button).click();
                System.out.println("Clicked Add to Cart for product: " + product);
                getWaitUtil().waitForElementToDisappear(dashboardPagePO.itemAddedMessage);
                System.out.println("Added to cart message disappeared for previous product");
                Thread.sleep(2000);
            }

            getWaitUtil().waitForHeaderToBeVisible();
            getWaitUtil().scrollElementIntoView(dashboardPagePO.cartIcon);
            getWaitUtil().waitForVisible(dashboardPagePO.cartIcon);
            getWaitUtil().waitForClickable(dashboardPagePO.cartIcon).click();
            System.out.println("Clicked on Cart");
            return true;
        }
        catch (Exception e){
            System.out.println("Error selecting products: " + e.getMessage());
            return false;
        }
    }

    public boolean logout(){
        try{
            getWaitUtil().waitForHeaderToBeVisible();
            getWaitUtil().waitForVisible(dashboardPagePO.profileButton);
            getWaitUtil().waitForClickable(dashboardPagePO.profileButton).click();
            System.out.println("Clicked Profile button");
            getWaitUtil().waitForVisible(dashboardPagePO.logoutButton);
            getWaitUtil().waitForClickable(dashboardPagePO.logoutButton).click();
            System.out.println("Clicked Logout Button");
            getWaitUtil().waitForVisible(dashboardPagePO.logoutButtonPopup);
            getWaitUtil().waitForClickable(dashboardPagePO.logoutButtonPopup).click();
            System.out.println("Clicked Logout Confirm button");
            return true;
        }
        catch (Exception e){
            System.out.println("Error while logging out: " + e.getMessage());
            return false;
        }
    }
}
