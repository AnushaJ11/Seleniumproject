package campaign;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_utilities.Excel_utilities;
import Generic_utilities.File_utility;
import Generic_utilities.Java_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomrespository.Baseclass;
import pomrespository.CreateCampaignsPage;
import pomrespository.Homepage1;
import pomrespository.Login1page;
import pomrespository.ValidationPage;
@Listeners(Generic_utilities.ListenserImplementation.class)
public class CreateCampaignTest extends Baseclass {

	@Test
		public void  createCampaignTest() throws Throwable{
			
			/*
			File_utility flib = new File_utility();
			String URL = flib.getkeyandValueData("url");
			String USERNAME = flib.getkeyandValueData("username");
			String PASSWORD = flib.getkeyandValueData("password");

			driver.get(URL);
			Login1page login = new Login1page(driver);
			login.loginToApplication(USERNAME, PASSWORD);
//			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//			driver.findElement(By.id("submitButton")).click();*/

			Homepage1 home = new Homepage1(driver);
			//home.clickMoreLink();
			//home.clickCampLink();
			
			/* WebElement moreLink = driver.findElement(By.linkText("More"));
			Actions act = new Actions(driver);
			act.moveToElement(moreLink).perform();
			driver.findElement(By.linkText("Campaigns")).click();*/
			home.clickMoreLink(driver);
			home.getCampaignsLink();
			CreateCampaignsPage camp = new CreateCampaignsPage(driver);
			camp.clickCampPlusimg();
			//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			
			Java_utility jlib = new Java_utility();
			int ranNum = jlib.getRandomNum();
			
			Excel_utilities elib = new Excel_utilities();
			String CampaginName = elib.getExcelData("Campaign", 0, 0)+ranNum;
			CreateCampaignsPage camp1 = new CreateCampaignsPage(driver);
			camp1.campaignsName(CampaginName);
			//driver.findElement(By.name("campaignname")).sendKeys(CampaginName);
		    
			camp.getSaveButton().click();
			ValidationPage validate = new ValidationPage(driver);
			String actData = validate.campValidate();
			/*SoftAssert soft = new SoftAssert();
			soft.assertEquals(actData,CampaginName);
			soft.assertAll();*/
			Assert.assertEquals(actData,CampaginName);
		   // driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
			 Thread.sleep(2000);
			 /*String Actdata = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
			if(Actdata.contains(CampaginName))
			{
				System.out.println("pass");
				
			}
			else
			{
				System.out.println("fail");
			}*/
			 Thread.sleep(2000);
			home.logout(driver);
			 // driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			 // driver.findElement(By.linkText("Sign Out")).click();
		}

	}

	

