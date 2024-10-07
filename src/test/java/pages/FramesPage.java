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
        loggerUtility.infoLog("The user switches to specific iframe");

        System.out.println(sampleTextElement.getText());
        loggerUtility.infoLog("The user interacts with an element within iframe");

        frameMethods.switchToParentIFrame();
        loggerUtility.infoLog("The user switches to parent frame");

    }

    public void dealSecondFrame(){
        frameMethods.switchToSpecificIFrame("frame2");
        loggerUtility.infoLog("The user switches to specific iframe");

        System.out.println(secondSampleTextElement.getText());
        loggerUtility.infoLog("The user interacts with an element within iframe");
    }
}
