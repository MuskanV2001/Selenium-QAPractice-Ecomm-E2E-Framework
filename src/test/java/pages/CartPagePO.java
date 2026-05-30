package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPagePO extends BaseTest {


    public By pageTitle = By.xpath("//h3[text()='Your Cart']");
    public By checkoutButton = By.xpath("//button/span[contains(text(),'Checkout')]");

    public WebElement getProductLocator(String productName){
        By productLocator = By.xpath("//h3[contains(text(),'" + productName + "')]");
        return getWaitUtil().waitForVisible(productLocator);
    }

    public WebElement addQuantityButton(String productName){
        By addQtyButtonLocator = By.xpath("//h3[text()='" + productName + "']/ancestor::div[2]/following-sibling::div/div/button[2]");
        return getWaitUtil().waitForClickable(addQtyButtonLocator);
    }
}
