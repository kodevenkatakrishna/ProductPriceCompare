package StepDefinations;

import org.openqa.selenium.WebDriver;

import POM.Login_Flipkart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class Flipkart_Steps {
	WebDriver driver;
	Login_Flipkart Flipkart = new Login_Flipkart(driver);
	@Given("User navigated to Flipkart.com")
	public void user_navigated_to_flipkart_com() {
	    Flipkart.Navigation_to_flipkart();
	}

	@And("Inputed the device name in flipkart")
	public void inputed_the_device_name_in_flipkart() throws InterruptedException {
	    Flipkart.ProductName();
	}

	@When("reading the list of devices in search suggestions in flipkart")
	public void reading_the_list_of_devices_in_search_suggestions_in_flipkart() {
	    Flipkart.Retreving_Products_From_SearcSuggestions();
	}

	@Then("Select a product from list in flipkart.")
	public void select_a_product_from_list_in_flipkart() {
	    Flipkart.Selecting_a_Product_from_SuggestionList();
	}
	
	@Given("comparing the product name with users input in flipkart.")
	public void comparing_the_product_name_with_users_input_in_flipkart() {
	    Flipkart.Retreving_SearchResults();
	}

	@And("Selecting the product in flipkart.")
	public void selecting_the_product_in_flipkart() {
	    Flipkart.Selecting_Product();
	}

	@Then("Retreving the product price in flipkart.")
	public void retreving_the_product_price_in_flipkart(){
	    Flipkart.Product_Price();
	}
	
}
