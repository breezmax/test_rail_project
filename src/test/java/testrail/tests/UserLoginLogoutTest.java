package testrail.tests;

import framework.BaseTest;
import org.testng.annotations.Test;
import testrail.pageObjects.pages.LoginPage;
import testrail.pageObjects.pages.DashboardPage;

public class UserLoginLogoutTest extends BaseTest {

    @Test
    public void loginTestRailTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterValidUserName();
        loginPage.enterValidUserPassword();
        loginPage.loginToSite();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToUserPreferencesDropdown();
        dashboardPage.logoutFromSite();
    }
}
