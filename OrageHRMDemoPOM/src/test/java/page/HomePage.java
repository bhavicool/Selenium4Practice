package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebElement userName(WebDriver driver) {
		return driver.findElement(By.id("txtUsername"));
	}

	public WebElement password(WebDriver driver) {
		return driver.findElement(By.cssSelector("input#txtPassword"));
	}

	public WebElement signIn(WebDriver driver) {
		return driver.findElement(By.xpath("//input[@value='LOGIN']"));
	}

	public void loginFunctionality(WebDriver driver) {
		userName(driver).sendKeys("Admin");;
		password(driver).sendKeys("admin123");;
		signIn(driver).click();;
	}
}
