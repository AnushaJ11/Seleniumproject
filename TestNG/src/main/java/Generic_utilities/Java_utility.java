package Generic_utilities;

import java.util.Random;

public class Java_utility {
	public int getRandomNum()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt();
		return ranNum;
		
	}
}
