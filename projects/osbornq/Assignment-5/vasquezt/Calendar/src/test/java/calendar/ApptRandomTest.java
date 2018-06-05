package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test ValuesGenerator  for Appt class.
 */

public class ApptRandomTest {

	private static final int NUM_TESTS = 2500;
	
	Random random = new Random();


	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static Appt[] GenerateRandomAppts(Random random)
    {
        Appt[] myappts = new Appt[NUM_TESTS];

        for(int i = 0;i < NUM_TESTS;i++)
        {
        	int randh = ValuesGenerator.getInt(random,-20,30);     //hour
        	int randm = ValuesGenerator.getInt(random,-20,80);     //minute
        	int randmo = ValuesGenerator.getInt(random,0,15);      //month
        	int randd = ValuesGenerator.getInt(random,0,33);       //day
        	int randy = ValuesGenerator.getInt(random,0,5);  //year
        	String rande = ValuesGenerator.getStr(random);         //email
        	String randt = ValuesGenerator.getStr(random);         //title
        	String randde = ValuesGenerator.getStr(random);		   //desc

        	//create new appt
        	myappts[i] = new Appt(randh,randm,randd,randmo,randy,randt,randde,rande);
        	
        	
        	
        }
        return myappts; // return the value of the  appointments to recur 
    }	

    
	 @Test
	 /*
	  * Random test for setValid
	  */
	 public void randTest() throws Throwable
	 {
		Appt[] appts = GenerateRandomAppts(random);
		System.out.println("---APPT TEST START---");
		for(int i = 0;i < NUM_TESTS;i++)
		{
			try
			{
				appts[i].setValid();
			}
			catch(Exception e) {}
			//create random value for recurrences
	        int randr = ValuesGenerator.getInt(random, 0, 4);
	     
	       	int randChoice = ValuesGenerator.getInt(random,0,4); //20% chance for null recur array
	        int[] recur = null;
	        if(randChoice != 0)
	        {
	        	recur = new int[randr];	
	        	for(int j = 0;j < randr;j++)
	        	{
	        		recur[j] = j + 1;
	        	}
	        }
	        
	        int randrb = ValuesGenerator.getInt(random,0,5);
	        int randri = ValuesGenerator.getInt(random,0,7);
	        int randrn = ValuesGenerator.getInt(random,1,20);
	        	
	        //set recurrence on new appt
	        appts[i].setRecurrence(recur, randrb, randri, randrn);
	        
	        //test isOn with random d/m/y
	        appts[i].isOn(ValuesGenerator.getInt(random,0,28),ValuesGenerator.getInt(random,0,11),ValuesGenerator.getInt(random,5,5));
		 }

		 System.out.println("---APPT TEST END---");
	 }
	 


}