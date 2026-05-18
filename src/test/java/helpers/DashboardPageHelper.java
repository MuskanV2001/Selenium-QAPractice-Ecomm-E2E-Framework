package helpers;

import base.BaseTest;
import org.openqa.selenium.By;
import pages.DashboardPagePO;

public class DashboardPageHelper extends BaseTest {

    DashboardPagePO dashboardPagePO;

    public DashboardPageHelper(){
        dashboardPagePO = new DashboardPagePO(driver);
    }

    public boolean verifyDashboardPage(){
        try{
            waitUtil.waitForVisible(dashboardPagePO.pageTitle);
            System.out.println("Verified Dashboard Page: " + waitUtil.waitForVisible(dashboardPagePO.pageTitle).getText());
            return true;
        }
        catch (Exception e){
            System.out.println("Error validating Dashboard: " + e.getMessage());
            return false;
        }
    }

    public boolean verifySorting(){
        try{
            waitUtil.waitForClickable(dashboardPagePO.sortDropdown).click();
            waitUtil.waitForClickable(dashboardPagePO.alphabeticDescOption).click();
            System.out.println("Verified Alphabetic Sorting Option");
            waitUtil.waitForClickable(dashboardPagePO.sortDropdown).click();
            waitUtil.waitForClickable(dashboardPagePO.highToLowOption).click();
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

                waitUtil.waitForVisible(name);
                System.out.println("Verified product name");

                String price = waitUtil.waitForVisible(priceLocator).getText();
                System.out.println("Verified product price: " + product + " | " + price);

                waitUtil.waitForElementToDisappear(dashboardPagePO.itemAddedMessage);
                waitUtil.scrollElementIntoView(button);
                waitUtil.waitForVisible(button);
                waitUtil.waitForClickable(button).click();
                System.out.println("Clicked Add to Cart for product: " + product);
            }
            waitUtil.waitForElementToDisappear(dashboardPagePO.itemAddedMessage);
            waitUtil.scrollElementIntoView(dashboardPagePO.cartIcon);
            waitUtil.waitForHeaderToBeVisible();
            waitUtil.waitForVisible(dashboardPagePO.cartIcon);
            waitUtil.waitForClickable(dashboardPagePO.cartIcon).click();
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
            waitUtil.waitForHeaderToBeVisible();
            waitUtil.waitForVisible(dashboardPagePO.profileButton);
            waitUtil.waitForClickable(dashboardPagePO.profileButton).click();
            System.out.println("Clicked Profile button");
            waitUtil.waitForVisible(dashboardPagePO.logoutButton);
            waitUtil.waitForClickable(dashboardPagePO.logoutButton).click();
            System.out.println("Clicked Logout Button");
            waitUtil.waitForVisible(dashboardPagePO.logoutButtonPopup);
            waitUtil.waitForClickable(dashboardPagePO.logoutButtonPopup).click();
            System.out.println("Clicked Logout Confirm button");
            return true;
        }
        catch (Exception e){
            System.out.println("Error while logging out: " + e.getMessage());
            return false;
        }
    }
}
