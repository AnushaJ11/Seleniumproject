package Generic_utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import pomrespository.Baseclass;

public class ListenserImplementation implements ITestListener{
	public void onTestFailure(ITestResult result)
	{
		String testdata = result.getMethod().getMethodName();
		EventFiringWebDriver edriver = new EventFiringWebDriver(Baseclass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try {
		File dest = new File("./ScreenShot/"+testdata+".png");
			FileUtils.copyFile(src, dest);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}
