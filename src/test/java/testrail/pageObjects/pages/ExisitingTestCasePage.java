package testrail.pageObjects.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ExisitingTestCasePage extends BasePage {
    private static final By pageLocator = By.xpath(String.format("//div[@class='io-container io-framed']"));
    private static final String SUCCESS_TEST_CASE_NOTIFICATION = "//div[@class='message message-success']";
    private static final String expectedSuccessMessage = "Successfully added the new test case. Add another";
    private static final String TEST_CASE_EDIT_BUTTON = "//span[@class='button-text']";
    private static final String TEST_CASE_SECTION = "//span[@class='title' and contains(text(),'%s')]";
    private static final String TEST_CASE_SECTION_DELETE_BUTTON = "//span[@class='title' and contains(text(),'%s')]/..//div[@class='icon-small-delete hidden action-hover']";

    public ExisitingTestCasePage() {
        super(pageLocator, "'Existing Test Case' Page");
        assertIsOpened();
    }

    @Step("Checking notification message after Test Case was created")
    public void checkSuccessNotification(){
        Assert.assertEquals(new Button(By.xpath(SUCCESS_TEST_CASE_NOTIFICATION)).getText(), expectedSuccessMessage);
    }

    @Step("Clicking on 'Edit' button")
    public void clickOnTestCaseEditButton(){
        Label editLabel = new Label(By.xpath(TEST_CASE_EDIT_BUTTON));
        editLabel.moveToElement();
        editLabel.clickAndWait();
    }

    @Step("Deleting Section")
    public void deleteSection(String sectionName){
        TextBox sectionNameTextbox = new TextBox(By.xpath(String.format(TEST_CASE_SECTION, sectionName)));
        sectionNameTextbox.moveToElement();

        TextBox deleteButton = new TextBox(By.xpath(String.format(TEST_CASE_SECTION_DELETE_BUTTON, sectionName)));
        deleteButton.moveAndClickByAction();
    }



}
