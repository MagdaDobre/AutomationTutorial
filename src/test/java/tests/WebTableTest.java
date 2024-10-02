package tests;

import helpMethods.AlertMethods;
import helpMethods.ElementMethods;
import helpMethods.TabMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;

import java.util.List;

public class WebTableTest extends SharedData {
    @Test
    public void metodaTest() {

      HomePage homePage = new HomePage(getDriver());
      homePage.clickElements();

      ElementsPage elementsPage = new ElementsPage(getDriver());
      elementsPage.clickWebTable();



      //identificarea unui element dupa text - xpath (tag, atribut, valoare) - identificare relativa // sau absoluta /- nu facem absolut (ex://h5[text()= "Elements"])

//      WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()= 'Elements']"));
////      JavascriptExecutor js = (JavascriptExecutor)driver;
////      js.executeScript("arguments[0].click();", elementsMenu);
//      elementMethods.clickJSElement(elementsMenu);
//
//      WebElement webTablesSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
////      js.executeScript("arguments[0].click();", webTablesSubMenu);
//      elementMethods.clickJSElement(webTablesSubMenu);

      //validam dimensiunea initiala a tabelului

//      List<WebElement> tableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
//      Assert.assertEquals(tableContentList.size(),3,"Default size for table is not 3.");


//      //definim un element
//      WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
////      addElement.click();
//      elementMethods.clickElement(addElement);

//      WebElement firstNameElement = driver.findElement(By.id("firstName"));
      String firstNameValue = "Dobre";
//      firstNameElement.sendKeys(firstNameValue);
//      elementMethods.fillElement(firstNameElement,firstNameValue);

//      WebElement lastNameElement = driver.findElement(By.id("lastName"));
      String lastNameValue = "Magda";
//      lastNameElement.sendKeys(lastNameValue);
//      elementMethods.fillElement(lastNameElement,lastNameValue);

//      WebElement userEmailElement = driver.findElement(By.id("userEmail"));
//System.currentTimeMillis()+ = daca avem nevoie de generare valoare random
      String userEmailValue = "magda" + System.currentTimeMillis()+ "@gmail.com";
//      userEmailElement.sendKeys(userEmailValue);
//      elementMethods.fillElement(userEmailElement,userEmailValue);

//      WebElement ageElement = driver.findElement(By.id("age"));
      String ageValue = "34";
//      ageElement.sendKeys(ageValue);
//      elementMethods.fillElement(ageElement,ageValue);

//      WebElement salaryElement = driver.findElement(By.id("salary"));
      String salaryValue = "2345";
//      salaryElement.sendKeys(salaryValue);
//      elementMethods.fillElement(salaryElement,salaryValue);

//      WebElement departmentElement = driver.findElement(By.id("department"));
      String departmentValue = "IT";
////      departmentElement.sendKeys(departmentValue);
//      elementMethods.fillElement(departmentElement,departmentValue);

//      WebElement submitElement = driver.findElement(By.id("submit"));
////      submitElement.click();
//      elementMethods.clickElement(submitElement);

//      //validam noua dimensiune a tabelului
//      List<WebElement> newTableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
//      Assert.assertEquals(newTableContentList.size(),4,"Default size for table is not 4.");

//      //validam valorile pe care le-am introdus
//      String rowContent = newTableContentList.get(3).getText();
//      Assert.assertTrue(rowContent.contains(firstNameValue),"The last row doesn't contain first name value.");
//      Assert.assertTrue(rowContent.contains(lastNameValue),"The last row doesn't contain last name value.");
//      Assert.assertTrue(rowContent.contains(userEmailValue),"The last row doesn't contain user email value.");
//      Assert.assertTrue(rowContent.contains(ageValue),"The last row doesn't contain age value.");
//      Assert.assertTrue(rowContent.contains(salaryValue),"The last row doesn't contain salary value.");
//      Assert.assertTrue(rowContent.contains(departmentValue),"The last row doesn't contain departament value.");


      WebTablePage webTablePage = new WebTablePage(getDriver());
      webTablePage.createProcess(firstNameValue, lastNameValue, userEmailValue,ageValue,
              salaryValue, departmentValue, 3);
      //function edit
//
//      WebElement editElement = driver.findElement(By.id("edit-record-4"));
//      js.executeScript("arguments[0].click();", editElement);
//      elementMethods.clickJSElement(editElement);
//
//      //edit firstNameElement
//      WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
      String editFirstNameValue = "Gheorghe";
////      editFirstNameElement.clear();
////      editFirstNameElement.sendKeys(editFirstNameValue);
//      elementMethods.clearEditElement(editFirstNameElement, editFirstNameValue);
//
//      WebElement editLastNameElement = driver.findElement(By.id("lastName"));
      String editLastNameValue = "Popescu";
////      editLastNameElement.clear();
////      editLastNameElement.sendKeys(editLastNameValue);
//      elementMethods.clearEditElement(editLastNameElement, editLastNameValue);
//
//      WebElement editEmailElement = driver.findElement(By.id("userEmail"));
      String editEmailValue = "popescu@gmail.com";
////      editEmailElement.clear();
////      editEmailElement.sendKeys(editEmailValue);
//      elementMethods.clearEditElement(editEmailElement, editEmailValue);
//
//      WebElement editAgeElement = driver.findElement(By.id("age"));
      String editAgeValue = "24";
////      editAgeElement.clear();
////      editAgeElement.sendKeys(editAgeValue);
//      elementMethods.clearEditElement(editAgeElement, editAgeValue);
//
//      WebElement editSalaryElement = driver.findElement(By.id("salary"));
      String editSalaryValue = "30000";
////      editSalaryElement.clear();
////      editSalaryElement.sendKeys(editSalaryValue);
//      elementMethods.clearEditElement(editSalaryElement, editSalaryValue);
//
//      WebElement editDepartmentElement = driver.findElement(By.id("department"));
      String editDepartmentValue = "HR";
////      editDepartmentElement.clear();
////      editDepartmentElement.sendKeys(editDepartmentValue);
//      elementMethods.clearEditElement(editDepartmentElement, editDepartmentValue);
//
//      WebElement editSubmitElement = driver.findElement(By.id("submit"));
////      editSubmitElement.click();
//      elementMethods.clickElement(editSubmitElement);

//      //validam valorile modificate din tabel
//      rowContent = newTableContentList.get(3).getText();
//      Assert.assertTrue(rowContent.contains(editFirstNameValue),"The last row doesn't contain first name value.");
//      Assert.assertTrue(rowContent.contains(editLastNameValue),"The last row doesn't contain last name value.");
//      Assert.assertTrue(rowContent.contains(editEmailValue),"The last row doesn't contain user email value.");
//      Assert.assertTrue(rowContent.contains(editAgeValue),"The last row doesn't contain age value.");
//      Assert.assertTrue(rowContent.contains(editSalaryValue),"The last row doesn't contain salary value.");
//      Assert.assertTrue(rowContent.contains(editDepartmentValue),"The last row doesn't contain departament value.");


  webTablePage.editProcess(editFirstNameValue,editLastNameValue, editEmailValue,editAgeValue, editSalaryValue, editDepartmentValue,3);
  webTablePage.deleteProcess(3);

  //delete element


//      WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
////      js.executeScript("arguments[0].click();", deleteElement);
//      elementMethods.clickJSElement(deleteElement);
//
//      newTableContentList = driver.findElements(By.xpath("//div[@class = 'rt-tbody']/div/div[@class = 'rt-tr -odd' or @class = 'rt-tr -even']"));
//      Assert.assertEquals(newTableContentList.size(),3,"Default size for table is not 3.");

      webTablePage.quitMethod();
    }


//    tema - testul de practice form
}
