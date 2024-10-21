package pages;

import loggerUtility.LoggerUtility;
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
        LoggerUtility.infoLog("The user switches to specific iframe");

        System.out.println(sampleTextElement.getText());
        LoggerUtility.infoLog("The user interacts with an element within iframe");

        frameMethods.switchToParentIFrame();
        LoggerUtility.infoLog("The user switches to parent frame");

    }

    public void dealSecondFrame(){
        frameMethods.switchToSpecificIFrame("frame2");
        LoggerUtility.infoLog("The user switches to specific iframe");

        System.out.println(secondSampleTextElement.getText());
        LoggerUtility.infoLog("The user interacts with an element within iframe");
    }
}
