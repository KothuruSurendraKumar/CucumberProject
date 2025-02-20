package CucumberE2EProject.CucumberProject.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/features",glue={"CucumberE2EProject.CucumberProject.stepImpl","CucumberE2EProject.CucumberProject.hooks"},
monochrome=true,publish=true,plugin = {"pretty", "html:target/cucumber-reports.html","json:target/cucumber.json"},tags="@Register")

public class TestRunner extends AbstractTestNGCucumberTests{

}
