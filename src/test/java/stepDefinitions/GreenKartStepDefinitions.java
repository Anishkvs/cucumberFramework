package stepDefinitions;

import static org.testng.Assert.assertEquals;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartStepDefinitions {

	public WebDriver driver;
	public String LandingPageProductName;
	public String OfferPageProductName;
	
@Given("User is on GreenCart landing page")
public void user_is_on_green_cart_landing_page() {
 
	System.setProperty("webdriver.chrome.driver","D:/driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	
	
}

@When("user search with shortName {string} and extract the actual name of product")
public void user_search_with_short_name_and_extract_the_actual_name_of_product(String shortName) throws InterruptedException {

	
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	Thread.sleep(2000);
	String LandingPageProductName =driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	
	System.out.println(LandingPageProductName +"is extracted from HomePage");

}

@Then("user search for {string} shortname in offer page to check if product exist with same name")
public void user_search_the_same_shortname_in_offer_page_to_check_if_product_exist(String shortName) throws InterruptedException {
   
	driver.findElement(By.linkText("Top Deals")).click();
	Set<String>s1 = driver.getWindowHandles();
	Iterator<String> i1 =s1.iterator();
	String parentWindow = i1.next();
	String childWindow = i1.next();
	driver.switchTo().window(childWindow);
		
	driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
	Thread.sleep(2000);
	String OfferPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	System.out.println(OfferPageProductName);
	 
}


@Then("validate product name in offers page matchs with landing page.")
public void validate_product_name_in_offers_page_matchs_with_landing_page() {
	Assert.assertEquals(OfferPageProductName, LandingPageProductName);

}



}
