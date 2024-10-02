package tests;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;

public class NestedFRames extends SharedData {


    @Test
    public void metodaTest() {

        ElementMethods elementMethods = new ElementMethods(getDriver());
        FrameMethods frameMethods = new FrameMethods(getDriver());

        WebElement alertsFrameWindowsMenu = getDriver().findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", alertsFrameWindowsMenu);
        elementMethods.clickJSElement(alertsFrameWindowsMenu);

        WebElement framesSubMenu = getDriver().findElement(By.xpath("//span[text()='Nested Frames']"));
//        js.executeScript("arguments[0].click();", framesSubMenu);
        elementMethods.clickJSElement(framesSubMenu);

//        driver.switchTo().frame("frame1");
        frameMethods.switchToSpecificIFrame("frame1");

        WebElement childIframeElement = getDriver().findElement(By.tagName("p"));
        frameMethods.switchToSpecificIFrameByElement(childIframeElement);

        System.out.println(childIframeElement.getText());
    }
}
