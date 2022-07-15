package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

	public WebElement welcomeUser(WebDriver driver) {
		return driver.findElement(By.id("welcome"));
	}

	public List<WebElement> quickLaunchList(WebDriver driver) {
		return driver.findElements(By.xpath("//div[@id='dashboard-quick-launch-panel-menu_holder']/descendant::span"));
	}

	public WebElement maintenanceTab(WebDriver driver) {
		return driver.findElement(By.id("menu_maintenance_purgeEmployee"));
	}

	public void dashboardFlow(WebDriver driver) {
		String welcomeMsg = welcomeUser(driver).getText();
		System.out.println("Welcome Msg is: " + welcomeMsg);
		for (WebElement e : quickLaunchList(driver)) {
			System.out.println("Element is: " + e.getText());
		}
		maintenanceTab(driver).click();
	}
}
