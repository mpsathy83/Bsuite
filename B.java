package Bsuite;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class B {

	
	public static String baseurl="http://www.ebay.in/ ";
	public static String nodeurl="http://192.168.28.1:5566/wd/hub";
	public static WebDriver driver=null;


	  
@BeforeTest
public void setup() throws MalformedURLException, InterruptedException
{
	

System.setProperty("webdriver.chrome.driver", "Browsers\\chromedriver.exe");

    driver=new ChromeDriver();
	DesiredCapabilities capabilities1 = DesiredCapabilities.chrome();
	capabilities1.setBrowserName("chrome");
	capabilities1.setPlatform(Platform.WINDOWS);
	driver=new RemoteWebDriver(new URL(nodeurl),capabilities1);
}
	//driver=new ChromeDriver();

@Test
public static void click_login() throws MalformedURLException
{
	
	driver.get(baseurl);
	driver.manage().window().maximize();
	WebElement ebayloginclick=driver.findElement(By.xpath(".//*[@id='gh-ug']/a"));
	ebayloginclick.click();
	
}

	
		
	@AfterTest
	public void endsession()
	{
		
		driver.quit();
	}
}
