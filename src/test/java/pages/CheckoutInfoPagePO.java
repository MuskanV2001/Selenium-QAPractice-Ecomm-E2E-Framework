package pages;

import org.openqa.selenium.By;

public class CheckoutInfoPagePO {

    public By pageTitle = By.xpath("//h3[text()='Checkout: Your Information']");
    public By firstNameInput = By.xpath("//label[text()='First Name']/following-sibling::input");
    public By lastNameInput = By.xpath("//label[text()='Last Name']/following-sibling::input");
    public By zipcodeInput = By.xpath("//label[text()='Zip Code']/following-sibling::input");
    public By continueButton = By.xpath("//button/span[contains(text(),'Continue')]");
}
