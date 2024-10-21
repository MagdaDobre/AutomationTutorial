package pages;


import loggerUtility.LoggerUtility;
import modelObject.AlertModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement okAlertElement;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButtonElement;

    @FindBy(id = "confirmButton")
    private WebElement confirmAlertElement;

    @FindBy(id = "promtButton")
    private WebElement promtAlertElement;

    public void dealAlertProcess(AlertModel testData) {
        elementMethods.clickJSElement(okAlertElement);
        LoggerUtility.infoLog("The user clicks on alertOk element");

        alertMethods.acceptAlert();
        LoggerUtility.infoLog("The user accepts the alert");

        elementMethods.clickJSElement(timerAlertButtonElement);
        LoggerUtility.infoLog("The user clicks on alertTimer element");

        alertMethods.acceptAlert();
        LoggerUtility.infoLog("The user accepts the alert");

        elementMethods.clickJSElement(confirmAlertElement);
        LoggerUtility.infoLog("The user clicks on alertConfirm element");

        alertMethods.dismissAlert();
        LoggerUtility.infoLog("The user dismisses the alert");

        elementMethods.clickJSElement(promtAlertElement);
        LoggerUtility.infoLog("The user clicks on alertPrompt element");

        alertMethods.fillAlert(testData.getAlertText());
        LoggerUtility.infoLog("The user fills the alert displayed with "+testData.getAlertText()+" value and accepts it");
    }
}
