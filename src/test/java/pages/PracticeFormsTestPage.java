package pages;

import helpMethods.ElementMethods;
import helpMethods.FrameMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticeFormsTestPage extends BasePage {

    public PracticeFormsTestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()= 'Forms']")
    private WebElement formsMenu;
    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceFormSubMenu;
    @FindBy(id = "firstName")
    private  WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement userEmailElement;
    @FindBy(xpath = "//input[@name='gender']/../label")
    private List<WebElement> genderOptionsList;
    @FindBy(id = "userNumber")
    private WebElement mobileNumberElement;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthElement;
    @FindBy(className = "react-datepicker__month-select")
    private WebElement monthElement;
    @FindBy(className = "react-datepicker__year-select")
    private WebElement yearElement;
    @FindBy(xpath = "//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]")
    private List<WebElement> daysList;
    @FindBy(id = "subjectsInput")
    private WebElement subjectElement;
    @FindBy(xpath = "//div[@id='hobbiesWrapper']//label[@class = 'custom-control-label']")
    private  List<WebElement> hobbiesOptionsList;
    @FindBy(id = "uploadPicture")
    private WebElement pictureElement;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressElement;
    @FindBy(xpath = "//div[text()= 'Select State']")
    private WebElement stateElement;
    @FindBy(id = "react-select-3-input")
    private WebElement stateInputElement;
    @FindBy(xpath = "//div[text()= 'Select City']")
    private WebElement cityElement;
    @FindBy(id = "react-select-4-input")
    private WebElement cityInputElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement thankyouElement;
    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']//td[1]")
    private List<WebElement> labelList;
    @FindBy(xpath = "//table[@class='table table-dark table-striped table-bordered table-hover']//td[2]")
    private List<WebElement> valuesList;




    public void clickFormsMenu() {
        elementMethods.clickJSElement(formsMenu);
    }

}
