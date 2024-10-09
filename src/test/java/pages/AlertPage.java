package pages;

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
        loggerUtility.infoLog("The user clicks on alertOk element");

        alertMethods.acceptAlert();
        loggerUtility.infoLog("The user accepts the alert");

        elementMethods.clickJSElement(timerAlertButtonElement);
        loggerUtility.infoLog("The user clicks on alertTimer element");

        alertMethods.acceptAlert();
        loggerUtility.infoLog("The user accepts the alert");

        elementMethods.clickJSElement(confirmAlertElement);
        loggerUtility.infoLog("The user clicks on alertConfirm element");

        alertMethods.dismissAlert();
        loggerUtility.infoLog("The user dismisses the alert");

        elementMethods.clickJSElement(promtAlertElement);
        loggerUtility.infoLog("The user clicks on alertPrompt element");

        alertMethods.fillAlert(testData.getAlertText());
        loggerUtility.infoLog("The user fills the alert displayed with "+testData.getAlertText()+" value and accepts it");
    }
}
