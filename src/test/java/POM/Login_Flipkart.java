package POM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebDriver.WebDriverClass;

public class Login_Flipkart {
	WebDriver driver;
	String FlipkartPrice;
	List <WebElement> El;
	List <WebElement> El1;
	String Flp;
	
	public Login_Flipkart(WebDriver driver) {
		this.driver = WebDriverClass.Driver();
	}
	
	By Search = By.xpath("//input[@class='Pke_EE']");
	By SearchList = By.xpath("//span[@class='_1CzsRN']");
	By SearchedList = By.xpath("//div[@class='KzDlHZ']");
	By Price = By.xpath("//div[@class='Nx9bqj CxhGGd']");
	
	public void Navigation_to_flipkart() {
		((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		driver.get("http://www.flipkart.com");
		
		
		//***Maximizing the screen***
		driver.manage().window().maximize();
		//***implicit wait***
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	}
	
	public void ProductName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@class='Pke_EE']")));
		driver.findElement(Search).click();
		Thread.sleep(10000);
		driver.findElement(Search).sendKeys("motorola g35");
	}
	
	public void Retreving_Products_From_SearcSuggestions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchList));
		El = driver.findElements(SearchList);
		//***Printing the size of the list***
		System.out.println("Suggestion's from the dropdown in Flipkart : "+El.size());
		System.out.println(" ");
		System.out.println("List of Suggestions :");
		//***Code to select respective device name from the search suggestions***
		for(int i=0;i<El.size();i++)
		{
			System.out.println(El.get(i).getAttribute("textContent"));
			
		}
	}
	
	public void Selecting_a_Product_from_SuggestionList() {
		
		for(int i=0;i<El.size();i++)
		{
			
			if(El.get(i).getText().contains("motorola g35"))
			{
				El.get(i).click();
				break;
			}
		}
		
	}
	
	public void Retreving_SearchResults() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		El1 = driver.findElements(SearchedList);
		System.out.println(" ");
		//***printing the size of the Available Devices list***
		System.out.println("Phones available in Flipkart : "+El1.size());
		System.out.println(" ");
		System.out.println("List of Phones in Flipkart : ");
		
		//***Code to Select respective device from the list***
		for(int j=0;j<El1.size();j++)
		{
			
			System.out.println(El1.get(j).getText());
		}
	}
	public void Selecting_Product() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		for(int j=0;j<El1.size();j++)
		{
			if(El1.get(j).getText().contains("Motorola G35 5G (Leaf Green"))
			{
				El1.get(j).click();
				System.out.println(" ");
				FlipkartPrice = El1.get(j).getText();
				System.out.println("Selected Mobile : "+El1.get(j).getText());
				break;
			}
		}
	}
	
	public String Product_Price() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		ArrayList<String> newTb1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb1.get(3));
		System.out.println(newTb1.size());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Price));
		Flp = driver.findElement(Price).getText();
		System.out.println(" ");
        System.out.println("Price of the Phone in Flipkart is : "+Flp);
        System.out.println(" ");
        return Flp;
        
	}
}
