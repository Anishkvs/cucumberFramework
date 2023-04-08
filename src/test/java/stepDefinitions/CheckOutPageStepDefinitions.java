package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;

public class CheckOutPageStepDefinitions {

	public WebDriver driver;
	public String OfferPageProductName;
	public String LandingPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	public CheckOutPage checkOutPage;

	
	public CheckOutPageStepDefinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup  = testContextSetup;
		this.checkOutPage = testContextSetup.pageObjectManager.getcheckOutPage();

	}
	

@Then("User has ability to enter promocode and place the order")
public void User_has_ability_to_enter_promocode() 
{
	Assert.assertTrue(checkOutPage.verifyPlaceOrder());
	Assert.assertTrue(checkOutPage.verifyPromoBtn());
}

@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
public void Then_user_proceeds_to_checkout(String name) throws InterruptedException
{
	checkOutPage.checkOutItems();
	Thread.sleep(2000);
}

}
