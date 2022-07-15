import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		//Impicit Wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Explicit Wait
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("birthday_month")));
		
		Select dayElement=new Select(driver.findElement(By.id("day")));
		dayElement.selectByValue("1");
		
		Select monthElement=new Select(driver.findElement(By.name("birthday_month")));
		monthElement.selectByVisibleText("Apr");
		
		Select yearElement=new Select(driver.findElement(By.id("year")));
		yearElement.selectByIndex(3);
		
		//Select gender as male
		driver.findElement(By.xpath("//input[@value='2']")).click();
		
		/*//refreshing web page
		driver.navigate().refresh();
		
		//moving back on the web page
		driver.navigate().back();
		
		//moving forward on the web page
		driver.navigate().forward();*/
		
		Thread.sleep(4000);
		
		driver.close();
	}
}
