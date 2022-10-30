import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartNetworkTraffic {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
		caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

		@SuppressWarnings("deprecation")
		WebDriver driver = new ChromeDriver(caps);

		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();
		List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		System.out.println(entries.size() + " " + LogType.PERFORMANCE + " log entries found");
		for (LogEntry entry : entries) {
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
		}

		driver.quit();
	}
}