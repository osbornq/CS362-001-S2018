package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;

public class ApptTest
{
	
  @Test(timeout=5000)
  public void testConstructorNoTime()
  {
	  Appt myappt = new Appt(25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
	  boolean timeSet = myappt.hasTimeSet();
  }
	
  @Test(timeout=5000)
  public void testAMPM()
  {
    Appt myappt = new Appt(14, 30, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    String mystring = myappt.toString();
    String expectedstring = "\t25/2/2019 at 2:30pm, Discord Meetup, IRL meetup for Discord Server\n";
    assertNotEquals(expectedstring, mystring);
  }
  
  @Test(timeout=5000)
  public void testAMPMreverse()
  {
    Appt myappt = new Appt(12, 30, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    String mystring = myappt.toString();
    String expectedstring = "\t25/2/2019 at 2:30pm, Discord Meetup, IRL meetup for Discord Server\n";
    assertNotEquals(expectedstring, mystring);
  }
  
  @Test(timeout=5000)
  public void testBadMonth1()
  {
    Appt myappt = new Appt(14, 30, 25, 12, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    myappt.setValid();
    //assertTrue(myappt.getValid());
  }
  @Test(timeout=5000)
  public void testBadMonth2()
  {
    Appt myappt = new Appt(14, 30, 25, 15, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    myappt.setValid();
    assertFalse(myappt.getValid());
  }
  
  @Test(timeout=5000)
  public void testBadMonth3()
  {
    Appt myappt = new Appt(14, 30, 25, -2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    myappt.setValid();
    assertFalse(myappt.getValid());
  }
  
  @Test(timeout=5000)
  public void testBadYear()
  {
    Appt myappt = new Appt(14, 30, 25, 3, -5, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    myappt.setValid();
    assertFalse(myappt.getValid());
  }
  
  @Test(timeout=5000)
  public void testBadMinute1()
  {
    Appt myappt = new Appt(14, -5, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    myappt.setValid();
    assertFalse(myappt.getValid());
  }
  
  @Test(timeout=5000)
  public void testBadMinute2()
  {
    Appt myappt = new Appt(14, 61, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    myappt.setValid();
    assertFalse(myappt.getValid());
  }
  
  @Test(timeout=5000)
  public void testBadDay1()
  {
    Appt myappt = new Appt(14, 30, 29, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    myappt.setValid();
    assertFalse(myappt.getValid());
  }
  
  @Test(timeout=5000)
  public void testBadDay2()
  {
    Appt myappt = new Appt(14, 30, 30, 2, 2016, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    myappt.setValid();
    assertFalse(myappt.getValid());
  }
  
  @Test(timeout=5000)
  public void testBadHour1()
  {
    Appt myappt = new Appt(-1, 30, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    myappt.setValid();
    assertFalse(myappt.getValid());
  }
  
  @Test(timeout=5000)
  public void testBadHour2()
  {
    Appt myappt = new Appt(25, 30, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    myappt.setValid();
    assertFalse(myappt.getValid());
  }
  
  @Test(timeout=5000)
  public void testEmail()
  {
    Appt myappt = new Appt(23, 30, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    String email = myappt.getEmailAddress();
    assertEquals("real-email@real-email-website.com", email);
  }
  
  @Test(timeout=5000)
  public void testTitle()
  {
	Appt myappt = new Appt(23, 30, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
	String title = myappt.getTitle();
	assertEquals("Discord Meetup", title);
  }

  @Test(timeout=5000)
  public void testIsOn()
  {
    Appt myappt = new Appt(23, 30, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    assertTrue(myappt.isOn(25, 2, 2019));
    assertFalse(myappt.isOn(24, 3, 2018));
  }
  
  @Test(timeout=5000)
  public void testStringSets()
  {
    Appt myappt = new Appt(23, 30, 25, 2, 2019, null, null, null);
    assertEquals("", myappt.getEmailAddress());
    assertEquals("", myappt.getDescription());
    assertEquals("", myappt.getTitle());
  }
  
  @Test(timeout=5000)
  public void testRecurrence()
  {
    Appt myappt = new Appt(23, 30, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    int[] recurDaysArr={2,5};
    myappt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);    
    myappt.setValid(); 
    int recur = myappt.getRecurBy();
    boolean recurring = myappt.isRecurring();
    myappt.getRecurIncrement();
  }
  
  @Test(timeout=5000)
  public void testRecurrenceNone()
  {
    Appt myappt = new Appt(23, 30, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com"); 
    myappt.setValid(); 
    int recur = myappt.getRecurBy();
    boolean recurring = myappt.isRecurring();
    myappt.getRecurIncrement();
  }
  
  @Test(timeout=5000)
  public void testGetters()
  {
    Appt myappt = new Appt(10, 30, 25, 2, -1, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com"); 
    myappt.setValid();
    String mystr = myappt.toString();
  }
  
}
