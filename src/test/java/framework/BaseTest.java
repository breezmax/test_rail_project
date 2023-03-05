package framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners(TestListener.class)
public class BaseTest {

        public static Browser driver = new Browser();

        @BeforeMethod
        public void setup() {
          driver.getInstance();
          driver.windowMaximize();
          driver.get(PropertyReader.getProperty("base.URL"));
        }

        @AfterMethod(alwaysRun = true, description = "Closing browser anyway")
        public void tearDown() {
            driver.exit();
        }

}

