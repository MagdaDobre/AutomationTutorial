package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertFrameWindowPage extends BasePage{

    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertsSubMenu;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindowSubMenu;
    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement framesSubMenu;

    public void clickAlert(){
        elementMethods.clickJSElement(alertsSubMenu);
    }

    public void clickBrowserWindow(){
        elementMethods.clickJSElement(browserWindowSubMenu);
    }

    public void clickFramesSubMenu(){
        elementMethods.clickJSElement(framesSubMenu);
    }
}
