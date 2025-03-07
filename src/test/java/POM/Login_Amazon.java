package POM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebDriver.WebDriverClass;
import dev.failsafe.Timeout;

public class Login_Amazon {
	WebDriver driver;
	String AmazonPrice;
	List<WebElement> E;
	List<WebElement> E1;
	String Amp;
	public Login_Amazon(WebDriver driver) {
		this.driver = WebDriverClass.Driver();
	}
	
	By Search = By.xpath("//input[@id='twotabsearchtextbox']");
	By SearchList = By.xpath("//div[@role='button']");
	By SearchedList = By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-component-type=\"s-search-result\"]//span[@class='a-size-medium a-color-base a-text-normal']");
	By Price = By.xpath("//span[@id='tp_price_block_total_price_ww']//span[@class='a-offscreen']");
	
	public void NavigationToAmazon() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		driver.get("http://www.amazon.in");
		
		//***Maximizing the screen***
		driver.manage().window().maximize();
		//***implicit wait***
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	//***Inputing the device name in search box***
	}
	
	public void ProductName() {
		driver.findElement(Search).sendKeys("iphone 13");
	}
	
	public void Retreving_From_SearcSuggestions() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchList));
		//***Readinging the list of search suggestions***
        E = driver.findElements(SearchList);
        System.out.println(" ");
        //***Printing the Size of list***  
        System.out.println("List of Suggestions in Amazon : "+E.size());
        System.out.println(" ");
		System.out.println("List of Phones in Amazon : ");
		for(int I=0;I<E.size();I++) {
        	String S = E.get(I).getText();
        	System.out.println(S);
        	
        }
	}
		
	public void Selecting_a_Product_from_SuggestionList() {	
        for(int I=0;I<E.size();I++) {
        	String S = E.get(I).getText();
        	if(S.contains("iphone 13 256gb"))
        	{
        		E.get(I).click();
        		break;
        	}
        }		
	}
	
	
	public void Retreving_SearchResults() {
		E1 = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[@data-component-type=\"s-search-result\"]//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println("Phones available in Amazon : "+E1.size());
        System.out.println(" ");
		System.out.println("List of Phones in Amazon : ");
		
		for(int J=0;J<E1.size();J++) {
			System.out.println(E1.get(J).getText());
			
		}
	}
	
	public void Selecting_product_from_searchResults() {	
		for(int J=0;J<E1.size();J++) {
			
			if(E1.get(J).getText().contains("Apple iPhone 13 (256GB) - Blue"))
			{
				E1.get(J).click();
				System.out.println(" ");
				AmazonPrice = E1.get(J).getText();
				System.out.println("Selected Mobile : "+E1.get(J).getText());
				break;
			}
		}
	}
	public String Retreving_Product_Price() {
		ArrayList<String> newTb1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb1.get(1));
		System.out.println(newTb1.size());
		Amp = driver.findElement(Price).getAttribute("textContent");
		System.out.println(" ");
        System.out.println("Price of the Phone in Amazon is : "+Amp);
        System.out.println(" ");
        return Amp;
	}
}
