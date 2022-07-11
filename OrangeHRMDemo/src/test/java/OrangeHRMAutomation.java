import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// System Property for Chrome Driver   
        /*System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");*/  
        
		//Step to download chromedriver.exe from selenium site on local and setup it's location
		WebDriverManager.chromedriver().setup();

		//Step to launch chrome browser
		WebDriver driver=new ChromeDriver();
		
		//Step to navigate to the application url
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		//Step to maximize browser window
		driver.manage().window().maximize();
		
		//Finding username textbox and entering value
		WebElement userName=driver.findElement(By.id("txtUsername"));
		userName.sendKeys("Admin");
		
		//Finding password textbox and entering value
		WebElement password=driver.findElement(By.cssSelector("input#txtPassword"));
		password.sendKeys("admin123");
		
		//Finding signIn and clicking
		WebElement signIn=driver.findElement(By.xpath("//input[@value='LOGIN']"));
		signIn.click();
		
		//Finding and displaying homepage user
		String userNameText=driver.findElement(By.id("welcome")).getText();
		System.out.println("User on home page is:"+userNameText);
		
		//Finding Assign Leave if it is displayed or not
		boolean isAssignLeavePresent=driver.findElement(By.xpath("//span[text()='Assign Leave']")).isDisplayed();
		System.out.println("is Assign Leave Check is:"+isAssignLeavePresent);
		
		Thread.sleep(3000);
		
		//Step to close browser
		driver.quit();
		
	}

}
