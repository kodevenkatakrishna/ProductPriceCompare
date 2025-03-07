package StepDefinations;

import org.openqa.selenium.WebDriver;

import POM.Login_Amazon;
import POM.Login_Flipkart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Amazon_Steps {
	WebDriver driver;
	Login_Amazon Amazon = new Login_Amazon(driver);
	
	@Given("User navigated to Amazon.in")
	public void user_navigated_to_amazon_in() {
	    Amazon.NavigationToAmazon();
	}

	@And("Inputed the device name")
	public void inputed_the_device_name() {
	    Amazon.ProductName();
	}

	@When("reading the list of devices in search suggestions")
	public void reading_the_list_of_devices_in_search_suggestions() throws InterruptedException {
	    Amazon.Retreving_From_SearcSuggestions();	   
	}

	@Then("Select a product from list.")
	public void select_a_product_from_list() {
		Amazon.Selecting_a_Product_from_SuggestionList();
	}

	@Given("comparing the product name with users input.")
	public void comparing_the_product_name_with_users_input() {
	   Amazon.Retreving_SearchResults();
	}

	@Given("Selecting the product.")
	public void selecting_the_product() {
	   Amazon.Selecting_product_from_searchResults();
	}

	@Then("Retreving the product price.")
	public void retreving_the_product_price() {
	    Amazon.Retreving_Product_Price();
	}

}
