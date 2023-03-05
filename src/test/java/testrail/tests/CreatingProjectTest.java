package testrail.tests;

import framework.BaseTest;
import org.testng.annotations.*;
import testrail.pageObjects.pages.DashboardPage;
import testrail.pageObjects.pages.LoginPage;
import testrail.pageObjects.pages.NewProjectPage;
import testrail.pageObjects.pages.TopPanelPage;

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

        NewProjectPage newProjectPage = new NewProjectPage();
        newProjectPage.enterNameForNewProject("My Test Project");
        newProjectPage.clickOnAddProjectButton();
        newProjectPage.checkSuccessNotification();
        newProjectPage.checkProjectInGrid("My Test Project");
    }

    @AfterMethod
    public void logoutFromSite(){
        NewProjectPage newProjectPage = new NewProjectPage();
        newProjectPage.clickOnDeleteProjectButton("My Test Project");
        newProjectPage.setFlagAndDeleteProject();

        TopPanelPage topPanel = new TopPanelPage();
        topPanel.navigateToUserPreferencesDropdown();
        topPanel.logoutFromSite();
    }
}
