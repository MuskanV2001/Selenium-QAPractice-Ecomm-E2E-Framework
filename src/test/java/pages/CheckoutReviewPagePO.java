package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutReviewPagePO {

    private WebDriver driver;

    public CheckoutReviewPagePO(WebDriver driver){
        this.driver = driver;
    }

    public By pageTitle = By.xpath("//h3[text()=\"Checkout: Overview\"]");
    public By paymentInfoHeader = By.xpath("//h4[text()=\"Payment Information:\"]");
    public By paymentInfo = By.xpath("//h4[text()=\"Payment Information:\"]/following-sibling::p");
    public By shippingInfoHeader = By.xpath("//h4[text()=\"Shipping Information:\"]");
    public By shippingInfo = By.xpath("//h4[text()=\"Shipping Information:\"]/following-sibling::p");
    public By priceTotalHeader = By.xpath("//h4[text()=\"Price Total:\"]");
    public By itemTotal = By.xpath("//h4[text()=\"Price Total:\"]/following-sibling::p[1]");
    public By taxAmount = By.xpath("//h4[text()=\"Price Total:\"]/following-sibling::p[2]");
    public By totalAmount = By.xpath("//h4[text()=\"Price Total:\"]/following-sibling::p[3]");
    public By finishButton = By.xpath("//button/span[contains(text(),\"Finish\")]");


}
