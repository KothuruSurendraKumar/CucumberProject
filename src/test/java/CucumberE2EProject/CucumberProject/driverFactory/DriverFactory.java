package CucumberE2EProject.CucumberProject.driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver;

	public static WebDriver intilizeBrowser(String browserName) {
		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			//options.addArguments("--headless");
			driver = new ChromeDriver(options);
		} else if (browserName.contains("safari")) {
			driver = new SafariDriver();
		} else if (browserName.contains("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;

	}

	public static WebDriver getDriver() {

		return driver;

	}

}
