package calendar;


import org.junit.Test;



import static org.junit.Assert.*;

import java.util.Random;
import java.util.GregorianCalendar;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
	private static final int NUM_TESTS = 500;
	
	Random random = new Random();


	/**
	 * Create random appointments
	 */
	public static Appt[] GenerateRandomAppts(Random random)
    {
        Appt[] myappts = new Appt[NUM_TESTS];

        //numbers are grouped tightly together near an edge in order to have more like days
        for(int i = 0;i < NUM_TESTS;i++)
        {
        	int randh = ValuesGenerator.getInt(random,21,24);     //hour
        	int randm = ValuesGenerator.getInt(random,55,65);     //minute
        	int randmo = ValuesGenerator.getInt(random,9,11);      //month
        	int randd = ValuesGenerator.getInt(random,28,30);       //day
        	int randy = ValuesGenerator.getInt(random,2018,2019);  //year
        	String rande = ValuesGenerator.getStr(random);         //email
        	String randt = ValuesGenerator.getStr(random);         //title
        	String randde = ValuesGenerator.getStr(random);		   //desc

        	//create new appt
        	myappts[i] = new Appt(randh,randm,randd,randmo,randy,randt,randde,rande);
        	
        	
        }
        return myappts; // return the value of the  appointments to recur 
    }	

    @Test
	public void randomTest()  throws Throwable  {
    	
    	System.out.println("---CALDAY TEST START---");
    	
    	Appt[] appts = GenerateRandomAppts(random);
    	
    	/*
    	 * Make 10 cal days
    	 */
    	CalDay[] myCalDay = new CalDay[10];
    	for(int i = 0;i < 10; i++)
    	{
    		int randmo = ValuesGenerator.getInt(random,9,11);      //month
    		int randd = ValuesGenerator.getInt(random,28,30);       //day
    		int randy = ValuesGenerator.getInt(random,2018,2019);  //year
    		GregorianCalendar cal = new GregorianCalendar(randy,randmo,randd);
        	myCalDay[i] = new CalDay(cal);
    	}
    	
    	for(int i = 0;i < 10;i++)
    	{
    		for(int j = 0;j < NUM_TESTS;j++)
    		{
    			appts[j].setValid();
    			myCalDay[i].addAppt(appts[j]);
    		}
    	}
		 
    	System.out.println("---CALDAY TEST END---");

	}


	
}
