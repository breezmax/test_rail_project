package testrail.pageObjects.pages;

import framework.BasePage;
import framework.elements.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ExistingProjectPage extends BasePage {

    private static final By pageLocator = By.xpath("//a[@id='navigation-project']");
    private static final String NAVIGATE_TAB = "//li/a[contains(text(),'%s')]";
    private static final String TEST_CASE_SIDEBAR_BUTTON = "//a[@id='sidebar-cases-add']";
    private static final String ADD_MILESTONE_SIDEBAR_BUTTON = "//a[@id='navigation-milestones-add']";

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

}
