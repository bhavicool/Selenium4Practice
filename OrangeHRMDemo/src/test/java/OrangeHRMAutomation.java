import org.openqa.selenium.WebDriver;
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
		
		//Step to close browser
		driver.quit();
		
	}

}
