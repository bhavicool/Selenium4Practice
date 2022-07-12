import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		//Here we are creating driver reference of WebDriver interface and pointing to ChromeDriver object
		//WebDriver driver=new ChromeDriver();
		
		//Here we are creating driver reference of ChromeDriver class and pointing to ChromeDriver object
		ChromeDriver driver=new ChromeDriver();
		
		// Steps to setup FF browser
		/*WebDriverManager.firefoxdriver().setup();

		// Step to launch FF browser
		WebDriver driver = new FirefoxDriver();*/

		/*// Steps to setup Edge browser
		WebDriverManager.edgedriver().setup();

		// Step to launch Edge browser
		WebDriver driver = new EdgeDriver();*/

		// Step to navigate to the application url
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		// Step to maximize browser window
		driver.manage().window().maximize();

		// Finding username textbox and entering value
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("Admin");

		// Finding password textbox and entering value
		WebElement password = driver.findElement(By.cssSelector("input#txtPassword"));
		password.sendKeys("admin123");

		// Finding signIn and clicking
		WebElement signIn = driver.findElement(By.xpath("//input[@value='LOGIN']"));
		signIn.click();

		// Finding and displaying homepage user
		String userNameText = driver.findElement(By.id("welcome")).getText();
		System.out.println("User on home page is:" + userNameText);

		// Finding Assign Leave if it is displayed or not
		boolean isAssignLeavePresent = driver.findElement(By.xpath("//span[text()='Assign Leave']")).isDisplayed();
		System.out.println("is Assign Leave Check is:" + isAssignLeavePresent);
		
		//Code for displaying all the elements under Quick Launch section
		List<WebElement> quickLaunchList=driver.findElements(By.xpath("//div[@id='dashboard-quick-launch-panel-menu_holder']/descendant::span"));
		for(WebElement e:quickLaunchList)
		{
			System.out.println("Element is: "+e.getText());
		}
		//Hovering in selenium
		driver.findElement(By.id("menu_maintenance_purgeEmployee")).click();
		
		//Purge Records
		WebElement purgeRecords=driver.findElement(By.id("menu_maintenance_PurgeRecords"));
		
		//Advanced User Interactions
		Actions actions=new Actions(driver);
		
		//Performing mouse hover
		actions.moveToElement(purgeRecords).perform();
		
		//Finding sub-menu element
		WebElement candidateRecords=driver.findElement(By.id("menu_maintenance_purgeCandidateData"));
		
		//Performing mouse hover on sub-menu
		actions.moveToElement(candidateRecords).perform();
		
		//Clicking sub menu
		actions.click().build().perform();
		
		Thread.sleep(3000);

		// Step to close browser
		driver.quit();

	}

}
