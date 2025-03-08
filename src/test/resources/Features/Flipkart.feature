Feature: Retreving a Product price in Flipkart
	@Flipkart
  Scenario: Searching a product in Flipkart
    Given User navigated to Flipkart.com
    And Inputed the device name in flipkart
    When reading the list of devices in search suggestions in flipkart
    Then Select a product from list in flipkart.
  @Flipkart1  
  Scenario: Selecting product in Flipkart from search suggestions
    Given comparing the product name with users input in flipkart.
    And Selecting the product in flipkart.
    Then Retreving the product price in flipkart.