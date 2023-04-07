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
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;

public class OfferPageStepDefinitions {

	public WebDriver driver;
	public String LandingPageProductName;
	public String OfferPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}


@Then("user search for {string} shortname in offer page to check if product exist with same name")
public void user_search_the_same_shortname_in_offer_page_to_check_if_product_exist(String shortName) throws InterruptedException {
   
	switchToOfferPage();
	//OffersPage OffersPage = new OffersPage(testContextSetup.driver);
	OffersPage OffersPage = testContextSetup.pageObjectManager.getOffersPage();

	OffersPage.searchItem(shortName);
	//testContextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
	Thread.sleep(2000);
	//OfferPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	
	OfferPageProductName = OffersPage.getProductName();
	System.out.println(OfferPageProductName);
	 
}

    public void switchToOfferPage() {
    	if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"));
    	//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
    	OffersPage OffersPage = new OffersPage(testContextSetup.driver);
    	OffersPage.SelectTopDealPage();
    	testContextSetup.generalUtils.switchWindowToChild();
   

	}

@Then("validate product name in offers page matchs with landing page.")
public void validate_product_name_in_offers_page_matchs_with_landing_page() {
	Assert.assertEquals(OfferPageProductName, testContextSetup.LandingPageProductName);
	testContextSetup.driver.quit();
}



}
