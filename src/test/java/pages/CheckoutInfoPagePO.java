package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPagePO {

    private WebDriver driver;

    public CheckoutInfoPagePO(WebDriver driver){
        this.driver = driver;
    }

    public By pageTitle = By.xpath("//h3[text()='Checkout: Your Information']");
    public By firstNameInput = By.xpath("//label[text()='First Name']/following-sibling::input");
    public By lastNameInput = By.xpath("//label[text()='Last Name']/following-sibling::input");
    public By zipcodeInput = By.xpath("//label[text()='Zip Code']/following-sibling::input");
    public By continueButton = By.xpath("//button/span[contains(text(),'Continue')]");
}
