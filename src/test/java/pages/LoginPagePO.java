package pages;

import org.openqa.selenium.By;

public class LoginPagePO {

    public By pageLogo = By.xpath("//header[@id='ecommerce-header']//img");
    public By pageTitle = By.xpath("//h2[text()='Login']");
    public By emailInput = By.cssSelector("input#email");
    public By passwordInput = By.cssSelector("input#password");
    public By loginButton = By.cssSelector("button[type='submit']");
}
