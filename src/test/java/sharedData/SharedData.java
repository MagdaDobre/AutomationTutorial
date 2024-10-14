package sharedData;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import sharedData.browserService.ChromeService;
import sharedData.browserService.EdgeService;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;

    public void setUpDriver() {
        String browser = System.getProperty("browser");

        switch (browser){
            case "edge":
                EdgeService edgeService = new EdgeService();
                edgeService.openBrowser();
                driver = edgeService.getDriver();
                break;
            case "chrome":
                ChromeService chromeService = new ChromeService();
                chromeService.openBrowser();
                driver = chromeService.getDriver();
                break;
        }

        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        System.out.println("!!!!!!!!! Browser name: " + caps.getBrowserName());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver(){
        driver.quit();
    }
}
