package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedFrameSubMenu;

    public void clickAlert(){
        elementMethods.clickJSElement(alertsSubMenu);
        loggerUtility.infoLog("The user clicks on Alert subMenu");
    }

    public void clickBrowserWindow(){
        elementMethods.clickJSElement(browserWindowSubMenu);
        loggerUtility.infoLog("The user clicks on Browser Window subMenu");
    }

    public void clickFramesSubMenu(){
        elementMethods.clickJSElement(framesSubMenu);
        loggerUtility.infoLog("The user clicks on Frames subMenu");
    }

    public void clickNestedFrameSubMenu(){
        elementMethods.clickJSElement(nestedFrameSubMenu);
        loggerUtility.infoLog("The user clicks on Nested Frames subMenu");
    }
}
