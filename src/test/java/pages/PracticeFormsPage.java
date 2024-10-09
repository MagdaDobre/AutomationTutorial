package pages;

import modelObject.PracticeFormModel;
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

    public void fillEntireForm(PracticeFormModel testData){
        elementMethods.fillElement(firstNameElement,testData.getFirstName());
        elementMethods.fillElement(lastNameElement,testData.getLastName());
        elementMethods.fillElement(userEmailElement,testData.getUserEmail());
        switch (testData.getGender()) {
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
        elementMethods.fillElement(mobileNumberElement,testData.getMobileNumber());

        elementMethods.clickJSElement(dateOfBirthElement);
        elementMethods.selectDropDownElement(monthElement,testData.getMonth());
        elementMethods.selectDropDownElement(yearElement,testData.getYear());

        for (int index = 0; index < daysList.size();index++){
            if (daysList.get(index).getText().equals(testData.getDay())){
                elementMethods.clickElement(daysList.get(index));
                break;
            }
        }

        for (int index = 0; index < testData.getSubjects().size(); index++) {
            elementMethods.fillPressElement(subjectElement,testData.getSubjects().get(index), Keys.ENTER);
        }

        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (testData.getHobbies().contains(currentText)) {
                elementMethods.clickJSElement(hobbiesOptionsList.get(index));
            }
        }

        File file = new File(testData.getPathFile());
        elementMethods.fillElement(pictureElement,file.getAbsolutePath());
        elementMethods.fillElement(currentAddressElement, testData.getCurrentAddress());
        elementMethods.clickJSElement(stateElement);
        elementMethods.fillPressElement(stateInputElement,testData.getState(),Keys.ENTER);
        elementMethods.clickJSElement(cityElement);
        elementMethods.fillPressElement(cityInputElement,testData.getCity(), Keys.ENTER);
        elementMethods.clickJSElement(submitElement);
    }

    public void validateFormValues(PracticeFormModel testData){
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

        Assert.assertEquals(valuesList.get(0).getText(), testData.getFirstName() + " " + testData.getLastName());
        Assert.assertEquals(valuesList.get(1).getText(), testData.getUserEmail());
        Assert.assertEquals(valuesList.get(2).getText(), testData.getGender());
        Assert.assertEquals(valuesList.get(3).getText(), testData.getMobileNumber());
        Assert.assertEquals(valuesList.get(4).getText(), "15 January,2030");

        String subjectValue = String.join(", ", testData.getSubjects());
        Assert.assertEquals(valuesList.get(5).getText(), subjectValue);

        String hobbyValue = String.join(", ", testData.getHobbies());
        Assert.assertEquals(valuesList.get(6).getText(), hobbyValue);

        File file = new File(testData.getPathFile());
        Assert.assertEquals(valuesList.get(7).getText(), file.getName());
        Assert.assertEquals(valuesList.get(8).getText(), testData.getCurrentAddress());
        Assert.assertEquals(valuesList.get(9).getText(), testData.getState() +" "+ testData.getCity());
    }
}
