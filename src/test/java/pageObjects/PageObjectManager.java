package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LandingPage landingpage;
	public OffersPage offersPage;
	public WebDriver driver;
	public CheckOutPage checkOutPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver; 
	}
	
	public LandingPage getLandingPage() 
	{
		 landingpage = new LandingPage(driver);
		 return landingpage;

	}
	
	public OffersPage getOffersPage() 
	{
		offersPage = new OffersPage(driver);
		 return offersPage;

	}
	
	public CheckOutPage getcheckOutPage() 
	{
		checkOutPage = new CheckOutPage(driver);
		 return checkOutPage;

	}
	
}
