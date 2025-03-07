package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverClass {
	public static WebDriver driver;
	public static WebDriver Driver() {
		if(driver==null) {
			driver = new ChromeDriver();
		}
		return driver;
	}
	public static void quitBrowser()
	{
		driver.quit();
	}
}
