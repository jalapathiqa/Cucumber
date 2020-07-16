Feature: Customers

Background: Below are the common steps for each scenario
	Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click in Login
	Then User can view Dashboard

@addCustomer
Scenario: Add a new Customer
	
	When User click on Customers Menu
	And Click on customers Menu Item
	And Click on Add new Button
	Then User can view Add new customer Page
	When User enter Customer info
	And Click on Save button
	Then User can view confirmaton message "The new customer has been added successfully."
		And close browser
	
@searchCustomer
Scenario: Search Customer by EmailId
	
	When User click on Customers Menu
	And Click on customers Menu Item
	And Enter Customer Email
	When Click on search button
	Then User should found Email in the Search table
		And close browser
	