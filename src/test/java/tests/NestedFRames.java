package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFRames {
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

        WebElement alertsFrameWindowsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", alertsFrameWindowsMenu);

        WebElement framesSubMenu = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        js.executeScript("arguments[0].click();", framesSubMenu);

        driver.switchTo().frame("frame1");

        WebElement sampleTextElement = driver.findElement(By.id("Child Iframe"));
        System.out.println(sampleTextElement.getText());
    }
}
