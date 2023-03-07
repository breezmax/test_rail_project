package testrail.tests;

import framework.BaseTest;
import org.testng.annotations.Test;
import testrail.pageObjects.pages.LoginPage;
import testrail.pageObjects.pages.TopPanelPage;

public class UserLoginLogoutTest extends BaseTest {

    @Test
    public void loginTestRailTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterValidUserName();
        loginPage.enterValidUserPassword();
        loginPage.loginToSite();

        TopPanelPage topPanel = new TopPanelPage();
        topPanel.navigateToUserPreferencesDropdown();
        topPanel.logoutFromSite();
    }
}
