package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTablesSubMenu;

    public void clickWebTable(){
        elementMethods.clickJSElement(webTablesSubMenu);
        LoggerUtility.infoLog("The user clicks on Web Table subMenu");
    }
}
