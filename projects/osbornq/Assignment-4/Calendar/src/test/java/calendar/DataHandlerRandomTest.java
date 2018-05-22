package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	
	private static final int NUM_TESTS = 500;
	
	Random random = new Random();
	
	public static Appt[] GenerateRandomAppts(Random random)
    {
        Appt[] myappts = new Appt[NUM_TESTS];

        //numbers are grouped tightly together near an edge in order to have more like days
        for(int i = 0;i < NUM_TESTS;i++)
        {
        	int randh = ValuesGenerator.getInt(random,21,24);     //hour
        	int randm = ValuesGenerator.getInt(random,55,65);     //minute
        	int randmo = ValuesGenerator.getInt(random,5,11);      //month
        	int randd = ValuesGenerator.getInt(random,20,30);       //day
        	int randy = ValuesGenerator.getInt(random,2016,2019);  //year
        	String rande = ValuesGenerator.getStr(random);         //email
        	String randt = ValuesGenerator.getStr(random);         //title
        	String randde = ValuesGenerator.getStr(random);		   //desc

        	//create new appt
        	myappts[i] = new Appt(randh,randm,randd,randmo,randy,randt,randde,rande);
        	
        	
        }
        return myappts; // return the value of the  appointments to recur 
    }
	
    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	@Test
	public void randomTest() throws Throwable {
		System.out.println("---DATAHANDLER TEST START---");

		Appt [] appts = GenerateRandomAppts(random);
		DataHandler mydh = new DataHandler("myDH.xml", false);

	
		for(int i = 0;i < NUM_TESTS;i++)
		{
			int randrb = ValuesGenerator.getInt(random,0,5);
		    int randri = ValuesGenerator.getInt(random,0,7);
		    int randrn = ValuesGenerator.getInt(random,1,20);
		    int randr = ValuesGenerator.getInt(random,0,4);
		    int [] recur = new int[randr];
		    for(int j = 0;j < randr;j++)
		    {
		    	recur[j] = j+1;
		    }
		    //set recurrence on new appt
		    appts[i].setRecurrence(recur, randrb, randri, randrn);
		    
		    appts[i].setValid();
			mydh.saveAppt(appts[i]);
		}
		 
		int randmo = ValuesGenerator.getInt(random,5,7);      //month
 		int randd = ValuesGenerator.getInt(random,20,25);       //day
 		int randy = ValuesGenerator.getInt(random,2016,2017);  //year
 		GregorianCalendar start = new GregorianCalendar(randy,randmo,randd);
 		
 		int randmo2 = ValuesGenerator.getInt(random,8,11);      //month
		int randd2 = ValuesGenerator.getInt(random,26,30);       //day
		int randy2 = ValuesGenerator.getInt(random,2018,2019);  //year
		GregorianCalendar end = new GregorianCalendar(randy2,randmo2,randd2);
		
		mydh.getApptRange(start,end);
		
		System.out.println("---DATAHANDLER TEST END---");
		
		for(int i = 0; i < NUM_TESTS/2;i++)
		{
			mydh.deleteAppt(appts[i]);
			mydh.deleteAppt(appts[i]);
		}

	}

	
}
