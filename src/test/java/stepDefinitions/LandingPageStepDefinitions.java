package stepDefinitions;

import static org.testng.Assert.assertEquals;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;

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
	LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
	landingPage.searchItem(shortName);
	
		
	//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	Thread.sleep(1500);
	//testContextSetup.LandingPageProductName =testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	testContextSetup.LandingPageProductName =landingPage.getProductName().split("-")[0].trim();
	
	System.out.println(LandingPageProductName +"is extracted from HomePage");

}







}
