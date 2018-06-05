package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.GregorianCalendar;

public class CalDayTest
{
  @Test(timeout=5000)
  public void testNoDay()
  {
    CalDay mycalday = new CalDay();
    assertFalse(mycalday.isValid());
  }
  
  @Test(timeout=5000)
  public void testGoodDay()
  {
    GregorianCalendar day = new GregorianCalendar(2, 10, 2010);
    CalDay mycalday = new CalDay(day);
    assertTrue(mycalday.isValid());
  }
  
  @Test(timeout=5000)
  public void testAddAppt()
  {
    Appt myappt1 = new Appt(14, 30, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    Appt myappt2 = new Appt(12, 30, 25, 12, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    GregorianCalendar day = new GregorianCalendar(25, 3, 2019);
    CalDay mycalday = new CalDay(day);
    try
    {
    	mycalday.addAppt(myappt1);
    	mycalday.addAppt(myappt2);
    }
    catch (Exception e) {}
    String mystring = mycalday.toString();
  }
  
  @Test(timeout=5000)
  public void testAddInvalidAppt()
  {
    Appt myappt1 = new Appt(14, 30, 25, 17, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    GregorianCalendar day = new GregorianCalendar(25, 13, 2019);
    CalDay mycalday = new CalDay(day);
    mycalday.addAppt(myappt1);
  }
  
  @Test(timeout=5000)
  public void testGetFullInformation()
  {
    Appt myappt1 = new Appt(14, 30, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    Appt myappt2 = new Appt(12, 30, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    GregorianCalendar day = new GregorianCalendar(25, 3, 2019);
    CalDay mycalday = new CalDay(day);
    try
    {
    	mycalday.addAppt(myappt1);
    	mycalday.addAppt(myappt2);
    }
    catch(Exception e) {}
    String mystring = mycalday.getFullInfomrationApp(mycalday);
  }
  
  @Test(timeout=5000)
  public void testAddAppt2()
  {
    Appt myappt1 = new Appt(2, 10, 10, 7, 1, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    GregorianCalendar day = new GregorianCalendar(25, 3, 2019);
    CalDay mycalday = new CalDay(day);
    mycalday.addAppt(myappt1);
    String mystring = mycalday.toString();
  }
  
  @Test(timeout=5000)
  public void testAddAppt3()
  {
    Appt myappt1 = new Appt(15, 7, 0, 0, 0, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    GregorianCalendar day = new GregorianCalendar(25, 3, 2019);
    CalDay mycalday = new CalDay(day);
    mycalday.addAppt(myappt1);
    String mystring = mycalday.toString();
  }
  
  @Test(timeout=5000)
  public void testAddAppt4()
  {
    Appt myappt1 = new Appt(1, 4, 10, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    GregorianCalendar day = new GregorianCalendar(25, 3, 2019);
    CalDay mycalday = new CalDay(day);
    mycalday.addAppt(myappt1);
    String mystring = mycalday.toString();
  }
  
  @Test(timeout=5000)
  public void testAddAppt5()
  {
    Appt myappt1 = new Appt(2, 0, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    GregorianCalendar day = new GregorianCalendar(25, 3, 2019);
    CalDay mycalday = new CalDay(day);
    mycalday.addAppt(myappt1);
    String mystring = mycalday.toString();
  }
  
  @Test(timeout=5000)
  public void testAddAppt6()
  {
    Appt myappt1 = new Appt(1, 20, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    GregorianCalendar day = new GregorianCalendar(25, 3, 2019);
    CalDay mycalday = new CalDay(day);
    mycalday.addAppt(myappt1);
    String mystring = mycalday.toString();
  }
  
  
}
