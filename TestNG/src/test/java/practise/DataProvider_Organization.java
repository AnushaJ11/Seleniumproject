package practise;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utilities.Excel_utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider_Organization {
@Test(dataProvider= "getdata")
	public void m1(String orgName,String phoneNum,String emailid) throws Throwable  {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("phone")).sendKeys(phoneNum);
		driver.findElement(By.id("email1")).sendKeys(emailid);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	    driver.findElement(By.linkText("Sign Out")).click();
	    Thread.sleep(1000);
	    driver.quit();
	}
@DataProvider
public Object[][] getdata() throws Throwable
{/*
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);
	Object[][] obj = new Object[3][3];
	obj[0][0]= "AAA"+ranNum;
	obj[0][1]= "8185946477";
	obj[0][2]= "anusha@gmail.com";
	obj[1][0]= "BBB"+ranNum;
	obj[1][1]= "8185946577";
	obj[1][2]= "sweety@gmail.com";
	obj[2][0]= "CCC"+ranNum;
	obj[2][1]= "8185943477";
	obj[2][2]= "jetti@gmail.com";
	*/
	Excel_utilities elib = new Excel_utilities();
	Object[][] obj1 = elib.readmultipledata("Sheet1");
	return obj1;
}
}



