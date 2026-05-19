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

    private WebDriverWait wait;

    public WaitUtils(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebElement waitForVisible(By locator) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator){
        WebElement element = this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});", driver.findElement(locator)
        );
        this.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
        return element;
    }

    public boolean waitForElementToDisappear(By locator){
        return this.wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void scrollElementIntoView(By locator) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", driver.findElement(locator));
        Thread.sleep(100);
    }

    public void waitForHeaderToBeVisible() throws InterruptedException {
        System.out.println("Scrolling to the header...");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0)");
        // Since page takes few ms to scroll - my script needs to pause to complete scrolling
        Thread.sleep(1000);
        scrollElementIntoView(By.cssSelector("header"));
        waitForClickable(By.cssSelector("header"));
    }
}
