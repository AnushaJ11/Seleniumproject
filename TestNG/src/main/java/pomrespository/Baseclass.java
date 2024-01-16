package pomrespository;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Generic_utilities.File_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(groups = {"Smoketest","Regressiontest"})
	public void beforeSuite()
	{
		System.out.println("DataBase connection");
	}
	@BeforeTest(groups = {"Smoketest","Regressiontest"})
	public void beforeTest()
	{
		System.out.println("parallel exceusion start");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"Smoketest","Regressiontest"})
	/*public void beforeClass() throws Throwable
	{
		File_utility flib = new File_utility();
		//WebDriver driver;
	   String BROWSER = flib.getkeyandValueData("browser");*/
	public void beforeClass() throws Throwable
	{
		File_utility flib = new File_utility();
		 String BROWSER = flib.getkeyandValueData("browser");
	   if(BROWSER.equalsIgnoreCase("chrome"))
	   {
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
	   }
	   else if (BROWSER.equalsIgnoreCase("firefox"))
	   {
		WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
	}
	   else if (BROWSER.equalsIgnoreCase("edge")) 
	   {
		WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
	}
	   else
	   {
		   driver=new ChromeDriver();
	   }
	   System.out.println("LunchBrowser");
	   sdriver=driver;
	}
	   @BeforeMethod(groups = {"Smoketest","Regressiontest"})
	  public void beforeMethod() throws Throwable
	  {
		   File_utility flib = new File_utility();
			String URL = flib.getkeyandValueData("url");
			String USERNAME = flib.getkeyandValueData("username");
			String PASSWORD = flib.getkeyandValueData("password");
			driver.get(URL);
			Thread.sleep(2000);
			Login1page login1 = new Login1page(driver);
			login1.loginToApplication(USERNAME, PASSWORD);
	  }
	   @AfterMethod(groups = {"Smoketest","Regressiontest"})
	  public void afterMethod()
	  {
		  System.out.println("Log out from application");
	  }
	   @AfterClass(groups = {"Smoketest","Regressiontest"})
	  public void afterClass()
	  {
		  System.out.println("Close Browser");
	  }
	   @AfterTest(groups = {"Smoketest","Regressiontest"})
	  public void afterTest()
	  {
		  System.out.println("parallel execusion done");
	  }
	   @AfterSuite(groups = {"Smoketest","Regressiontest"})
	public void afterSuite()
	{
		System.out.println("Database connection lose");
	}
	
	
}
