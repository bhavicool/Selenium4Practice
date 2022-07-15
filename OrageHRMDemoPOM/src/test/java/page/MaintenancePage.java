package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MaintenancePage {

	public WebElement purgeRecords(WebDriver driver) {
		return driver.findElement(By.id("menu_maintenance_PurgeRecords"));
	}
	
	public WebElement purgeCandidate(WebDriver driver) {
		return driver.findElement(By.id("menu_maintenance_purgeCandidateData"));
	}
	
	public void maintenanceFlow(WebDriver driver) {
		
		Actions actions=new Actions(driver);
		
		//Performing mouse hover
		actions.moveToElement(purgeRecords(driver)).perform();
		
		//Performing mouse hover on sub-menu
		actions.moveToElement(purgeCandidate(driver)).perform();
		
		//Clicking sub menu
		actions.click().build().perform();
	}
}
