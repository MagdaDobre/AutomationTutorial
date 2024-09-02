package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TabWindowTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {
        // deschidem un browser
        driver = new ChromeDriver();
        //accesam un url
        driver.get("https://demoqa.com/");
        //facem browserul maximise
        driver.manage().window().maximize();
        WebElement alertsFrameWindowMenu = driver.findElement(By.xpath("//h5[text()= 'Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", alertsFrameWindowMenu);

        WebElement browserWindowSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        js.executeScript("arguments[0].click();", browserWindowSubMenu);

        WebElement newTabElement = driver.findElement(By.id("tabButton"));
        js.executeScript("arguments[0].click();", newTabElement);

        System.out.println("URL-ul paginii curente este:" + driver.getCurrentUrl());
        List<String> tabsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsList.get(1));
        System.out.println("URL-ul paginii curente este:" + driver.getCurrentUrl());
    }

    }

