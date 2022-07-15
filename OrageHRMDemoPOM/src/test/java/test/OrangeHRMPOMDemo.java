package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.DashboardPage;
import page.HomePage;
import page.MaintenancePage;

public class OrangeHRMPOMDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Step to navigate to the application url
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		// Step to maximize browser window
		driver.manage().window().maximize();
		
		HomePage homePage=new HomePage();
		homePage.loginFunctionality(driver);
		
		DashboardPage dashboardPage=new DashboardPage();
		dashboardPage.dashboardFlow(driver);
		
		MaintenancePage maintenancePage=new MaintenancePage();
		maintenancePage.maintenanceFlow(driver);
		
		Thread.sleep(3000);
		driver.close();
	}

}
