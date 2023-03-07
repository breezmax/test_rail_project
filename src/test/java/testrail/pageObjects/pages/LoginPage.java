package testrail.pageObjects.pages;

import framework.BasePage;
import framework.PropertyReader;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private static final Label PAGE_LOCATOR = new Label(By.xpath("//a[@class='logo-loginpage']"));
    private static final String USER_NAME_FIELD = "//input[@id='name']";
    private static final String USER_PASSWORD_FIELD = "//input[@id='password']";
    private static final String LOG_IN_BUTTON = "//button[@id='button_primary']";
    private  static final By pageLocator = By.xpath("//a[@class='logo-loginpage']");
    public LoginPage() {
        super(pageLocator, "'Test Rail Login' Page");
        assertIsOpened();
    }

    @Step("Check that page was loaded")
    public  void isPageOpened(){
        Assert.assertTrue(PAGE_LOCATOR.isElementPresent(), "ERROR: Page 'Test Rail Login' was not loaded!!!");
    }

    @Step("Entering valid EMAIL")
    public void enterValidUserName(){
        TextBox userEmail = new TextBox(By.xpath(USER_NAME_FIELD));
        userEmail.click();
        userEmail.sendKeys(PropertyReader.getProperty("user.email"));
    }

    @Step("Entering valid PASSWORD")
    public void enterValidUserPassword(){
        TextBox userPassword = new TextBox(By.xpath(USER_PASSWORD_FIELD));
        userPassword.click();
        userPassword.sendKeys(PropertyReader.getProperty("user.password"));
    }

    @Step("Log in to 'Test Rail' using valid credentials")
    public void loginToSite(){
        Button loginButton = new Button(By.xpath(LOG_IN_BUTTON));
        loginButton.moveAndClickByAction();
    }



}
