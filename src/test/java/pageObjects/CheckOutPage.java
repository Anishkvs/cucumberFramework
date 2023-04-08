package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	
	public WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		this.driver = driver;
		
	}

	//Encapsulation
	private By cartBag = By.cssSelector("img[alt='Cart']");
    private By checkOutButton = By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");
	private By promoButton = By.xpath("//button[@class='promoBtn']");
    private By placeOrder = By.xpath("//button[normalize-space()='Place Order']");
    
   public void checkOutItems() 
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
   public boolean verifyPromoBtn() 
   {
	   return driver.findElement(promoButton).isDisplayed();

   }
   public boolean verifyPlaceOrder() 
   {
	  return  driver.findElement(placeOrder).isDisplayed();

   }	
   
	
	
}
