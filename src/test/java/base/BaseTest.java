package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserDriverManager;
import utils.ConfigPropertiesReader;
import utils.WaitUtils;

import java.util.*;

public class BaseTest {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<WaitUtils> waitUtilThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<BrowserDriverManager> browserDriverManagerThreadLocal = new ThreadLocal<>();

    // Protected accessors for subclasses
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static WaitUtils getWaitUtil() {
        return waitUtilThreadLocal.get();
    }

    public WebDriver initializeDriver(){
        try{
            if (getDriver() != null) {
                return getDriver();
            }
            // Setting up Browser Driver Manager
            BrowserDriverManager browserDriverManager = new BrowserDriverManager();
            browserDriverManagerThreadLocal.set(browserDriverManager);
            WebDriver webDriver = browserDriverManager.getBrowserDriver();

            // Setting up Driver for each thread
            driverThreadLocal.set(webDriver);

            // Setting up wait util for each thread
            waitUtilThreadLocal.set(new WaitUtils(webDriver));
        }
        catch (Exception e){
            System.out.println("Error initializing driver: " + e.getMessage());
        }
        return getDriver();
    }

    public void launchApp(){
        initializeDriver();
        String baseUrl = ConfigPropertiesReader.getConfigProperty("baseUrl");
        getDriver().get(baseUrl);
        getDriver().manage().window().maximize();
        System.out.println("\nLAUNCHING APP FOR THREAD: " + Thread.currentThread().getId());
        System.out.println("Base URL: " + baseUrl + "\n");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        try {
            if (browserDriverManagerThreadLocal.get() != null) {
                browserDriverManagerThreadLocal.get().quitBrowserDriver();
            }
        }
        catch (Exception e) {
            System.out.println("Error during tearDown: " + e.getMessage());
        }
        finally {
            driverThreadLocal.remove();
            waitUtilThreadLocal.remove();
            browserDriverManagerThreadLocal.remove();
        }
        System.out.println("\nTEARDOWN EXECUTING FOR THREAD: " + Thread.currentThread().getId() + "\n");
    }

}
