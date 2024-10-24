package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()= 'Elements']")
    private WebElement elementsMenu;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindowsMenu;

    @FindBy(xpath = "//h5[text()= 'Forms']")
    private WebElement formsMenu;

    public void clickFormsMenu() {
        elementMethods.clickJSElement(formsMenu);
        LoggerUtility.infoLog("The user clicks on Forms menu");
    }

    public void clickAlertFrameWindow(){
        elementMethods.clickJSElement(alertsFrameWindowsMenu);
        LoggerUtility.infoLog("The user clicks on Alert, Frame & Window menu");
    }

    public void clickElements(){
        elementMethods.clickJSElement(elementsMenu);
        LoggerUtility.infoLog("The user clicks on Elements menu");
    }
}
