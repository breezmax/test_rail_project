package testrail.pageObjects.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.CheckBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DeleteDialogPage extends BasePage {

    private  static final By pageLocator = By.xpath("//span[@id='ui-dialog-title-deleteDialog']");
    private static final String DELETE_CONFORMATION_FLAG = "//span[@class='dialog-confirm']/strong[contains(text(),'Yes, delete')]";
    private static final String DELETE_CONFORMATION_BUTTON = "//div[@id='deleteDialog']//a[@class='button button-ok button-left button-positive dialog-action-default' and contains(text(),'OK')]";

    public DeleteDialogPage() {
        super(pageLocator, "'Delete Dialog' Page");
    }

    @Step("Set conformation flag and deleting the item")
    public void setFlagAndDeleteItem(){
        CheckBox conformattionCheckbox = new CheckBox(By.xpath(DELETE_CONFORMATION_FLAG));
        conformattionCheckbox.moveToElement();
        conformattionCheckbox.click();

        Button conformationOKButton = new Button(By.xpath(DELETE_CONFORMATION_BUTTON));
        conformationOKButton.moveToElement();
        conformationOKButton.clickAndWait();
    }

    @Step("Deleting the item")
    public void deleteItem(){
        Button conformationOKButton = new Button(By.xpath(DELETE_CONFORMATION_BUTTON));
        conformationOKButton.moveToElement();
        conformationOKButton.clickAndWait();
    }

}
