package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPagePO {

    private WebDriver driver;

    public ConfirmationPagePO(WebDriver driver){
        this.driver = driver;
    }

    public By pageTitle = By.xpath("//h3[text()=\"Checkout: Complete!\"]");
    public By confirmationMessage = By.xpath("//h3[text()=\"Thank you for your order!\"]");
    public By infoMessage = By.xpath("//*[contains(text(),\"Your order has been dispatched, and will arrive just as fast as the pony can get there!\")]");
    public By continueShoppingButton = By.xpath("//button/span[text()=\"Continue Shopping\"]");
}
