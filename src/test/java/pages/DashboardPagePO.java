package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPagePO{

    private WebDriver driver;

    public DashboardPagePO(WebDriver driver){
        this.driver = driver;
    }

    public By pageTitle = By.xpath("//h3[text()='Products']");
    public By sortDropdown = By.cssSelector("button[role='combobox']");
    public By highToLowOption = By.xpath("//div[@data-value='high']");
    public By alphabeticDescOption = By.xpath("//div[@data-value='dsc']");
    public By cartIcon = By.cssSelector("header#ecommerce-header span:nth-child(1)");
    public By itemAddedMessage = By.xpath("//*[contains(text(),'Added to cart')]/ancestor::li");
    public By profileButton = By.xpath("//div[contains(@class,'profile')]/button/span[1]");
    public By logoutButton = By.xpath("//button/div[@role='menuitem']");
    public By logoutButtonPopup = By.xpath("//button[@data-slot='dialog-close' and text()='Logout']");


    public By getProductNameLocator(String productName){
        return By.xpath("//a[contains(text(),'" + productName + "')]");
    }

    public By getProductPriceLocator(String productName){
        return By.xpath("//a[contains(text(),'" + productName + "')]/following-sibling::div/span");
    }

    public By getAddToCartButtonLocator(String productName){
        return By.xpath("//a[text()='"+ productName +"']/following-sibling::div/button");
    }
}
