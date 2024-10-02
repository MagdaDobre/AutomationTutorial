package tests;

import helpMethods.ElementMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeFormsTestPage;
import sharedData.SharedData;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementMethods elementMethods = new ElementMethods(getDriver());
        PracticeFormsTestPage practiceFormsTestPage = new PracticeFormsTestPage(getDriver());


        //identificarea unui element dupa text - xpath (tag, atribut, valoare) - identificare relativa // sau absoluta /- nu facem absolut (ex://h5[text()= "Elements"])

//        WebElement formsMenu = driver.findElement(By.xpath("//h5[text()= 'Forms']"));
//        elementMethods.clickJSElement(formsMenu);
        practiceFormsTestPage.clickFormsMenu();

        WebElement practiceFormSubMenu = getDriver().findElement(By.xpath("//span[text()='Practice Form']"));
        elementMethods.clickJSElement(practiceFormSubMenu);

        WebElement firstNameElement = getDriver().findElement(By.id("firstName"));
        String firstNameValue = "Dobre";
        elementMethods.fillElement(firstNameElement,firstNameValue);

        WebElement lastNameElement = getDriver().findElement(By.id("lastName"));
        String lastNameValue = "Magda";
        elementMethods.fillElement(lastNameElement,lastNameValue);

        WebElement userEmailElement = getDriver().findElement(By.id("userEmail"));
        String userEmailValue = "Magda@gmail.com";
        elementMethods.fillElement(userEmailElement,userEmailValue);

        List<WebElement> genderOptionsList = getDriver().findElements(By.xpath("//input[@name='gender']/../label"));
        String genderValue = "Male";

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

        WebElement mobileNumberElement = getDriver().findElement(By.id("userNumber"));
        String mobileNumberlValue = "0745698745";
        elementMethods.fillElement(mobileNumberElement,mobileNumberlValue);

        //date of BIrth interaction
        WebElement dateOfBirthElement = getDriver().findElement(By.id("dateOfBirthInput"));
        elementMethods.clickJSElement(dateOfBirthElement);

        WebElement monthElement = getDriver().findElement(By.className("react-datepicker__month-select"));
        String monthValue = "January";
        elementMethods.selectDropDownElement(monthElement,monthValue);

        WebElement yearElement =  getDriver().findElement(By.className("react-datepicker__year-select"));
        String yearValue = "2030";
        elementMethods.selectDropDownElement(yearElement,yearValue);

        String dayValue = "15";
        List<WebElement> daysList = getDriver().findElements(By.xpath("//div[@class = 'react-datepicker__month']/div/div[not(contains(@class,'react-datepicker__day--outside-month'))]"));
        for (int index = 0; index < daysList.size();index++){
            if (daysList.get(index).getText().equals(dayValue)){
                elementMethods.clickElement(daysList.get(index));
                break;
            }
        }


        WebElement subjectElement = getDriver().findElement(By.id("subjectsInput"));
        List<String> subjectValues = Arrays.asList("Accounting", "Maths", "English");
        for (int index = 0; index < subjectValues.size(); index++) {
            elementMethods.fillPressElement(subjectElement,subjectValues.get(index),Keys.ENTER);

        }

        List<String> hobbiesValues = Arrays.asList("Sports", "Music");
        List<WebElement> hobbiesOptionsList = getDriver().findElements(By.xpath("//div[@id='hobbiesWrapper']//label[@class = 'custom-control-label']"));

        for (int index = 0; index < hobbiesOptionsList.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (hobbiesValues.contains(currentText)) {
                elementMethods.clickJSElement(hobbiesOptionsList.get(index));
            }
        }

        WebElement pictureElement = getDriver().findElement(By.id("uploadPicture"));
        // path absolut, nu merge la toata lumea, daca este fisier local.
        // trebuie relativ - partea de resources
        //pictureElement.sendKeys("src/test/resources/Tema 1.txt"); - asa nu merge

        File file = new File("src/test/resources/Tema 1.txt");
        elementMethods.fillElement(pictureElement,file.getAbsolutePath());

        WebElement currentAddressElement = getDriver().findElement(By.id("currentAddress"));
        String currentAddressValue = "Bucuresti, nr.02";
        elementMethods.fillElement(currentAddressElement, currentAddressValue);

        WebElement stateElement = getDriver().findElement(By.xpath("//div[text()= 'Select State']"));
        elementMethods.clickJSElement(stateElement);

        WebElement stateInputElement = getDriver().findElement(By.id("react-select-3-input"));
        String stateValue = "NCR";
        elementMethods.fillPressElement(stateInputElement,stateValue,Keys.ENTER);

        WebElement cityElement = getDriver().findElement(By.xpath("//div[text()= 'Select City']"));
        elementMethods.clickJSElement(cityElement);

        WebElement cityInputElement = getDriver().findElement(By.id("react-select-4-input"));
        String cityValue = "Delhi";
        elementMethods.fillPressElement(cityInputElement,cityValue, Keys.ENTER);

        WebElement submitElement = getDriver().findElement(By.id("submit"));
        elementMethods.clickJSElement(submitElement);

        //validam datele introduse

        WebElement thankyouElement = getDriver().findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertEquals(thankyouElement.getText(),"Thanks for submitting the form");

        List<WebElement> labelList = getDriver().findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']//td[1]"));
        List<WebElement> valuesList = getDriver().findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']//td[2]"));

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
        Assert.assertEquals(valuesList.get(5).getText(), subjectValues);
        Assert.assertEquals(valuesList.get(6).getText(), hobbiesValues);
        Assert.assertEquals(valuesList.get(7).getText(), file);
        Assert.assertEquals(valuesList.get(8).getText(), currentAddressValue);
        Assert.assertEquals(valuesList.get(9).getText(), stateValue + cityValue);



    }

}

