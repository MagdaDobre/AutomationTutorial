package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;

    public void setUpDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Run in headless mode for CI
        options.addArguments("--no-sandbox"); // Required for GitHub Actions
        options.addArguments("--disable-dev-shm-usage"); // Prevents memory issues
        options.addArguments("--window-size=1920,1080"); // Set a default window size

        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver(){
        driver.quit();
    }
}
