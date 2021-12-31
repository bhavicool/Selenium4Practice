import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartWSeleniumGrid {

	
	static DesiredCapabilities caps = new DesiredCapabilities();
	static WebDriver driver ;
    
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		String Node = "http://localhost:4444";
		caps.setBrowserName("chrome");
		WebDriverManager.chromedriver().setup();

		//Pointing to Hub which is working on a local system
		driver = new RemoteWebDriver(new URL(Node), caps);

		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		String handle=driver.getWindowHandle();
		driver.switchTo().window(handle);
		driver.findElement(By.xpath("//button[text()='✕']"))
		  .click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		//hovering electronics and clicking any item
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[text()='Electronics']"))).perform();
		
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Cameras & Accessories']"))).perform();
		
		driver.findElement(By.xpath("//a[text()='Point & Shoot']")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
