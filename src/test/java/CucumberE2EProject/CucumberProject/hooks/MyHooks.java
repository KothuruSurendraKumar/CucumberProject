package CucumberE2EProject.CucumberProject.hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import CucumberE2EProject.CucumberProject.driverFactory.DriverFactory;
import CucumberE2EProject.CucumberProject.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {

	public WebDriver driver;

	@Before
	public void setup() throws IOException {
		Properties prop = new ConfigReader().intilizeProperties();
		driver = DriverFactory.intilizeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));

	}

	@After
	public void tearDown(Scenario scenario) {
		String scenarioName = scenario.getName().replaceAll(" ", "_");

		if (scenario.isFailed()) {
			byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screen, "image/png", scenarioName);
		}

		driver.quit();
	}

}
