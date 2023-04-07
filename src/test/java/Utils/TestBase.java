package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.LandingPage;

public class TestBase {

	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		
		if(driver==null) 
		{	
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
				driver = new ChromeDriver();
			}
			if(prop.getProperty("browser") == "firefox")
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//geckodriver.exe");
				driver = new FirefoxDriver();
			}

		
		driver.get(url);
		driver.manage().window().maximize();
		
	}
		return driver;
	}
}
