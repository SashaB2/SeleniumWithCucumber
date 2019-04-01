package steps;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.MainPage;
import transformation.EmailTransform;
import utils.BaseUtils;

import java.util.List;


public class MainSteps extends BaseUtils{

    private BaseUtils baseUtils;
    private MainPage mainPage;

    public MainSteps(BaseUtils baseUtils) {
        this.baseUtils = baseUtils;
        mainPage = new MainPage(baseUtils);
    }

    @Given("^I am on main page$")
    public void iAmOnMainPage() throws Throwable {
        mainPage.openMainPage();
    }

    @And("^Validate rozetka logo$")
    public void validateRozetkaLogo(){
        mainPage.assertLogoVisible();
    }

    @When("^I open login menu$")
    public void iOpenLoginMenu() {
        mainPage.openLoginRegisterPopUp();
    }

    @When("^I click login button$")
    public void iClickLoginButton() {
        mainPage.clickLoginButton();
    }

    @And("^I type \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iTypeAnd(String userName, String password) {
        mainPage.inputLoginAndPassword(userName, password);
    }

    @And("^I type the following for login$")
    public void iTypeTheFollowingForLogin(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        mainPage.inputLoginAndPassword(data.get(1).get(0), data.get(1).get(2));
    }

    @And("^I enter ([^\"]*) and ([^\"]*) on login page$")
    public void iEnterUserNameAndPasswordOnLoginPage(String userName, String password) throws Throwable {
        mainPage.inputLoginAndPassword(userName, password);

    }

    @When("^I input Email:([^\"]*)$")
    public void iSearchItemNote(@Transform(EmailTransform.class) String email) throws Throwable {
        mainPage.inputLoginAndPassword(email, "password");
    }

    @When("^I type the following$")
    public void i_Type_The_Following(DataTable dataTable) throws Throwable {
        List<User> users = dataTable.asList(User.class);
        for (User user : users) {
            mainPage.inputLoginAndPassword(user.name, user.password);
        }
    }

    public class User {
        private String name = null;
        private String password = null;

        public User(String name, String password) {
            this.name = name;
            this.password = password;

        }
    }

}


