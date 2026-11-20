@tag
Feature: Purchcase the order from e-commerce Website 

Background:
	Given I landed on Ecommerce page 
	
	@tag2
	Scenario Outline: Postitive test of Purchasing Order
		Given  Logged in with username <name> and password <password>
		When  I add product <productname> from cart
		And Checkout <productName> and sumbit order
		Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation page
		
		
		Examples:
		|name 				| password 				| productName   	|
		|Abcdxyz@gmail.com	|Abcd@123				| ZARA COAT 3		|
		
