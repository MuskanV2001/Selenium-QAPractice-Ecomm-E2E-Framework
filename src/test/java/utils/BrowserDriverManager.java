package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserDriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public WebDriver getBrowserDriver(){
        setupBrowserDriver();
        return webDriver.get();
    }

    public void setupBrowserDriver(){

        try {
            String browser = ConfigPropertiesReader.getConfigProperty("browser");
            String headless = System.getProperty("headless", "false");
            String executionMode = System.getProperty("executionMode", "local");

            // Chrome Driver
            if (browser.equalsIgnoreCase("chrome")) {
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

                if (headless.equalsIgnoreCase("true")) {
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
                // SauceLabs Execution Config
                if (executionMode.equalsIgnoreCase("sauce")) {

                    String sauceLabsUrl = ConfigPropertiesReader.getConfigProperty("sauceLabsUrl");

                    String sauceUser = System.getenv("SAUCE_USERNAME");
                    String sauceKey = System.getenv("SAUCE_ACCESS_KEY");

                    options.setPlatformName("Windows 11");
                    options.setBrowserVersion("latest");
                    Map<String, Object> sauceOptions = new HashMap<>();
                    sauceOptions.put("username", sauceUser);
                    sauceOptions.put("accessKey", sauceKey);
                    sauceOptions.put("build", "selenium-testng-build");
                    sauceOptions.put("name", "Selenium TestNG Test");
                    options.setCapability("sauce:options", sauceOptions);

                    System.out.println("\nRunning on Sauce Labs...");
                    System.out.println("Sauce Labs: " + sauceLabsUrl);

                    webDriver.set(new RemoteWebDriver(new URL(sauceLabsUrl), options));
                }
                else {
                    webDriver.set(new ChromeDriver(options));
                }
            }
            else if (browser.equalsIgnoreCase("firefox")) webDriver.set(new FirefoxDriver());
            else if (browser.equalsIgnoreCase("edge")) webDriver.set(new EdgeDriver());
        }
        catch(Exception e){
            System.out.println("Error creating Browser Driver: " + e.getMessage());
            throw new RuntimeException("Failed to create Browser Driver", e);
        }
    }

    public void quitBrowserDriver(){
        WebDriver driver = webDriver.get();
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("BROWSER CLOSED SUCCESSFULLY FOR THREAD: " + Thread.currentThread().getId());
            } catch (Exception e) {
                System.out.println("Error closing browser: " + e.getMessage());
            } finally {
                webDriver.remove();
            }
        }
    }
}
