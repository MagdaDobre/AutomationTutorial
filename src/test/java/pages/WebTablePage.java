package pages;

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



    public void createProcess(String firstNameValue,String lastNameValue, String userEmailValue,
                          String ageValue,String salaryValue,String departmentValue,
                          int tableSize){

    //completare
    Assert.assertEquals(tableContentList.size(),tableSize,"Default size for table is not " + tableSize);
    elementMethods.clickElement(addElement);
    elementMethods.fillElement(firstNameElement,firstNameValue);
    elementMethods.fillElement(lastNameElement,lastNameValue);
    elementMethods.fillElement(userEmailElement,userEmailValue);
    elementMethods.fillElement(ageElement,ageValue);
    elementMethods.fillElement(salaryElement,salaryValue);
    elementMethods.fillElement(departmentElement,departmentValue);
    elementMethods.clickElement(submitElement);
    Assert.assertEquals(tableContentList.size(),tableSize+1,"Default size for table is not " + tableSize+1);

    //validare
    String rowContent = newTableContentList.get(tableSize).getText();
    Assert.assertTrue(rowContent.contains(firstNameValue),"The last row doesn't contain first name value.");
    Assert.assertTrue(rowContent.contains(lastNameValue),"The last row doesn't contain last name value.");
    Assert.assertTrue(rowContent.contains(userEmailValue),"The last row doesn't contain user email value.");
    Assert.assertTrue(rowContent.contains(ageValue),"The last row doesn't contain age value.");
    Assert.assertTrue(rowContent.contains(salaryValue),"The last row doesn't contain salary value.");
    Assert.assertTrue(rowContent.contains(departmentValue),"The last row doesn't contain departament value.");

}

    public void editProcess(String editFirstNameValue,String editLastNameValue, String editEmailValue,
                            String editAgeValue,String editSalaryValue,
                            String editDepartmentValue, int tableSize){
        elementMethods.clickJSElement(editElement);

        elementMethods.clearEditElement(editFirstNameElement, editFirstNameValue);
        elementMethods.clearEditElement(editLastNameElement, editLastNameValue);
        elementMethods.clearEditElement(editEmailElement, editEmailValue);
        elementMethods.clearEditElement(editAgeElement, editAgeValue);
        elementMethods.clearEditElement(editSalaryElement, editSalaryValue);
        elementMethods.clearEditElement(editDepartmentElement, editDepartmentValue);
        elementMethods.clickElement(submitElement);
        elementMethods.waitVisibleList(newTableContentList);

        //validam valorile modificate din tabel
        String rowContent = newTableContentList.get(tableSize).getText();
        System.out.println(rowContent);
        Assert.assertTrue(rowContent.contains(editFirstNameValue),"The last row doesn't contain first name value.");
        Assert.assertTrue(rowContent.contains(editLastNameValue),"The last row doesn't contain last name value.");
        Assert.assertTrue(rowContent.contains(editEmailValue),"The last row doesn't contain user email value.");
        Assert.assertTrue(rowContent.contains(editAgeValue),"The last row doesn't contain age value.");
        Assert.assertTrue(rowContent.contains(editSalaryValue),"The last row doesn't contain salary value.");
        Assert.assertTrue(rowContent.contains(editDepartmentValue),"The last row doesn't contain departament value.");
    }

    public void deleteProcess(int tableSize){
        elementMethods.clickJSElement(deleteElement);
        Assert.assertEquals(newTableContentList.size(),tableSize,"Default size for table is not 3.");

    }
    public void quitMethod(){
    driver.quit();
    }
}
