package tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesTest {

    public static void main(String[] args){

        //Run in the Debug Mode to see every operation

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        Cookie envVersion = new Cookie("debug_tiaa_bg","green");

        driver.manage().addCookie(envVersion);
        driver.navigate().refresh();

        driver.manage().deleteCookie(envVersion);
        driver.navigate().refresh();

        driver.quit();
    }
}

