package Generic_utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_utility {
	public String getkeyandValueData(String Key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("D:\\MY Courses\\Advanced Selenium\\properties.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return value;
	}
}
