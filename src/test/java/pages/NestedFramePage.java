package pages;

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
        frameMethods.switchToSpecificIFrame(childIframeElement);
        System.out.println(childTextElement.getText());
    }
}
