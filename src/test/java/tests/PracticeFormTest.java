package tests;

import helpMethods.ElementMethods;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormsPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.clickPracticeFormSubMenu();

        String firstNameValue = "Dobre";
        String lastNameValue = "Magda";
        String userEmailValue = "Magda@gmail.com";
        String genderValue = "Male";
        String mobileNumberlValue = "0745698745";
        String monthValue = "January";
        String yearValue = "2030";
        String dayValue = "15";
        List<String> subjectValues = Arrays.asList("Accounting", "Maths", "English");
        List<String> hobbiesValues = Arrays.asList("Sports", "Music");
        String pathFile = "src/test/resources/Tema 1.txt";
        String currentAddressValue = "Bucuresti, nr.02";
        String stateValue = "NCR";
        String cityValue = "Delhi";

        PracticeFormsPage practiceFormsPage = new PracticeFormsPage(getDriver());
        practiceFormsPage.fillEntireForm(firstNameValue, lastNameValue, userEmailValue, genderValue,mobileNumberlValue,monthValue,yearValue,dayValue,
                subjectValues,hobbiesValues,pathFile,currentAddressValue,stateValue,cityValue);
        practiceFormsPage.validateFormValues(firstNameValue,lastNameValue,userEmailValue,genderValue,
                mobileNumberlValue,subjectValues,hobbiesValues,pathFile,currentAddressValue,stateValue,cityValue);
    }
}

