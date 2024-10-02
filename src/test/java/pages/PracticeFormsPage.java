package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormsPage extends BasePage {

    public PracticeFormsPage(WebDriver driver) {
        super(driver);
    }

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

    public void fillEntireForm(String firstNameValue,String lastNameValue,String userEmailValue,String genderValue,
                               String mobileNumberlValue, String monthValue, String yearValue, String dayValue,
                               List<String> subjectValues,List<String> hobbiesValues, String pathFile,
                               String currentAddressValue, String stateValue, String cityValue){
        elementMethods.fillElement(firstNameElement,firstNameValue);
        elementMethods.fillElement(lastNameElement,lastNameValue);
        elementMethods.fillElement(userEmailElement,userEmailValue);
        switch (genderValue) {
            case "Male":
                elementMethods.clickJSElement(genderOptionsList.get(0));
                break;
            case "Female":
                elementMethods.clickJSElement(genderOptionsList.get(1));
                break;
            case "Other":
                elementMethods.clickJSElement(genderOptionsList.get(2));
                break;
        }
        elementMethods.fillElement(mobileNumberElement,mobileNumberlValue);

        elementMethods.clickJSElement(dateOfBirthElement);
        elementMethods.selectDropDownElement(monthElement,monthValue);
        elementMethods.selectDropDownElement(yearElement,yearValue);

        for (int index = 0; index < daysList.size();index++){
            if (daysList.get(index).getText().equals(dayValue)){
                elementMethods.clickElement(daysList.get(index));
                break;
            }
        }

        for (int index = 0; index < subjectValues.size(); index++) {
            elementMethods.fillPressElement(subjectElement,subjectValues.get(index), Keys.ENTER);
        }

        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (hobbiesValues.contains(currentText)) {
                elementMethods.clickJSElement(hobbiesOptionsList.get(index));
            }
        }

        File file = new File(pathFile);
        elementMethods.fillElement(pictureElement,file.getAbsolutePath());
        elementMethods.fillElement(currentAddressElement, currentAddressValue);
        elementMethods.clickJSElement(stateElement);
        elementMethods.fillPressElement(stateInputElement,stateValue,Keys.ENTER);
        elementMethods.clickJSElement(cityElement);
        elementMethods.fillPressElement(cityInputElement,cityValue, Keys.ENTER);
        elementMethods.clickJSElement(submitElement);
    }

    public void validateFormValues(String firstNameValue, String lastNameValue, String userEmailValue, String genderValue, String mobileNumberlValue,
                                   List<String> subjectValues, List<String> hobbiesValues, String pathFile, String currentAddressValue,
                                   String stateValue, String cityValue){
        elementMethods.waitVisibleElement(thankyouElement);
        Assert.assertEquals(thankyouElement.getText(),"Thanks for submitting the form");

        Assert.assertEquals(labelList.get(0).getText(),"Student Name");
        Assert.assertEquals(labelList.get(1).getText(), "Student Email");
        Assert.assertEquals(labelList.get(2).getText(), "Gender");
        Assert.assertEquals(labelList.get(3).getText(), "Mobile");
        Assert.assertEquals(labelList.get(4).getText(), "Date of Birth");
        Assert.assertEquals(labelList.get(5).getText(), "Subjects");
        Assert.assertEquals(labelList.get(6).getText(), "Hobbies");
        Assert.assertEquals(labelList.get(7).getText(), "Picture");
        Assert.assertEquals(labelList.get(8).getText(), "Address");
        Assert.assertEquals(labelList.get(9).getText(), "State and City");

        Assert.assertEquals(valuesList.get(0).getText(), firstNameValue + " " + lastNameValue);
        Assert.assertEquals(valuesList.get(1).getText(), userEmailValue);
        Assert.assertEquals(valuesList.get(2).getText(), genderValue);
        Assert.assertEquals(valuesList.get(3).getText(), mobileNumberlValue);
        Assert.assertEquals(valuesList.get(4).getText(), "15 January,2030");

        String subjectValue = String.join(", ", subjectValues);
        Assert.assertEquals(valuesList.get(5).getText(), subjectValue);

        String hobbyValue = String.join(", ", hobbiesValues);
        Assert.assertEquals(valuesList.get(6).getText(), hobbyValue);

        File file = new File(pathFile);
        Assert.assertEquals(valuesList.get(7).getText(), file.getName());
        Assert.assertEquals(valuesList.get(8).getText(), currentAddressValue);
        Assert.assertEquals(valuesList.get(9).getText(), stateValue +" "+ cityValue);
    }

}
