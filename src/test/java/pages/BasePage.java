package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.BaseUtils;

public abstract class BasePage extends BaseUtils {

    protected BaseUtils baseUtils;
    protected Logger logger;

    //Header Section

    @FindBy(css = ".header__logo img")
    private WebElement mainPageLogoCss;

    @FindBy(xpath = "//span[@class='header-topline__user-label']/following::a[1]")
    private WebElement enterLoginLinkXpath;

    @FindBy(xpath = "//auth-modal//a[@class='auth-modal__register-link']")
    private WebElement registerButtonXpath;

    @FindBy(id = "auth_email")
    private WebElement inputLoginId;

    @FindBy(id = "auth_pass")
    private WebElement inputPasswordId;

    @FindBy(xpath = "//auth-modal//button[contains(@class, 'login')]")
    private WebElement loginButtonXpath;

    @FindBy(xpath = "//auth-modal//a[contains(@class, 'cancel-link')]")
    private WebElement cancelButtonXpath;


    public BasePage(BaseUtils baseUtils) {
        this.baseUtils = baseUtils;
        PageFactory.initElements(baseUtils.driver, this);
        logger = Logger.getLogger(this.getClass());
    }

    public void openMainPage(){
        logger.debug("navigate to the main page");
        baseUtils.driver.navigate().to("https://rozetka.com.ua");
        logger.debug("I am on main page");
    }

    //Header section

    public void assertLogoVisible(){
        Assert.assertEquals( true, baseUtils.webDriverWait.until(ExpectedConditions.visibilityOf(mainPageLogoCss)).isDisplayed());
    }

    public void openLoginRegisterPopUp(){
        baseUtils.webDriverWait.until(ExpectedConditions.visibilityOf(enterLoginLinkXpath)).click();
        Assert.assertEquals( true, baseUtils.webDriverWait.until(ExpectedConditions.visibilityOf(registerButtonXpath)).isDisplayed(), "Register is not present");
        logger.debug("I open login menu");
    }

    public void inputLoginAndPassword(String login, String password){
        logger.debug(String.format("I type a user name: '%1s' and password: '%2s'", login, password));
        baseUtils.webDriverWait.until(ExpectedConditions.visibilityOf(inputLoginId)).sendKeys(login);
        baseUtils.webDriverWait.until(ExpectedConditions.visibilityOf(inputPasswordId)).sendKeys(password);
    }

    public void clickLoginButton(){
        baseUtils.webDriverWait.until(ExpectedConditions.visibilityOf(loginButtonXpath)).click();
        logger.debug("I click login button");
    }


}
