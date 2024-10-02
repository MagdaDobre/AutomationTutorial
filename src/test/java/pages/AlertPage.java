package pages;

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

    public void dealAlertProcess(String text) {
        elementMethods.clickJSElement(okAlertElement);
        alertMethods.acceptAlert();
        elementMethods.clickJSElement(timerAlertButtonElement);
        alertMethods.acceptAlert();
        elementMethods.clickJSElement(confirmAlertElement);
        alertMethods.dismissAlert();
        elementMethods.clickJSElement(promtAlertElement);
        alertMethods.fillAlert(text);
    }

}
