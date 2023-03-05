package testrail.pageObjects.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.DropDown;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    private static final String USER_DROPDOWN = "//a[@id='navigation-user']";
    private static final String LOGOUT_VALUE_IN_DROPDOWN = "//a[@id='navigation-user-logout']";
    private  static final By pageLocator = By.xpath("//div[@class='top-section text-ppp'][contains(text(),'TestRail QA')]");
    private static final String ADD_NEW_PROJECT = "//a[@id='sidebar-projects-add']";

    public DashboardPage() {
        super(pageLocator, "'Dashboard' Page");
        assertIsOpened();
    }

    @Step("Open to user's preferences dropdown")
    public void navigateToUserPreferencesDropdown(){
        Button userSettingButton = new Button(By.xpath(USER_DROPDOWN));
        userSettingButton.moveToElement();
        userSettingButton.click();
    }

    @Step("Log out from 'Test Rail' site")
    public void logoutFromSite(){
        DropDown logoutValue = new DropDown(By.xpath(LOGOUT_VALUE_IN_DROPDOWN));
        logoutValue.clickAndWait();
    }

    @Step("Clicking to 'Add Project' button")
    public void addNewProject(){
        Button newProjectButton = new Button(By.xpath(ADD_NEW_PROJECT));
        newProjectButton.clickAndWait();
    }
}
