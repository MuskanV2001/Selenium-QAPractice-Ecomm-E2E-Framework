package base;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import utils.ConfigPropertiesReader;
import utils.DBConnectionUtils;
import utils.MySQLQueryUtils;
import utils.WaitUtils;
import java.util.*;

public class BaseTest {

    protected static WebDriver driver;
    public static String baseUrl;
    public static WaitUtils waitUtil;
    public static List<Map<Object,Object>> userTestData;

    public WebDriver initializeDriver(){
        try{
            String browser = ConfigPropertiesReader.getConfigProperty("browser");
            baseUrl = ConfigPropertiesReader.getConfigProperty("baseUrl");

            // For Jenkins parameter in "clean test -DProfile=${Profile} -Dheadless=${headless}"
            String headless = System.getProperty("headless", "false");

            if(browser.equalsIgnoreCase("chrome")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-save-password-bubble");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-gpu");

                // Disable password manager
                options.addArguments("--disable-features=PasswordLeakDetection");

                if(headless.equalsIgnoreCase("true")) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--start-maximized");
                    System.out.println("Running in headless mode");
                }

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.password_manager_leak_detection", false);
                prefs.put("profile.default_content_setting_values.notifications", 2);

                options.setExperimentalOption("prefs", prefs);

                driver = new ChromeDriver(options);
            }
            else if (browser.equalsIgnoreCase("firefox")) driver = new FirefoxDriver();
            else if (browser.equalsIgnoreCase("edge")) driver = new EdgeDriver();

            waitUtil = new WaitUtils(driver);

        }
        catch (Exception e){
            System.out.println("Error reading config file: " + e.getMessage());
        }
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void launchApp(){
        driver = initializeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @After
    public void tear_down(){
        if (driver != null) {
            driver.quit();
        }
        DBConnectionUtils.closeConnection();
        System.out.println("AFTER HOOK EXECUTED - TEAR DOWN");
    }

}
