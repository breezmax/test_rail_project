package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;



public class Browser {
    private static final String DEFAULT_PAGE_LOAD_TIMEOUT = "timeout.for.page.load";
    private static final String DEFAULT_CONDITION_TIMEOUT = "timeout.for.element";
    static final String PROPERTIES_FILE = "config.properties";
    private static Browser instance;
    private static WebDriver driver;

    private static String getTimeoutForPageLoad;
    private static String getTimeoutForCondition;

    public static PropertyReader props;

    public Browser getInstance(){
        if (instance == null){
            initProperties();
            try {
                driver = DriverFactory.getDriver();
                driver.manage().timeouts().implicitlyWait(PropertyReader.getIntProperty("timeout.for.page.load"), TimeUnit.SECONDS);
            } catch (Exception e){
                Assert.fail("Driver does not instance");
            }
            instance = new Browser();
        }
        return instance;
    }

    public static void waitForPageToLoad(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(getTimeoutForPageLoad())));
        try {
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver d) {
                    if (!(d instanceof JavascriptExecutor)) {
                        return true;
                    }
                    Object result = ((JavascriptExecutor) d)
                            .executeScript("return document['readyState'] ? 'complete' === document.readyState : true");
                    return result instanceof Boolean && (Boolean) result;
                }
            });
        } catch (Exception e) {
            Assert.fail("Page does not Load" + e);
        }
    }



    public void windowMaximize(){
        driver.manage().window().maximize();
    }

    public void get(String url){
        driver.get(url);
    }

    public void exit(){
        if (instance !=null){
            driver.quit();
        }
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public  static String getTimeoutForCondition(){
        return getTimeoutForCondition;
    }

    public  static String getTimeoutForPageLoad(){
        return getTimeoutForPageLoad;
    }

    private static void initProperties(){
        props = new PropertyReader(PROPERTIES_FILE);
        getTimeoutForPageLoad = props.getProperty(DEFAULT_PAGE_LOAD_TIMEOUT);
        getTimeoutForCondition = props.getProperty(DEFAULT_CONDITION_TIMEOUT);
    }

}
