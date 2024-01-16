package Product;

import Generic_utilities.Excel_utilities;
import Generic_utilities.File_utility;
import pomrespository.Baseclass;
import pomrespository.CreateProductPage;
import pomrespository.Homepage1;
import pomrespository.Login1page;
import pomrespository.ValidationPage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
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
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateProduc extends Baseclass{
	//welcome hello
			@Test(groups = {"Regressiontest","Smoketest"})
			public void createproduct() throws Throwable {
				//File_utility flib = new File_utility();
			//String URL = flib.getkeyandValueData("url");
			//String USERNAME = flib.getkeyandValueData("username");
			//String PASSWORD = flib.getkeyandValueData("password");
		
			/*FileInputStream fis = new FileInputStream("./src/test/resources/AdvSeleCommonData.properties");
			Properties pro = new Properties();
			pro.load(fis);
			String URL = pro.getProperty("url");
			String USERNAME = pro.getProperty("username");
			String PASSWORD = pro.getProperty("password");*/
			
			//driver.get(URL);
			//Login1page login = new Login1page(driver);
			//Login1page login1 = new Login1page(driver);
			//login1.loginToApplication(USERNAME, PASSWORD);
//			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//			driver.findElement(By.id("submitButton")).click();
			
			Homepage1 home = new Homepage1(driver);
			home.productLink();
			//driver.findElement(By.linkText("Products")).click();
			CreateProductPage product=new CreateProductPage(driver);
			product.clickProductImg();
			//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
			
			Random ran = new Random();
		     int ranNum = ran.nextInt(1000);
			
			/*FileInputStream fes = new FileInputStream("./src/test/resources/AdvSelenium7to9am.xlsx");
			Workbook book = WorkbookFactory.create(fes);
			Sheet sheet = book.getSheet("Product");
			Row row = sheet.getRow(0);
		     Cell cell = row.getCell(0);
		    String ProductName = cell.getStringCellValue()+ranNum;*/
		    
		   Excel_utilities elib = new  Excel_utilities();
		    String ProdName = elib.getDataFormatterdata("Product", 0, 0)+ranNum;
		    product.productName(ProdName);
		  // driver.findElement(By.name("productname")).sendKeys(ProductName);
		    product.clickSaveButton();
		//WebElement saveButton = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));
		
		//WebDriver_Utility wlib=new WebDriver_Utility();
		//wlib.scrollPAge(driver, saveButton);
		/*Rectangle rect = saveButton.getRect();
		System.out.println(rect.getX());
		System.out.println(rect.getY());
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1152)");*/
		
		// driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		    ValidationPage validate = new ValidationPage(driver);
			String actData = validate.campValidate();
			Assert.assertEquals(actData,ProdName);
		    Thread.sleep(2000);
		    home.logout(driver);
		 //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		  //  driver.findElement(By.linkText("Sign Out")).click();
		
		}


}
