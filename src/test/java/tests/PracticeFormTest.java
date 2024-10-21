package tests;

import configFiles.DataConfig;
import modelObject.PracticeFormModel;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormsPage;
import sharedData.Hooks;

public class PracticeFormTest extends Hooks {

    @Test
    public void metodaTest() {
        PracticeFormModel testData = new PracticeFormModel(DataConfig.PRACTICEFORM_DATA);

        HomePage homePage = new HomePage(getDriver());
        homePage.clickFormsMenu();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.clickPracticeFormSubMenu();

        PracticeFormsPage practiceFormsPage = new PracticeFormsPage(getDriver());
        practiceFormsPage.fillEntireForm(testData);
        practiceFormsPage.validateFormValues(testData);
    }
}

