package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class FileUploadsDownloads {

    public static void main(String[] args){

        // FILE DOWNLOADING
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> preferences = new HashMap<>();
        preferences.put("download.default_directory", "V:\\Selenium-Ecommerce-Framework\\src\\files");
        preferences.put("download.prompt_for_download", false); //To avoid the Save As file location window prompt
        preferences.put("safebrowsing.enabled", false);
        options.setExperimentalOption("prefs",preferences);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
        driver.manage().window().maximize();

        driver.findElement(By.id("downloadButton")).click();

        File downloadedFile = new File("V:\\Selenium-Ecommerce-Framework\\src\\files\\sampleFile.jpeg");

        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).until(d -> downloadedFile.exists());

        if(downloadedFile.exists()){
            System.out.println("File downloaded successfully!");
        }


        // FILE UPLOADING
        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys(System.getProperty("user.dir")+"/src/files/uploadFileText.txt");

        System.out.println("File uploaded successfully!");

//        downloadedFile.delete();

    }
}
