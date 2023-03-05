package testrail.pageObjects.pages;

import framework.BasePage;
import framework.PropertyReader;
import framework.elements.Button;
import framework.elements.CheckBox;
import framework.elements.Label;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.apache.commons.lang3.StringEscapeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.testng.Assert;

public class ProjectPage extends BasePage {
    private static final String expectedSuccessMessage = "Successfully added the new project.";
    private static final Label PAGE_LOCATOR = new Label(By.xpath(String.format("//div[@class='content-header-title page_title'][contains(text(),'%s')]", "Add Project")));
    private static final By pageLOCATOR = By.xpath(String.format("//div[@class='content-header-title page_title'][contains(text(),'%s')]", "Add Project"));
    private static final String NEW_PROJECT_NAME_FIELD = "//input[@id='name']";
    private static final String ADD_NEW_PROJECT_BUTTON = "//button[@id='accept']";
    private static final String SUCCESS_PROJECT_NOTIFICATION = "//div[@class='message message-success']";
    private static final String PROJECT_IN_THE_GRID = "//tr/td/a[contains(text(),'%s')]";
    private static final String DELETE_PROJECT_BUTTON = "//a[contains(text(),'%s')]/../..//div[@class='icon-small-delete']";
    private static final String DELETE_CONFORMATION_FLAG = "//span[@class='dialog-confirm']/strong[contains(text(),'Yes, delete')]";
    private static final String DELETE_CONFORMATION_BUTTON = "//div[@id='deleteDialog']//a[@class='button button-ok button-left button-positive dialog-action-default' and contains(text(),'OK')]";

    public ProjectPage() {
        super(pageLOCATOR, "'Add new Project' Page");
        assertIsOpened();
    }

    @Step("Check that page was loaded")
    public  void isPageOpened(){
        Assert.assertTrue(PAGE_LOCATOR.isElementPresent(), "ERROR: Page 'New Project' was not loaded!!!");
    }

    @Step("Entering name for new Project")
    public void enterNameForNewProject(String projectName){
        TextBox newProjectName = new TextBox(By.xpath(NEW_PROJECT_NAME_FIELD));
        newProjectName.moveAndClickByAction();
        newProjectName.sendKeys(projectName);
    }

    @Step("Clicking on 'Add Project' button")
    public void clickOnAddProjectButton(){
        Button addProjectButton = new Button(By.xpath(ADD_NEW_PROJECT_BUTTON));
        addProjectButton.moveAndClickByAction();
    }

    @Step("Checking 'Success' message")
    public void checkSuccessNotification(){
        Assert.assertEquals(new Button(By.xpath(SUCCESS_PROJECT_NOTIFICATION)).getText(), expectedSuccessMessage);
        System.out.println(new Button(By.xpath(SUCCESS_PROJECT_NOTIFICATION)).getText());
    }

    @Step("Checking that new project displayed in the grid")
    public void checkProjectInGrid(String projectName){
        Assert.assertTrue(new Label(By.xpath(String.format(PROJECT_IN_THE_GRID, projectName))).isElementPresent(), "Error: 'Project' was not created");
    }

    @Step("Clicking on delete button for Project")
    public void clickOnDeleteProjectButton(String projectName){
        Button deleteProjectButton = new Button(By.xpath(String.format(DELETE_PROJECT_BUTTON, projectName)));
        deleteProjectButton.moveAndClickByAction();
    }

    @Step("Set conformation flag and deleting the project")
    public void setFlagAndDeleteProject(){
        CheckBox conformattionCheckbox = new CheckBox(By.xpath(DELETE_CONFORMATION_FLAG));
        conformattionCheckbox.moveAndClickByAction();

        Button conformationOKButton = new Button(By.xpath(DELETE_CONFORMATION_BUTTON));
        conformationOKButton.moveToElement();
        conformationOKButton.clickAndWait();
    }
}
