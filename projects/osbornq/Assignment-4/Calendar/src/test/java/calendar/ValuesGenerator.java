package calendar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ValuesGenerator {
	/*
	* params: random,min,max
	* returns: random int between min,max
	*/
	public static int getInt(Random random,int min,int max)
	{
		int generatedInt;
		
		int range = max - min;
		int x = random.nextInt(range + 1); //inclusive
		generatedInt = x + min;
		
		return generatedInt;
	}
	
	/*
	 * params: random
	 * returns: random string of length 5 to 40
	 */
	public static String getStr(Random random)
	{
		//random string will be of length 5 to 40
		int rand = random.nextInt(35) + 5;
		
		char[] str = new char[rand];
		
		for(int i = 0;i < rand;i++)
		{
			int val = random.nextInt(27) + 65;
			if(val == 91) {val = 32;} //leave room for space
			str[i] = (char) val;
		}
		
		String mystr = new String();
		return mystr;
	}
}
