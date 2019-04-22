package Test1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class sample {
	
	@Test
	
	public void m()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shanthi\\Downloads\\geckodriver-master\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		System.out.println("Welcome to selenium");
		driver.get("https://www.softwaretestingmaterial.com/scroll-web-page-using-selenium-webdriver/");
	
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

}
}
