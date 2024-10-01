package pages;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Web Tables']")
    public WebElement webTablesSubMenu;

    public void clickWebTable(){
        elementMethods.clickJSElement(webTablesSubMenu);
    }
}
