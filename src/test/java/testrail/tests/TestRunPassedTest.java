package testrail.tests;

import framework.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testrail.pageObjects.pages.*;

public class TestRunPassedTest extends BaseTest {

    @BeforeMethod
    public void loginToSite(){
        LoginPage loginPage = new LoginPage();
        loginPage.enterValidUserName();
        loginPage.enterValidUserPassword();
        loginPage.loginToSite();
    }


    @Test
    public void testCaseInTestRunPassedTest() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.openProject("netStorm");

        ExistingProjectPage existingProjectPage = new ExistingProjectPage();
        existingProjectPage.openProjectTab("Test Cases");
        existingProjectPage.clickOnTestCaseSidebarButton();

        NewTestCasePage newTestCasePage = new NewTestCasePage();
        newTestCasePage.setTestCaseTitle("Case for TestRun");
        newTestCasePage.setTestCaseSteps("Step for TestRun");
        newTestCasePage.addSaveNewTestCase();

        existingProjectPage.openProjectTab("Test Cases");
        existingProjectPage.clickOnTestCaseHeaderButton("Run Test");
        existingProjectPage.sendKeysToTestRunName("Passed TestRun");

        newTestCasePage.addSaveNewTestCase();

        existingProjectPage.addTestResultPassed();
        existingProjectPage.refreshTestRunResults();
        existingProjectPage.checkNumberOfTestsInCircle("1", "Passed");
    }

    @AfterMethod
    public void logoutFromSite(){
        TopPanelPage topPanel = new TopPanelPage();
        topPanel.navigateToUserPreferencesDropdown();
        topPanel.logoutFromSite();
    }

}
