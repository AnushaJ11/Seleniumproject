package campaign;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_utilities.Excel_utilities;
import Generic_utilities.File_utility;
import Generic_utilities.Java_utility;
import Generic_utilities.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomrespository.Baseclass;
import pomrespository.CreateCampaignsPage;
import pomrespository.CreateProductPage;
import pomrespository.Homepage1;
import pomrespository.Login1page;
import pomrespository.ProductWindowPage;
import pomrespository.ValidationPage;
@Listeners(Generic_utilities.ListenserImplementation.class)
public class CreateCampaignWithProduct extends Baseclass{
	
	@Test(retryAnalyzer=Generic_utilities.IRetryAnalayser.class)
//	public static void main(String[] args) throws Throwable {x
	public void createCampaignWithProduct() throws Throwable
	{
		
		File_utility flib = new File_utility();
		Java_utility jlib = new Java_utility();
		Excel_utilities elib = new Excel_utilities();
		Webdriver_utility wlib = new Webdriver_utility();
        wlib.maximizingWindow(driver);
		wlib.minimizingWindow(driver);
	    String URL = flib.getkeyandValueData("url");
		String USERNAME = flib.getkeyandValueData("username");
		String PASSWORD = flib.getkeyandValueData("password");
		
		driver.get(URL);
		Login1page login = new Login1page(driver);
		login.loginToApplication(USERNAME, PASSWORD);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		Homepage1 home = new Homepage1(driver);
		home.getProductLink();
		//driver.findElement(By.linkText("Products")).click();
        
		CreateProductPage product = new CreateProductPage(driver);
		product.clickProductImg();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
        
        int ranNum = jlib.getRandomNum();
        String ProductName = elib.getDataFormatterdata("Product", 0, 0)+ranNum;
        
        product.productName(ProductName);
	   // driver.findElement(By.name("productname")).sendKeys(ProductName);
	    Thread.sleep(2000);
	    product.clickSaveButton();
	  // driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
	
	    home.clickMoreLink(driver);
	 // driver.findElement(By.linkText("More")).click();
	  // driver.findElement(By.linkText("Campaigns")).click();
	    
	    CreateCampaignsPage campaigns = new CreateCampaignsPage(driver);
	    campaigns.clickCampPlusimg();
	// driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	    
	    
	    ProductWindowPage prdWindow = new ProductWindowPage(driver);
	    prdWindow.clickOnSelectSign(driver, wlib);
	  // driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
    	//wlib.switchWindow(driver,"Products&action");

	Thread.sleep(1000);
	prdWindow.productName(ProductName);
	//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ProductName);
	prdWindow.searchPrdData();
	//driver.findElement(By.xpath("//input[@name='search']")).click();
	
	//    "+value+"
	//driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
	prdWindow.selectProduct(driver, ProductName, wlib);
	//driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
	
	//wlib.switchWindow(driver, "Campaigns&action");

	String CampaginName = elib.getDataFormatterdata("Campaigns", 0, 0)+ranNum;
	
	campaigns.campaignsName(CampaginName);
  // driver.findElement(By.name("campaignname")).sendKeys(CampaginName);
   
	campaigns.clickSaveButton();
  // driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
	ValidationPage validate = new ValidationPage(driver);
	String actData = validate.campValidate();
	Assert.assertEquals(actData,CampaginName);
   Thread.sleep(2000);
   home.logout(driver);
	 //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	   // driver.findElement(By.linkText("Sign Out")).click();
	}
}
