package testrail.pageObjects.pages;

import framework.BasePage;
import framework.elements.Label;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class NewTestCasePage extends BasePage {

    private static final By pageLocator = By.xpath("//a[@id='navigation-project']");
    private static final String TEST_CASE_TITLE_FIELD = "//input[@id='title']";
    private static final String TEST_CASE_PRECONDITION_FIELD = "//div[@id='custom_preconds_display']";
    private static final String TEST_CASE_STEPS_FIELD = "//div[@id='custom_steps_display']";
    private static final String TEST_CASE_EXPECTED_RESULT_FIELD = "//div[@id='custom_expected_display']";
    private static final String TEST_CASE_ADD_TEST_CASE_BUTTON = "//button[@id='accept']";
    private static final String TEST_CASE_CANCEL_BUTTON = "//div[@class='button-group']/a[contains(text(),'Cancel')]";
    public NewTestCasePage() {
        super(pageLocator, "'New Test Case' Page");
        assertIsOpened();
    }

    public void checkValuesInTestCasesFields(String preconditionFieldExpectedResult, String stepsFieldExpectedResult, String expectedResulFieldExpectedResult){
        checkValueInPreconditionField(preconditionFieldExpectedResult);
        checkValueInStepsField(stepsFieldExpectedResult);
        checkValueInExpResultField(expectedResulFieldExpectedResult);
    }
    @Step("Filling Test Case 'Title' field")
    public void setTestCaseTitle(String testCaseTitle){
        TextBox titleBox = new TextBox(By.xpath(TEST_CASE_TITLE_FIELD));
        titleBox.click();
        titleBox.sendKeys(testCaseTitle);
    }

    @Step("Filling Test Case 'Precondition' field")
    public void setTestCasePrecondition(String testCasePrecondition){
        TextBox preconditionBox = new TextBox(By.xpath(TEST_CASE_PRECONDITION_FIELD));
        preconditionBox.click();
        preconditionBox.sendKeys(testCasePrecondition);
    }

    @Step("Filling Test Case 'Steps' field")
    public void setTestCaseSteps(String testCaseSteps){
        TextBox stepsBox = new TextBox(By.xpath(TEST_CASE_STEPS_FIELD));
        stepsBox.click();
        stepsBox.sendKeys(testCaseSteps);
    }

    @Step("Filling Test Case 'Expected Result' field")
    public void setTestCaseExpResult(String testCaseExpResult){
        TextBox expResultBox = new TextBox(By.xpath(TEST_CASE_EXPECTED_RESULT_FIELD));
        expResultBox.click();
        expResultBox.sendKeys(testCaseExpResult);
    }

    @Step("Clicking on 'Add/Save Test Case' button")
    public void addSaveNewTestCase(){
        Label addTestCaseLabel = new Label(By.xpath(TEST_CASE_ADD_TEST_CASE_BUTTON));
        addTestCaseLabel.moveAndClickByAction(); //возможно нужен wait
    }

    @Step("Clicking on 'Cancel Test Case' button")
    public void cancelTestCaseChanges(){
        Label cancelTestCaseLabel = new Label(By.xpath(TEST_CASE_CANCEL_BUTTON));
        cancelTestCaseLabel.moveAndClickByAction();
    }

    @Step("Checking 'Precondition' value")
    public void checkValueInPreconditionField(String expectedResult){
        TextBox preconditionField = new TextBox(By.xpath(TEST_CASE_PRECONDITION_FIELD));
        Assert.assertEquals(preconditionField.getText(), expectedResult);
    }

    @Step("Checking 'Steps' value")
    public void checkValueInStepsField(String expectedResult){
        TextBox stepsField = new TextBox(By.xpath(TEST_CASE_STEPS_FIELD));
        Assert.assertEquals(stepsField.getText(), expectedResult);
    }

    @Step("Checking 'Expected Result' value")
    public void checkValueInExpResultField(String expectedResult){
        TextBox expResultField = new TextBox(By.xpath(TEST_CASE_EXPECTED_RESULT_FIELD));
        Assert.assertEquals(expResultField.getText(), expectedResult);
    }

}
