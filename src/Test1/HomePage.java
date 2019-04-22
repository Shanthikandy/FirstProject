package Test1;


	import java.util.List;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Capabilities;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxOptions;
	import org.openqa.selenium.firefox.FirefoxProfile;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class HomePage {
		
		WebDriver driver;
		FirefoxProfile profile  = new FirefoxProfile();
		 FirefoxOptions options = new FirefoxOptions();
		@BeforeMethod
		public void launch() throws InterruptedException
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\ShanthiKandasamy\\Documents\\geckodriver.exe" );
			driver = new FirefoxDriver(options );
			driver.get("http://the-internet.herokuapp.com/");
			driver.findElement(By.xpath("//a[text() = 'File Download']")).click();
			Thread.sleep(3000);
			profile.setPreference("browser.download.dir", "C:\\Users\\ShanthiKandasamy\\eclipse-workspace\\udemy\\Learning\\test-output\\Downloads");
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "Text Document (.txt)");
			options.setProfile(profile);
			Thread.sleep(5000);
		}
		
		@Test
		public void basicAuth() throws InterruptedException 
		{
			//driver.findElement(By.xpath("//a[text()='File Upload']")).click();
			//driver.findElement(By.xpath("//input[@id = 'file-upload']")).sendKeys("C:\\Users\\ShanthiKandasamy\\Desktop\\sample.txt");
			//driver.findElement(By.xpath("//input[@value ='Upload']")).click();
			
		//	profile.setPreference("browser.helperApps.neverAsk.openFile;", "application/Text Document"); 
			//profile.setPreference("browser.download.manager.showWhenStarting",false);
			List<WebElement> ls = driver.findElements(By.tagName("a"));
			
			int a = ls.size();
			Thread.sleep(3000);
			for(int i =0;i<=a;i++)
			{
				System.out.println("List of links available" + ls.get(i).getText());
				if(ls.get(i).getText().equals("some-file.txt"))
				{
					ls.get(i).click();
					driver.switchTo().alert().accept();
					
				}
				
				else 
					ls.get(i);
			}
			}
		
		@AfterMethod
		public void closeenv()
		{
			driver.close();
		}
		}



}
