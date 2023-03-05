package testrail.pageObjects.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.DropDown;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    private  static final By pageLocator = By.xpath("//div[@class='top-section text-ppp'][contains(text(),'TestRail QA')]");
    private static final String ADD_NEW_PROJECT = "//a[@id='sidebar-projects-add']";
    private static final String PROJECT_NAME = "//a[contains(text(),'%s')]";

    public DashboardPage() {
        super(pageLocator, "'Dashboard' Page");
        assertIsOpened();
    }


    @Step("Clicking to 'Add Project' button")
    public void addNewProject(){
        Button newProjectButton = new Button(By.xpath(ADD_NEW_PROJECT));
        newProjectButton.clickAndWait();
    }

    @Step("Opening Project")
    public void openProject(String projectName){
        Label projectLabel = new Label(By.xpath(String.format(PROJECT_NAME, projectName)));
        projectLabel.moveToElement();
        projectLabel.clickAndWait();
    }
}
