package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertFrameWindowPage {
    public WebDriver driver;
    public ElementMethods elementMethods;

    public AlertFrameWindowPage(WebDriver driver) {
        this.driver = driver;
        elementMethods = new ElementMethods(this.driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//span[text()='Alerts']")
    public WebElement alertsSubMenu;
    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindowSubMenu;
    @FindBy(xpath = "//span[text()='Frames']")
    public WebElement framesSubMenu;

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
