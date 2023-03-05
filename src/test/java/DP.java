import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP {

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"First_Value", "secret_sauce"},
                {"Second-Value", "secret_sauce"},
                {"Third-Value", "secret_sauce"},
                {"", "secret_sauce"}
        };
    }

    @Test(dataProvider = "data-provider")
    public void myTest (String val) {
        System.out.println("Passed Parameter Is : " + val);
    }
}
