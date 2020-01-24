package Selenium.Docker;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Setup {
	public WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void LaunchBroeser(String browser) throws MalformedURLException
	{
		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox");
			//String Node = "http://localhost:4446/wd/hub";
			FirefoxOptions cap = new FirefoxOptions();
			cap.setCapability("Browser", "FF");
			cap.setCapability("docker", "Container");
			driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


			driver.navigate().to("https://www.google.com");
			driver.manage().window().maximize();
		} 
		else
			if (browser.equalsIgnoreCase("chrome")) {
				System.out.println(" Executing on CHROME");
				ChromeOptions cap = new ChromeOptions();
				cap.setCapability("Browser", "Chrome");
				cap.setCapability("docker", "container");
				driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), cap);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				driver.navigate().to("https://www.google.com");
				driver.manage().window().maximize();
			}
			else
			{
				throw new IllegalArgumentException("The Browser Type is Undefined");
			}
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
