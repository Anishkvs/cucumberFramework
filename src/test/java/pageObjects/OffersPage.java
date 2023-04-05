package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {


	public WebDriver driver;
	
	public OffersPage(WebDriver driver)
	{
		this.driver = driver;
		
	}

	By search = By.xpath("//input[@type='search']");
	By ProductName = By.cssSelector("h4.product-name");
	By offerPageProductName = By.cssSelector("tr td:nth-child(1)");
	
	public void searchItem(String name) 
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName()
	{
		return driver.findElement(ProductName).getText();
	}
	public void offerPageProductNameItem()
	{
		driver.findElement(offerPageProductName).getText();
	}
}
