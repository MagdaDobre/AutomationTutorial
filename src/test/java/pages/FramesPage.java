package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends  BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    public WebElement sampleTextElement;
    @FindBy(id = "sampleHeading")
    public WebElement secondSampleTextElement;

    public void dealFirstFrame(){
        frameMethods.switchToSpecificIFrame("frame1");
        System.out.println(sampleTextElement.getText());
        frameMethods.switchToParentIFrame();
    }

    public void dealSecondFrame(){
        frameMethods.switchToSpecificIFrame("frame2");
        System.out.println(secondSampleTextElement.getText());

    }
}
