import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaukriMultipleWindowsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();

		driver.get("https://www.naukri.com/");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String parentWindow=driver.getWindowHandle();
		
		//Here getWindowHandles will return 3 windows(parent window and 2 child windows)
		Set<String> windowHandles=driver.getWindowHandles();
		for(String s:windowHandles)
		{
			if(s.equals(parentWindow))
			{
				System.out.println("Parent Window is:"+s);
			}
			else
			{
				//Switching to child window and performing some action
				driver.switchTo().window(s);
				driver.close();
			}
			
		}
		//Switching back to main window
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//div[@class='middleSection']/descendant::ul[@class='bannerList']/li[1]/a"))
		.click();
		Thread.sleep(2000);
		
		//Here getWindowHandles will return 2 windows(parent window and 1 child window)
		Set<String> windowHandlesNew=driver.getWindowHandles();
		for(String s:windowHandlesNew)
		{
			if(s.equals(parentWindow))
			{
				System.out.println("Parent Window is:"+s);
			}
			else
			{
				//Switching to child window and performing some action
				driver.switchTo().window(s);
				List<WebElement> elements=driver.findElements(By.xpath("//h3[text()='Jobs by Location']/parent::div/descendant::a/span"));
				for(WebElement e:elements) {
					System.out.println("Elements are:"+e.getText());
				}
				driver.close();
			}
			
		}
		//Switching back to main window and performing some action
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='middleSection']/descendant::ul[@class='bannerList']/li[1]/a"))
		.click();
		Thread.sleep(2000);
		driver.quit();
	}

}
