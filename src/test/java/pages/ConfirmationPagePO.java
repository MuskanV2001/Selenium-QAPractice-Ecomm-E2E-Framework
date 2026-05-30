package pages;

import org.openqa.selenium.By;

public class ConfirmationPagePO {

    public By pageTitle = By.xpath("//h3[text()=\"Checkout: Complete!\"]");
    public By confirmationMessage = By.xpath("//h3[text()=\"Thank you for your order!\"]");
    public By infoMessage = By.xpath("//*[contains(text(),\"Your order has been dispatched, and will arrive just as fast as the pony can get there!\")]");
    public By continueShoppingButton = By.xpath("//button/span[text()=\"Continue Shopping\"]");
}
