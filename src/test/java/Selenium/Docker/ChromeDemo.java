package Selenium.Docker;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
public class ChromeDemo extends Setup 
{
	@Test
	public void testApp() throws MalformedURLException, InterruptedException
	{		
		driver.findElement(By.name("q")).sendKeys("Learn Automation");
		Thread.sleep(5000);
	}	
}
