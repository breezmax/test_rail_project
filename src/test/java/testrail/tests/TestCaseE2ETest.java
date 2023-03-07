package testrail.tests;

import framework.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testrail.pageObjects.pages.*;

public class TestCaseE2ETest extends BaseTest {

    @BeforeMethod
    public void loginToSite(){
        LoginPage loginPage = new LoginPage();
        loginPage.enterValidUserName();
        loginPage.enterValidUserPassword();
        loginPage.loginToSite();
    }

    @Test
    public void testCaseEndToEndTest() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.openProject("netStorm");

        ExistingProjectPage existingProjectPage = new ExistingProjectPage();
        existingProjectPage.openProjectTab("Test Cases");
        existingProjectPage.clickOnTestCaseSidebarButton();

        NewTestCasePage newTestCasePage = new NewTestCasePage();
        newTestCasePage.setTestCaseTitle("Selenium E2E");
        newTestCasePage.setTestCasePrecondition("E2E Precondition");
        newTestCasePage.setTestCaseSteps("E2E Steps");
        newTestCasePage.setTestCaseExpResult("E2E Expected Result");
        newTestCasePage.addSaveNewTestCase();

        ExisitingTestCasePage exisitingTestCasePage = new ExisitingTestCasePage();
        exisitingTestCasePage.checkSuccessNotification();
        exisitingTestCasePage.clickOnTestCaseEditButton();

        newTestCasePage.checkValuesInTestCasesFields("E2E Precondition", "E2E Steps", "E2E Expected Result");
        newTestCasePage.setTestCaseSteps(" UPDATED");
        newTestCasePage.addSaveNewTestCase();

        exisitingTestCasePage.clickOnTestCaseEditButton();

        newTestCasePage.checkValueInStepsField("E2E Steps UPDATED");
        newTestCasePage.cancelTestCaseChanges();

        existingProjectPage.openProjectTab("Test Cases");

        exisitingTestCasePage.deleteSection("Test Cases");

        DeleteDialogPage deleteDialogPage = new DeleteDialogPage();
        deleteDialogPage.setFlagAndDeleteItem();
    }

    @AfterMethod
    public void logoutFromSite(){
        TopPanelPage topPanel = new TopPanelPage();
        topPanel.navigateToUserPreferencesDropdown();
        topPanel.logoutFromSite();
    }
}
