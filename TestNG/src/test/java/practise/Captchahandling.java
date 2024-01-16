package practise;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.Tesseract;

public class Captchahandling {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		EdgeOptions opt = new EdgeOptions();
		opt.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new EdgeDriver(opt);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()=\" LOGIN \"]")).click();
		Thread.sleep(2000);
		WebElement captcha = driver.findElement(By.xpath("//img[@class=\"captcha-img\"]"));
		
		TakesScreenshot tss = (TakesScreenshot)captcha;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File desc = new File("./CaptchaScreenshot.png");
		FileUtils.copyFile(src, desc);
		Tesseract ts = new Tesseract();
		ts.setDatapath("C:\\Users\\anush\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
		String path = ts.doOCR(desc);
		String img = path.replaceAll(" ", "");
		System.out.println(img);
		driver.findElement(By.xpath("//input[@id=\"captcha\"]")).sendKeys(img);
	}

}
