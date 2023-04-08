package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;

public class LandingPageStepDefinitions {

	public WebDriver driver;
	public String OfferPageProductName;
	public String LandingPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;

	
	public LandingPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup  = testContextSetup;
		this.landingPage =testContextSetup.pageObjectManager.getLandingPage();

	}
	
@Given("User is on GreenCart landing page")
public void user_is_on_green_cart_landing_page() {
 
	Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

	
}

@When("^user search with shortName (.+) and extract the actual name of product$")
public void user_search_with_short_name_and_extract_the_actual_name_of_product(String shortName) throws InterruptedException {

	//LandingPage landingPage = new LandingPage(testContextSetup.driver);
	//LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
	landingPage.searchItem(shortName);
	
		
	//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	Thread.sleep(1500);
	//testContextSetup.LandingPageProductName =testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	testContextSetup.LandingPageProductName =landingPage.getProductName().split("-")[0].trim();
	
	System.out.println(LandingPageProductName +"is extracted from HomePage");

}

@When("Added {string} items of the selected product to cart")
public void Added_items_of_the_selected_product_to_cart(String quality)
{
   landingPage.incrementQuality(Integer.parseInt(quality));	
   landingPage.addToCart();
}





}
