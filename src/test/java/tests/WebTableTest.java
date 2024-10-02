package tests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;
import sharedData.SharedData;

public class WebTableTest extends SharedData {
    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickElements();

        ElementsPage elementsPage = new ElementsPage(getDriver());
        elementsPage.clickWebTable();

        String firstNameValue = "Dobre";
        String lastNameValue = "Magda";
        String userEmailValue = "magda" + System.currentTimeMillis() + "@gmail.com";
        String ageValue = "34";
        String salaryValue = "2345";
        String departmentValue = "IT";

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.createProcess(firstNameValue, lastNameValue, userEmailValue, ageValue,
                salaryValue, departmentValue, 3);

        String editFirstNameValue = "Gheorghe";
        String editLastNameValue = "Popescu";
        String editEmailValue = "popescu@gmail.com";
        String editAgeValue = "24";
        String editSalaryValue = "30000";
        String editDepartmentValue = "HR";

        webTablePage.editProcess(editFirstNameValue, editLastNameValue, editEmailValue, editAgeValue, editSalaryValue, editDepartmentValue, 3);
        webTablePage.deleteProcess(3);
        webTablePage.quitMethod();
    }
}
