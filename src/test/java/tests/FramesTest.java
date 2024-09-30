package tests;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.FramesPage;
import pages.HomePage;

import java.time.Duration;

public class FramesTest {
    public WebDriver driver;

    @Test

    public void metodaTest() {
        // deschidem un browser
        driver = new ChromeDriver();
        //accesam un url
        driver.get("https://demoqa.com/");
        //facem browser-ul maximize
        driver.manage().window().maximize();
        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        ElementMethods elementMethods = new ElementMethods(driver);
//        FrameMethods frameMethods = new FrameMethods(driver);

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.clickFramesSubMenu();

        FramesPage framesPage = new FramesPage(driver);
        framesPage.dealFirstFrame();
        framesPage.dealSecondFrame();

//        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("arguments[0].click();", alertsFrameWindowsMenu);
//        elementMethods.clickJSElement(alertsFrameWindowsMenu);

//        WebElement framesSubMenu = driver.findElement(By.xpath("//span[text()='Frames']"));
////        js.executeScript("arguments[0].click();", framesSubMenu);
//        elementMethods.clickJSElement(framesSubMenu);

        //ne mutam pe un Iframe
//        driver.switchTo().frame("frame1");
//        frameMethods.switchToSpecificIFrame("frame1");
//
//        WebElement sampleTextElement = driver.findElement(By.id("sampleHeading"));
//        System.out.println(sampleTextElement.getText());
//
////        driver.switchTo().parentFrame();
//        frameMethods.switchToParentIFrame();
//
////        driver.switchTo().frame("frame2");
//        frameMethods.switchToSpecificIFrame("frame2");
//
//        WebElement secondSampleTextElement = driver.findElement(By.id("sampleHeading"));
//        System.out.println(secondSampleTextElement.getText());

        //tema - nested frames


    }
}
