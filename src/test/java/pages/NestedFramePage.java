package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramePage extends BasePage{
    public NestedFramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    private WebElement childIframeElement;
    @FindBy(tagName = "p")
    private WebElement childTextElement;

    public void dealNestedFrame(){
        frameMethods.switchToSpecificIFrame("frame1");
        LoggerUtility.infoLog("The user switches the focus to a specific parent iframe");

        frameMethods.switchToSpecificIFrame(childIframeElement);
        LoggerUtility.infoLog("The user switches the focus to a specific child iframe");

        System.out.println(childTextElement.getText());
        LoggerUtility.infoLog("The user interacts with an element within iframe");
    }
}
