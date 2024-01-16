package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utilities.Excel_utilities;

public class DataproviderEx1 {
@Test(dataProvider= "dataprovider_BookTicketTest")
	public void bookTicket(String src,String desc)
	{
		System.out.println("Book ticket from "+src+" to "+desc+"");
	}
@DataProvider
	public Object[][] dataprovider_BookTicketTest() throws Throwable
	{
		/*Object[][] obj = new Object[2][2];
		obj[0][0]="Banglore";
		obj[0][1]="Gao";
		obj[1][0]="Banglore";
		obj[1][1]="Gao";
	*/
	Excel_utilities elib = new Excel_utilities();
		Object[][] value = elib.getprovider("Sheet1");
		return value ;
		
	}
}
