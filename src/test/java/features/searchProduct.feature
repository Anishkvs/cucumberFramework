Feature: Search the product

Scenario: Search experience for product search in both homepage and offer page

Given User is on GreenCart landing page
When user search with shortName "Tom" and extract the actual name of product
Then user search for "Tom" shortname in offer page to check if product exist with same name
And validate product name in offers page matchs with landing page. 
