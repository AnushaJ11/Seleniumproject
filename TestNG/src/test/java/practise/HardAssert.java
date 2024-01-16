package practise;

import org.testng.Assert;

import org.testng.annotations.Test;

public class HardAssert {
	@Test
		public void m1()
		{
			System.out.println("Step1");
			System.out.println("Step1");
			System.out.println("Step1");
			Assert.assertEquals(true,true);
			System.out.println("Step1");
			System.out.println("Step1");
			System.out.println("Step1");
		}
	@Test
	public void m2()
	{
		String Expdat = "Qspiders";
		String ActData = "Qspiders";
		Assert.assertEquals(Expdat,ActData);
	}
}
