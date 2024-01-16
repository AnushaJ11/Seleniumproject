package Organisation;

import org.openqa.selenium.WebDriver;



import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utilities.Excel_utilities;
import Generic_utilities.File_utility;
import Generic_utilities.Java_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomrespository.Baseclass;
import pomrespository.CreateOrganizationpage;
import pomrespository.CreateProductPage;
import pomrespository.Homepage1;
import pomrespository.Login1page;
import pomrespository.ValidationPage;

import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateOrganisation extends Baseclass{
private static final boolean False = false;

@Test(groups = "Smoketest")
	public void CreateOrganisation() throws Throwable  {
		// TODO Auto-generated method stub
		/*File_utility flib = new File_utility();
		WebDriver driver;
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
*/
	/*File_utility flib = new File_utility();   
	String URL = flib.getkeyandValueData("url");
	String USERNAME = flib.getkeyandValueData("username");
	String PASSWORD = flib.getkeyandValueData("password");*/
/*	FileInputStream fis = new FileInputStream("./src/test/resources/AdvSeleCommonData.properties");
	Properties pro = new Properties();
	pro.load(fis);
	String URL = pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");*/
	/*driver.get(URL);
	
	//pom class implementing
	Login1page login1 = new Login1page(driver);
	
	//calling using getter methods
	/*login1.getUserTextField().sendKeys(USERNAME);
	login1.getPasswordTextField().sendKeys(PASSWORD);
	login1.getLoginButton().click();*/
	
	//calling using Business Logics
	//login1.loginToApplication(USERNAME, PASSWORD);
	
	//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	 //driver.findElement(By.id("submitButton")).click();;
		
	Homepage1 home = new Homepage1(driver);
	home.organizationLink();
	//driver.findElement(By.linkText("Organizations")).click();
	CreateOrganizationpage org = new CreateOrganizationpage(driver);
	org.clickOrgPlus();
	//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	Java_utility jlib = new Java_utility();
	int ranNum = jlib.getRandomNum();
	/*Random ran = new Random();
     int ranNum = ran.nextInt(1000);*/
	
//	FileInputStream fes = new FileInputStream("./src/test/resources/AdvSelenium7to9am.xlsx");
//	Workbook book = WorkbookFactory.create(fes);
//	Sheet sheet = book.getSheet("Organization");
//	Row row = sheet.getRow(0);
//     Cell cell = row.getCell(0);
//    String OrgName = cell.getStringCellValue()+ranNum;
	
	Excel_utilities elib = new Excel_utilities();
	
	//String OrgName = elib.getExcelData("Organization", 0, 0)+ranNum;
	String OrgName = elib.getExcelData("Organization", 0, 0)+ranNum;
	//driver.findElement(By.name("accountname")).sendKeys(OrgName);
	CreateOrganizationpage  org1 = new CreateOrganizationpage(driver);
	org1.OrganizationData(OrgName);
	
   //String orgNum = elib.getDataFormatterdata("Organization", 1, 0);
  // driver.findElement(By.id("phone")).sendKeys(orgNum);
    
  
 // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    org.getSaveButton().click();
    ValidationPage validate = new ValidationPage(driver);
	String actData = validate.campValidate();
	Assert.assertEquals(actData,OrgName);
/*String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
 if(actData.contains(OrgName))
 {
	 System.out.println("pass");
 }
 else
	 
 {
	 System.out.println("fail");
 }*/
 
/*	WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(element).click().perform();
	driver.findElement(By.linkText("Sign Out")).click();*/
	Thread.sleep(2000);
 home.logout(driver);
    //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
    //driver.findElement(By.linkText("Sign Out")).click();
 }


}

	


