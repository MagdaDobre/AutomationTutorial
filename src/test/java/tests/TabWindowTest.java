package tests;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.TabWindowPage;
import sharedData.SharedData;

import java.util.ArrayList;
import java.util.List;

public class TabWindowTest extends SharedData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.clickBrowserWindow();

        TabWindowPage tabWindowPage = new TabWindowPage(driver);
        tabWindowPage.dealTabProcess();
        tabWindowPage.dealWindowProcess();


//        WebElement alertsFrameWindowMenu = driver.findElement(By.xpath("//h5[text()= 'Alerts, Frame & Windows']"));
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("arguments[0].click();", alertsFrameWindowMenu);
//        elementMethods.clickJSElement(alertsFrameWindowMenu);

//        WebElement browserWindowSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
////        js.executeScript("arguments[0].click();", browserWindowSubMenu);
//        elementMethods.clickJSElement(browserWindowSubMenu);

//        WebElement newTabElement = driver.findElement(By.id("tabButton"));
////        js.executeScript("arguments[0].click();", newTabElement);
//        elementMethods.clickJSElement(newTabElement);
//
////        System.out.println("URL-ul paginii curente este:" + driver.getCurrentUrl());
////
////        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
////        driver.switchTo().window(tabsList.get(1));
////
////        System.out.println("URL-ul paginii curente este:" + driver.getCurrentUrl());
//        tabMethods.switchSpecificTab(1);
//
////        driver.close();
//        tabMethods.closeCurrentTab();
//
////        driver.switchTo().window(tabsList.get(0));
////        System.out.println("URL-ul paginii curente este " + driver.getCurrentUrl());
//        tabMethods.switchSpecificTab(0);

//        WebElement newWindowElement = driver.findElement(By.id("windowButton"));
////        js.executeScript("arguments[0].click();", newWindowElement);
//        elementMethods.clickJSElement(newWindowElement);
//
////        System.out.println("URL-ul paginii curente este " + driver.getCurrentUrl());
////
////        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
////        driver.switchTo().window(windowList.get(1));
////
////        System.out.println("URL-ul paginii curente este " + driver.getCurrentUrl());
////
////        driver.close();
//        tabMethods.switchSpecificTab(1);
//        tabMethods.closeCurrentTab();
//
//        driver.quit();
    }
}

