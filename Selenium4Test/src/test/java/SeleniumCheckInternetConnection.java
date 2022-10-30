import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCheckInternetConnection {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String errorText = "";
		try {
			driver.get("https://www.flipkart.com/");
		} catch (Exception e) {
			System.out.println("Exception is: " + e.getMessage());
			WebElement error = driver.findElement(By.className("error-code"));
			errorText = error.getText();
		} finally {
			if (!errorText.isEmpty() && (errorText.equals("DNS_PROBE_FINISHED_NO_INTERNET")
					|| errorText.equals("ERR_NAME_NOT_RESOLVED"))) {
				System.out.println("No Internet Connection");
			} else {
				System.out.println("Internet Connected");
			}
			driver.quit();
		}
	}

}
