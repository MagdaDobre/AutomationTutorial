package pages;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public FrameMethods frameMethods;


    public FramesPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver,this);
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
