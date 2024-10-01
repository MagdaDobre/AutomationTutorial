package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.AlertPage;
import pages.HomePage;
import sharedData.SharedData;

import java.time.Duration;

public class AlertTest extends SharedData {

    @Test
    public void metodaTest() {


        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.clickAlert();

        AlertPage alertPage = new AlertPage(driver);
        alertPage.dealAlertProcess("this is a test");


//        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("arguments[0].click();", alertsFrameWindowsMenu);
//        elementMethods.clickJSElement(alertsFrameWindowsMenu);

//        WebElement alertsSubMenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
////        js.executeScript("arguments[0].click();", alertsSubMenu);
//        elementMethods.clickJSElement(alertsSubMenu);
//
//        WebElement okAlertElement = driver.findElement(By.id("alertButton"));
////        js.executeScript("arguments[0].click();", okAlertElement);
//        elementMethods.clickJSElement(okAlertElement);
//
//
////        Alert firstAlert=driver.switchTo().alert();
////        System.out.println(firstAlert.getText());
////        firstAlert.accept();
//
//        alertMethods.acceptAlert();
//
//
//        WebElement timerAlertButtonElement = driver.findElement(By.id("timerAlertButton"));
////        js.executeScript("arguments[0].click();", timerAlertButtonElement);
//        elementMethods.clickJSElement(timerAlertButtonElement);
//
//
//        //wait explicit
////        WebDriverWait waitExplicit = new WebDriverWait(driver,Duration.ofSeconds(10));
////        waitExplicit.until(ExpectedConditions.alertIsPresent());
//        //fixat in metode, nu mai e necesar
//
////        Alert secondAlert=driver.switchTo().alert();
////        System.out.println(secondAlert.getText());
////        secondAlert.accept();
//        alertMethods.acceptAlert();
//
//        WebElement confirmAlertElement = driver.findElement(By.id("confirmButton"));
////        js.executeScript("arguments[0].click();", confirmAlertElement);
//        elementMethods.clickJSElement(confirmAlertElement);
//
////        Alert thirdAlert=driver.switchTo().alert();
////        System.out.println(thirdAlert.getText());
////        //thirdAlert.accept();
////        thirdAlert.dismiss();
//        alertMethods.dismissAlert();
//
//
//        WebElement promtAlertElement = driver.findElement(By.id("promtButton"));
////        js.executeScript("arguments[0].click();", promtAlertElement);
//        elementMethods.clickJSElement(promtAlertElement);
//
////        Alert fourthAlert=driver.switchTo().alert();
////        System.out.println(fourthAlert.getText());
////        fourthAlert.sendKeys("this is a test");
////        fourthAlert.accept();
//
//        alertMethods.fillAlert("this is a test");


    }
}
