package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}

	//Encapsulation
	private By search = By.xpath("//input[@type='search']");
    private By ProductName = By.cssSelector("h4.product-name");
	private By TopDeals = By.linkText("Top Deals");
	private By increament = By.cssSelector("a.increment");
	private By addToCart = By.cssSelector(".product-action button");

	public void searchItem(String name) 
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName()
	{
		return driver.findElement(ProductName).getText();
	}
	
	public void SelectTopDealPage() {
		
		driver.findElement(TopDeals).click();	

	}
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
	
	public void incrementQuality(int quantity) 
	{
		int i = quantity-1;
		while(i>0)
		{
			driver.findElement(increament).click();
			i--;
		}
	}
	
	 public void addToCart() 
	{
       driver.findElement(addToCart).click();
	}
	
}
