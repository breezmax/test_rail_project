package testrail.tests;

import framework.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testrail.pageObjects.pages.*;

public class CreatingMilestoneTest extends BaseTest {

    @BeforeMethod
    public void loginToSite(){
        LoginPage loginPage = new LoginPage();
        loginPage.enterValidUserName();
        loginPage.enterValidUserPassword();
        loginPage.loginToSite();
    }

    @Test
    public void creatingNewMilestoneTest() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.openProject("netStorm");

        ExistingProjectPage existingProjectPage = new ExistingProjectPage();
        existingProjectPage.openProjectTab("Milestones");
        existingProjectPage.clickOnMilestoneSidebarButton();

        MilestoneFormPage milestoneFormPage = new MilestoneFormPage();
        milestoneFormPage.setMilestoneName("Milestone via Selenium");
        milestoneFormPage.setMilestoneStartDate("3/1/2023");
        milestoneFormPage.setMilestoneEndDate("3/28/2023");
        milestoneFormPage.addNewMilestone();
        milestoneFormPage.checkSuccessNotification();
        milestoneFormPage.checkProjectInGrid("Milestone via Selenium");
        milestoneFormPage.clickOnDeleteMilestoneButton("Milestone via Selenium");

        DeleteDialogPage deleteDialogPage = new DeleteDialogPage();
        deleteDialogPage.deleteItem();
    }


    @AfterMethod
    public void logoutFromSite(){
        TopPanelPage topPanel = new TopPanelPage();
        topPanel.navigateToUserPreferencesDropdown();
        topPanel.logoutFromSite();
    }
}
