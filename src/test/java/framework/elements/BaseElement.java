package framework.elements;

import framework.Browser;
import framework.PropertyReader;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Log4j2
public abstract class BaseElement {
    protected WebElement element;
    protected List<WebElement> elements;
    protected PropertyReader logPropertyReader = new PropertyReader("log.properties");
    private By by;
    private String name;
    private WebDriverWait wait;

    public BaseElement(By by){
        this.by = by;
    }

    public void click(){
        isElementPresent();
        log.info(logPropertyReader.getProperty("element.click") + " - " + getElementType() + ": " + by);
        element.click();
    }

    public void clear(){
        isElementPresent();
        log.info(logPropertyReader.getProperty("element.clear") + " - " + getElementType() + ": " + by);
        element.clear();
    }

    public void clickAndWait(){
        click();
        log.info(logPropertyReader.getProperty("element.click") + " - " + getElementType() + ": " + by);
        Browser.waitForPageToLoad();
    }

    public BaseElement(By by, String name){
        this.by = by;
        this.name = name;
    }

    public WebElement getElement(){
        isElementPresent();
        return element;
    }

    public boolean isElementPresent(){
        try{
            Browser.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(Browser.getTimeoutForCondition()), TimeUnit.SECONDS);
            element = Browser.getDriver().findElement(by);
            log.info(getElementType() + ": " + by + " - is present");
            return element.isDisplayed();
        } catch (NoSuchElementException e){
            log.info(getElement() + ": " + by + " - is present. Exception - NoSuchElementException");
        } catch (Exception e){
            log.info("Exception: " + e);
        }
        return false;
    }

    public boolean areElementsPresent(int timeout){
        wait = (WebDriverWait) new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(timeout));
        Browser.getDriver().manage().timeouts().implicitlyWait(Integer.valueOf(Browser.getTimeoutForCondition()), TimeUnit.SECONDS);
        try{
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
                public Boolean apply(final WebDriver driver){
                    try{
                        elements = driver.findElements(by);
                        for (WebElement element : elements) {
                            if (element instanceof WebElement && element.isDisplayed()){
                                element = (WebElement) element;
                                return element.isDisplayed();
                            }
                        }
                        element = (WebElement) driver.findElement(by);
                    } catch (Exception e){
                        return false;
                    }
                    return element.isDisplayed();
                }
            });
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    protected abstract String getElementType();

    public void clickViaJS() {
        isElementPresent();
        log.info(logPropertyReader.getProperty("element.click") + " - " + getElementType() + ": " + by);
        if (Browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].style.border='3px solid blue'", element);
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].click();", element);
        }
    }

    public void moveToElement(){
        isElementPresent();
        log.info(logPropertyReader.getProperty("element.move") + " - " + getElementType() + ": " + by);
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).perform();
    }

    public void moveAndClickByAction(){
        isElementPresent();
        log.info(logPropertyReader.getProperty("element.move") + " - " + getElementType() + " and "
                + logPropertyReader.getProperty("element.click") + " - " + getElementType() + ": " + by);
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).click().perform();
    }

    public void sendKeys(String sendKeys) {
        isElementPresent();
        getElement().sendKeys(sendKeys);
        log.info("Send keys: " + element.getAttribute("value") + " to " + getElementType());
    }

    public void scrollToElementViaJS(){
        isElementPresent();
        log.info(logPropertyReader.getProperty("element.scroll") + " - " + getElementType() + ": " + by);
        if (Browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        }
    }

    public String getText(){
        isElementPresent();
        log.info(logPropertyReader.getProperty("element.text") + " - " + element.getText());
        return element.getText();
    }

    public boolean isDisplayed(){
        isElementPresent();
        log.info(getElementType() + ": " + by + " is displayed: " + element.isDisplayed());
        return element.isDisplayed();
    }

    public boolean isSelected(){
        isElementPresent();
        log.info(getElementType() + ": " + by + " is selected: " + element.isSelected());
        return element.isSelected();
    }

}
