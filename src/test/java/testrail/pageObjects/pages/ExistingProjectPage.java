package testrail.pageObjects.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ExistingProjectPage extends BasePage {

    private static final By pageLocator = By.xpath("//a[@id='navigation-project']");
    private static final String NAVIGATE_TAB = "//li/a[contains(text(),'%s')]";
    private static final String TEST_CASE_SIDEBAR_BUTTON = "//a[@id='sidebar-cases-add']";
    private static final String ADD_MILESTONE_SIDEBAR_BUTTON = "//a[@id='navigation-milestones-add']";
    private static final String TEST_CASE_HEADER_BUTTON = "//span[@class='button-text' and contains(text(),'%s')]";
    private static final String TEST_RUN_NAME_FIELD = "//input[@id='name']";
    private static final String TEST_RUN_PASSES_NEXT = "//a[@id='addResultAndNext']";
    private static final String TEST_RUN_CIRCLE_VALIDATION = "//div[@id='statusChartContainer']/*/*/*/*/div[@class='chart-legend-name text-ppp' and contains(text(),'%s')]";
    private static final String expectedResultCircleValidation = "%s %s";
    private static final String TEST_RUN_REFRESH = "//a[@id='navigation-runs-testsresults']";

    public ExistingProjectPage() {
        super(pageLocator, "'Existing Project' Page");
        assertIsOpened();
    }

    @Step("Opening tab")
    public void openProjectTab(String projectTab){
        Button tabButton = new Button(By.xpath(String.format(NAVIGATE_TAB, projectTab)));
        tabButton.moveToElement();
        tabButton.clickAndWait();
    }

    @Step("Clicking on button")
    public void clickOnTestCaseSidebarButton(){
        Button tCaseButton = new Button(By.xpath(TEST_CASE_SIDEBAR_BUTTON));
        tCaseButton.moveToElement();
        tCaseButton.clickAndWait();
    }

    @Step("Clicking on 'Add Milestone' sidebar button")
    public void clickOnMilestoneSidebarButton(){
        Button milestoneButton = new Button(By.xpath(ADD_MILESTONE_SIDEBAR_BUTTON));
        milestoneButton.moveToElement();
        milestoneButton.clickAndWait();
    }

    @Step("Clicking on TestCase Header button")
    public void clickOnTestCaseHeaderButton(String headerButtonName){
        Label headerNameLabel = new Label(By.xpath(String.format(TEST_CASE_HEADER_BUTTON,headerButtonName)));
        headerNameLabel.moveToElement();
        headerNameLabel.click();
    }

    @Step("Clicking on TestCase Header button")
    public void sendKeysToTestRunName(String testRunNameValue){
        TextBox testRunName = new TextBox(By.xpath(TEST_RUN_NAME_FIELD));
        testRunName.moveToElement();
        testRunName.click();
        testRunName.clear();
        testRunName.sendKeys(testRunNameValue);
    }

    @Step("Clicking on 'Add Test Result' button")
    public void addTestResultPassed(){
        Button addResultTestRun = new Button(By.xpath(TEST_RUN_PASSES_NEXT));
        addResultTestRun.moveToElement();
        addResultTestRun.clickAndWait();
    }

    @Step("Refreshing Test Run")
    public void refreshTestRunResults(){
        Label refreshTestRun = new Label(By.xpath(TEST_RUN_REFRESH));
        refreshTestRun.moveToElement();
        refreshTestRun.clickAndWait();
    }

    @Step("Checking Number of Test in Test Run")
    public void checkNumberOfTestsInCircle(String numberOfTests, String setTestStatus){
        Assert.assertEquals(new TextBox(By.xpath(String.format(TEST_RUN_CIRCLE_VALIDATION, setTestStatus))).getText(), String.format(expectedResultCircleValidation, numberOfTests, setTestStatus));
    }
}
