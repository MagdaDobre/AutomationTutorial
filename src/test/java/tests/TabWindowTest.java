package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.TabWindowPage;
import sharedData.Hooks;

public class TabWindowTest extends Hooks {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickBrowserWindow();

        TabWindowPage tabWindowPage = new TabWindowPage(getDriver());
        tabWindowPage.dealTabProcess();
        tabWindowPage.dealWindowProcess();
    }
}

