package tests;

import org.testng.annotations.Test;
import pages.AlertFrameWindowPage;
import pages.HomePage;
import pages.NestedFramePage;
import sharedData.Hooks;

public class NestedFramesTest extends Hooks {

    @Test
    public void metodaTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickNestedFrameSubMenu();

        NestedFramePage nestedFramePage = new NestedFramePage(getDriver());
        nestedFramePage.dealNestedFrame();
    }
}
