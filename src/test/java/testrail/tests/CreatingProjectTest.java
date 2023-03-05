package testrail.tests;

import framework.BaseTest;
import org.testng.annotations.*;
import testrail.pageObjects.pages.DashboardPage;
import testrail.pageObjects.pages.LoginPage;
import testrail.pageObjects.pages.ProjectPage;

public class CreatingProjectTest extends BaseTest {

    @BeforeMethod
    public void loginToSite(){
        LoginPage loginPage = new LoginPage();
        loginPage.enterValidUserName();
        loginPage.enterValidUserPassword();
        loginPage.loginToSite();
    }

    @Test
    public void creatingNewProjectTest() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.addNewProject();

        ProjectPage projectPage = new ProjectPage();
        projectPage.enterNameForNewProject("My Test Project");
        projectPage.clickOnAddProjectButton();
        projectPage.checkSuccessNotification();
        projectPage.checkProjectInGrid("My Test Project");
    }

    @AfterMethod
    public void logoutFromSite(){
        ProjectPage projectPage = new ProjectPage();
        projectPage.clickOnDeleteProjectButton("My Test Project");
        projectPage.setFlagAndDeleteProject();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToUserPreferencesDropdown();
        dashboardPage.logoutFromSite();
    }
}
