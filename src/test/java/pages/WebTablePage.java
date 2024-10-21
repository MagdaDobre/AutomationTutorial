package pages;

import loggerUtility.LoggerUtility;
import modelObject.WebTableModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class WebTablePage extends BasePage{

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']")
    private List<WebElement> tableContentList;
    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;
    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement userEmailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;
    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(xpath = "//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']")
    private List<WebElement> newTableContentList;
    @FindBy(id = "edit-record-4")
    private WebElement editElement;
    @FindBy(id = "firstName")
    private WebElement editFirstNameElement;
    @FindBy(id = "lastName")
    private WebElement editLastNameElement;
    @FindBy(id = "userEmail")
    private WebElement editEmailElement;
    @FindBy(id = "age")
    private WebElement editAgeElement;
    @FindBy(id = "salary")
    private WebElement editSalaryElement;
    @FindBy(id = "department")
    private WebElement editDepartmentElement;
    @FindBy(id = "delete-record-4")
    private WebElement deleteElement;

    public void createProcess(WebTableModel testData, int tableSize){
        Assert.assertEquals(tableContentList.size(),tableSize,"Default size for table is not " + tableSize);
        LoggerUtility.infoLog("The user validates the size of table content to be " +tableSize);

        elementMethods.clickElement(addElement);
        LoggerUtility.infoLog("The user clicks on Add Element button");

        elementMethods.fillElement(firstNameElement,testData.getFirstName());
        LoggerUtility.infoLog("The user fills First Name field with " + testData.getFirstName() + " value");

        elementMethods.fillElement(lastNameElement,testData.getLastName());
        LoggerUtility.infoLog("The user fills Last Name field with " + testData.getLastName() + " value");

        elementMethods.fillElement(userEmailElement,testData.getUserEmail());
        LoggerUtility.infoLog("The user fills User Email field with " + testData.getUserEmail() + " value");

        elementMethods.fillElement(ageElement,testData.getAge());
        LoggerUtility.infoLog("The user fills Age field with " + testData.getAge() + " value");

        elementMethods.fillElement(salaryElement,testData.getSalary());
        LoggerUtility.infoLog("The user fills Salary field with " + testData.getSalary() + " value");

        elementMethods.fillElement(departmentElement,testData.getDepartment());
        LoggerUtility.infoLog("The user fills Department field with " + testData.getDepartment() + " value");

        elementMethods.clickElement(submitElement);
        LoggerUtility.infoLog("The user clicks on Submit button");

        Assert.assertEquals(tableContentList.size(),tableSize+1,"Default size for table is not " + tableSize+1);
        LoggerUtility.infoLog("The user validates the size of table content to be " +tableSize + 1);

        String rowContent = newTableContentList.get(tableSize).getText();
        Assert.assertTrue(rowContent.contains(testData.getFirstName()),"The last row doesn't contain first name value.");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getFirstName() + " value into table content");

        Assert.assertTrue(rowContent.contains(testData.getLastName()),"The last row doesn't contain last name value.");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getLastName() + " value into table content");

        Assert.assertTrue(rowContent.contains(testData.getUserEmail()),"The last row doesn't contain user email value.");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getUserEmail() + " value into table content");

        Assert.assertTrue(rowContent.contains(testData.getAge()),"The last row doesn't contain age value.");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getAge() + " value into table content");

        Assert.assertTrue(rowContent.contains(testData.getSalary()),"The last row doesn't contain salary value.");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getSalary() + " value into table content");

        Assert.assertTrue(rowContent.contains(testData.getDepartment()),"The last row doesn't contain departament value.");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getDepartment() + " value into table content");
    }

    public void editProcess(WebTableModel testData, int tableSize){
        elementMethods.clickJSElement(editElement);
        LoggerUtility.infoLog("The user clicks on Edit button");

        elementMethods.clearEditElement(editFirstNameElement, testData.getEditFirstName());
        LoggerUtility.infoLog("The user clears and fills the First Name field with " + testData.getEditFirstName() + " value");

        elementMethods.clearEditElement(editLastNameElement, testData.getEditLastName());
        LoggerUtility.infoLog("The user clears and fills the Last Name field with " + testData.getEditLastName() + " value");

        elementMethods.clearEditElement(editEmailElement, testData.getEditEmail());
        LoggerUtility.infoLog("The user clears and fills the Email field with " + testData.getEditEmail() + " value");

        elementMethods.clearEditElement(editAgeElement, testData.getEditAge());
        LoggerUtility.infoLog("The user clears and fills the Age field with " + testData.getEditAge() + " value");

        elementMethods.clearEditElement(editSalaryElement, testData.getEditSalary());
        LoggerUtility.infoLog("The user clears and fills the Salary field with " + testData.getEditSalary() + " value");

        elementMethods.clearEditElement(editDepartmentElement, testData.getEditDepartment());
        LoggerUtility.infoLog("The user clears and fills the Department field with " + testData.getEditDepartment() + " value");

        elementMethods.clickElement(submitElement);
        LoggerUtility.infoLog("The user clicks on Submit element");

        elementMethods.waitVisibleList(newTableContentList);
        LoggerUtility.infoLog("The user waits a bit for presence of table content");

        String rowContent = newTableContentList.get(tableSize).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(testData.getEditFirstName()),"The last row doesn't contain first name value.");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getEditFirstName() + " value into table content");

        Assert.assertTrue(rowContent.contains(testData.getEditLastName()),"The last row doesn't contain last name value.");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getEditLastName() + " value into table content");

        Assert.assertTrue(rowContent.contains(testData.getEditEmail()),"The last row doesn't contain user email value.");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getEditEmail() + " value into table content");

        Assert.assertTrue(rowContent.contains(testData.getEditAge()),"The last row doesn't contain age value.");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getEditAge() + " value into table content");

        Assert.assertTrue(rowContent.contains(testData.getEditSalary()),"The last row doesn't contain salary value.");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getEditSalary() + " value into table content");

        Assert.assertTrue(rowContent.contains(testData.getEditDepartment()),"The last row doesn't contain departament value.");
        LoggerUtility.infoLog("The user validates the presence of " + testData.getEditDepartment() + " value into table content");
    }

    public void deleteProcess(int tableSize){
        elementMethods.clickJSElement(deleteElement);
        LoggerUtility.infoLog("The user clicks on Delete element");

        Assert.assertEquals(newTableContentList.size(),tableSize,"Default size for table is not 3.");
        LoggerUtility.infoLog("The user validates the size of table content to be " +tableSize);
    }
}
