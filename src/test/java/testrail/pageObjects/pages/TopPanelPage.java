package testrail.pageObjects.pages;

import framework.BasePage;
import framework.BaseTest;
import framework.elements.Button;
import framework.elements.DropDown;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TopPanelPage extends BasePage {

    private static final By pageLocator = By.xpath("//div[@class='top-panel']");
    private static final String USER_DROPDOWN = "//a[@id='navigation-user']";
    private static final String LOGOUT_VALUE_IN_DROPDOWN = "//a[@id='navigation-user-logout']";
    public TopPanelPage() {
        super(pageLocator, "'Top Panel' Page");
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
}
