import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.target.model.SessionID;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FlipkartTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

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
		File srcFile = driver.findElement(By.xpath("//div[text()='Mobiles']"))
				.getScreenshotAs(OutputType.FILE);
		File dstFile = new File("Image.png");
		FileUtils.copyFile(srcFile,dstFile);
		
		//hovering electronics and clicking any item
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[text()='Electronics']"))).perform();
		
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Cameras & Accessories']"))).perform();
		
		driver.findElement(By.xpath("//a[text()='Point & Shoot']")).click();
		
		Thread.sleep(3000);
		//SessionId before quit
		
		SessionId sessionId=((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session Id before close is:"+sessionId);
		driver.quit();
		
		//SessionId after quit
		SessionId sessionId1=((RemoteWebDriver) driver).getSessionId();
		System.out.println("Session Id after after is:"+sessionId1);
		
		}

}
