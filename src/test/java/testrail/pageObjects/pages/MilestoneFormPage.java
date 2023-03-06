package testrail.pageObjects.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MilestoneFormPage extends BasePage {
    private static final String expectedSuccessMessage = "Successfully added the new milestone.";
    private static final String SUCCESS_MILESTONE_NOTIFICATION = "//div[@class='message message-success']";
    private static final String MILESTONE_NAME_FIELD = "//input[@id='name']";
    private static final String MILESTONE_START_DATE_FIELD = "//input[@id='start_on']";
    private static final String MILESTONE_END_DATE_FIELD = "//input[@id='due_on']";
    private static final String MILESTONE_ADD_BUTTON = "//button[@id='accept']";
    private static final String MILESTONE_IN_THE_GRID = "//div[@class='summary-title summary-title-compact text-ppp']/a[contains(text(),'%s')]";
    private static final String MILESTONE_DELETE_BUTTON = "//div[@class='summary-title summary-title-compact text-ppp']/a[contains(text(),'%s')]/../../../div/a[@class='deleteLink']";
    private static final By pageLocator = By.xpath("//div[@class='content-header-title page_title' and contains(text(),'Add Milestone')]");


    public MilestoneFormPage() {
        super(pageLocator, "'New Milestone' Page");
    }

    @Step("Filling Milestone 'Name' field")
    public void setMilestoneName(String milestoneName){
        TextBox titleBox = new TextBox(By.xpath(MILESTONE_NAME_FIELD));
        titleBox.click();
        titleBox.sendKeys(milestoneName);
    }

    @Step("Filling Milestone 'Start Date' field")
    public void setMilestoneStartDate(String milestoneStartDate){
        TextBox titleBox = new TextBox(By.xpath(MILESTONE_START_DATE_FIELD));
        titleBox.click();
        titleBox.sendKeys(milestoneStartDate);
    }

    @Step("Filling Milestone 'End Date' field")
    public void setMilestoneEndDate(String milestoneEndDate){
        TextBox titleBox = new TextBox(By.xpath(MILESTONE_END_DATE_FIELD));
        titleBox.click();
        titleBox.sendKeys(milestoneEndDate);
    }

    @Step("Clicking on 'Add Milestone' button")
    public void addNewMilestone(){
        Label addTestCaseLabel = new Label(By.xpath(MILESTONE_ADD_BUTTON));
        addTestCaseLabel.moveAndClickByAction();
    }

    @Step("Checking 'Success' message")
    public void checkSuccessNotification(){
        Assert.assertEquals(new Button(By.xpath(SUCCESS_MILESTONE_NOTIFICATION)).getText(), expectedSuccessMessage);
    }

    @Step("Checking that new milestone displayed in the grid")
    public void checkProjectInGrid(String milestoneName){
        Assert.assertTrue(new Label(By.xpath(String.format(MILESTONE_IN_THE_GRID, milestoneName))).isElementPresent(), "Error: 'Project' was not created");
    }

    @Step("Clicking on 'Delete milestone' button")
    public void clickOnDeleteMilestoneButton(String milestoneName){
        Button deleteMilestoneButton = new Button(By.xpath(String.format(MILESTONE_DELETE_BUTTON, milestoneName)));
        deleteMilestoneButton.moveAndClickByAction();
    }
}
