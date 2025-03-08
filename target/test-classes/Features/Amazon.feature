Feature: Retreving a Product price in Amazon
	@Amazon
  Scenario: Searching a product in Amazon
    Given User navigated to Amazon.in
    And Inputed the device name
    When reading the list of devices in search suggestions
    Then Select a product from list.
  @Amazon1  
  Scenario: Selecting product from search results
    Given comparing the product name with users input.
    And Selecting the product.
    Then Retreving the product price.