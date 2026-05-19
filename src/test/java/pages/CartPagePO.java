package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPagePO extends BaseTest {

    private WebDriver driver;

    public CartPagePO(WebDriver driver){
        this.driver = driver;
    }

    public By pageTitle = By.xpath("//h3[text()='Your Cart']");
    public By checkoutButton = By.xpath("//button/span[contains(text(),'Checkout')]");

    public WebElement getProductLocator(String productName){
        By productLocator = By.xpath("//h3[contains(text(),'" + productName + "')]");
        return waitUtil.waitForVisible(productLocator);
    }

    public WebElement addQuantityButton(String productName){
        By addQtyButtonLocator = By.xpath("//h3[text()='" + productName + "']/ancestor::div[2]/following-sibling::div/div/button[2]");
        return waitUtil.waitForClickable(addQtyButtonLocator);
    }
}
