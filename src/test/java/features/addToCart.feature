Feature: Add to cart the product
@placeOrder
Scenario: Add to cart the product expeirence in search

Given User is on GreenCart landing page
When user search with shortName <Name> and extract the actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to checkout and validate the <Name> items in checkout page



Examples:

| Name |
| Tom |











 



