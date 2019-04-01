package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseUtils;

//public class Hook extends BaseUtils{
public class Hook{

    private BaseUtils baseUtils;

    public Hook(BaseUtils baseUtils) {
        this.baseUtils = baseUtils;

    }

    @Before
    public void beforeStartTest(){
        System.out.println("Set up driver");
        try {
            baseUtils.driver = new ChromeDriver();
            baseUtils.driver.manage().window().maximize();
            baseUtils.webDriverWait = new WebDriverWait(baseUtils.driver, 35);
            System.out.println("Chrome driver is set up");
        }catch (Exception e){
            System.out.println("Driver can't be initialize" + e.getStackTrace());
        }
    }

    @After
    public void afterTest(){
        System.out.println("Quite driver");
        baseUtils.driver.quit();
    }
}
