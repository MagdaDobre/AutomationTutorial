package helpMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
public class FrameMethods {
    public WebDriver driver;

    public void switchToSpecificIFrame(String value){
        driver.switchTo().frame(value);
    }

    public void switchToParentIFrame(){
        driver.switchTo().parentFrame();
    }

    public void switchToSpecificIFrame(WebElement element){
        driver.switchTo().frame(element);
    }
}
