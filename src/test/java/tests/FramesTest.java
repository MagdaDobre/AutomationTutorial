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
import sharedData.SharedData;

import java.time.Duration;

public class FramesTest extends SharedData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(driver);
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
        alertFrameWindowPage.clickFramesSubMenu();

        FramesPage framesPage = new FramesPage(driver);
        framesPage.dealFirstFrame();
        framesPage.dealSecondFrame();
    }
}
