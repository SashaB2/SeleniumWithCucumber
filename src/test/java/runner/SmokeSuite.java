package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(

        glue = {"steps"},
        //for test ng use \\
        features = {"C:\\Users\\B2\\IdeaProjects\\seleniumwithcucumber\\src\\test\\resources\\Features\\Smoke.feature"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        tags = {"@SmokeTest"},
        plugin = {"json:target/cucumber.json"}
        )
public class SmokeSuite extends AbstractTestNGCucumberTests {
}
