package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String LandingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GeneralUtils generalUtils;
	
	public TestContextSetup() throws IOException
	{
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		generalUtils = new GeneralUtils(testBase.WebDriverManager());
	}
	
	
}
