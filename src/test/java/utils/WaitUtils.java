package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public WebDriver driver;

    private static WebDriverWait wait;

    public WaitUtils(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});", element
        );
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public boolean waitForElementToDisappear(By locator){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void scrollElementIntoView(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(locator));
    }

    public void waitForHeaderToBeVisible(){
        System.out.println("Scrolling to the header...");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "document.body.scrollTop = 0;" +
                        "document.documentElement.scrollTop = 0;"
        );
        waitForClickable(By.cssSelector("header"));
    }
}
