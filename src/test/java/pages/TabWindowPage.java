package pages;

import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabWindowPage extends BasePage{

    public TabWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTabElement;
    @FindBy(id = "windowButton")
    private WebElement newWindowElement;

    public void dealTabProcess(){
        elementMethods.clickJSElement(newTabElement);
        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        tabMethods.switchSpecificTab(0);
    }

    public void dealWindowProcess(){
        elementMethods.clickJSElement(newWindowElement);
        tabMethods.switchSpecificTab(1);
        tabMethods.closeCurrentTab();
        tabMethods.quitTab();
    }
}
