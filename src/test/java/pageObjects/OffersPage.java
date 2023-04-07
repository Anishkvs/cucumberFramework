package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {


	public WebDriver driver;
	
	public OffersPage(WebDriver driver)
	{
		this.driver = driver;
		
	}

	private By search = By.xpath("//input[@type='search']");
	private By ProductName = By.xpath("//table/tbody/tr/td[1]");
	//private By ProductName = By.cssSelector("h4.product-name");
	private By offerPageProductName = By.cssSelector("tr td:nth-child(1)");
	private By TopDeals = By.linkText("Top Deals");
	
	public void searchItem(String name) 
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductOfferName()
	{
		return driver.findElement(ProductName).getText();
	}
	public void offerPageProductNameItem()
	{
		driver.findElement(offerPageProductName).getText();
	}
	public void selectTopDealPage() 
	{
		driver.findElement(TopDeals).click();	

	}
}
