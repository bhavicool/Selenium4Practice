import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Step to navigate to the application url
		driver.get("https://www.facebook.com/");

		// Step to maximize browser window
		driver.manage().window().maximize();

		// Finding username textbox and entering value
		WebElement createNewAccount = driver.findElement(By.xpath("//a[text()='Create New Account']"));
		createNewAccount.click();
		
		Thread.sleep(2000);
		
		Select dayElement=new Select(driver.findElement(By.id("day")));
		dayElement.selectByValue("1");
		
		Select monthElement=new Select(driver.findElement(By.name("birthday_month")));
		monthElement.selectByVisibleText("Apr");
		
		Select yearElement=new Select(driver.findElement(By.id("year")));
		yearElement.selectByIndex(3);
		
		//Select gender as male
		driver.findElement(By.xpath("//input[@value='2']")).click();
		
		Thread.sleep(4000);
		
		driver.close();
	}
}
