package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DataHandlerTest
{
  @Test(timeout=5000)
  public void testConstructorDefault()
    throws Throwable
  {
    DataHandler mydh = new DataHandler();
  }
  
  @Test(timeout=5000)
  public void testConstructorName()
    throws Throwable
  {
    DataHandler mydh = new DataHandler("file.xml");
  }
  
  @Test(timeout=5000)
  public void testConstructorFilled()
    throws Throwable
  {
    DataHandler mydh = new DataHandler("trueautosave.xml", true);
  }
  
  @Test(timeout=5000)
  public void testConstructorFalse()
    throws Throwable
  {
    DataHandler mydh = new DataHandler("falseautosave.xml", false);
  }
  
  @Test(timeout=5000)
  public void testSaveDeleteAppt()
    throws Throwable
  {
    DataHandler mydh = new DataHandler("savedelete.xml", true);
    Appt myappt1 = new Appt(14, 30, 25, 2, 2019, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    mydh.saveAppt(myappt1);
    mydh.deleteAppt(myappt1);
  }
  
  @Test(timeout=5000)
  public void testSaveBadAppt()
    throws Throwable
  {
    DataHandler mydh = new DataHandler("calendarbadappt.xml", true);
    Appt myappt1 = new Appt(14, 30, 25, 2, -5, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    myappt1.setValid();
    mydh.saveAppt(myappt1);
  }
  
  @Test(timeout=5000)
  public void testGetApptRange()
    throws Throwable
  {
    DataHandler mydh = new DataHandler("apptrange.xml", true);
    Appt myappt1 = new Appt(14, 30, 25, 2, 2020, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    myappt1.setValid();
    mydh.saveAppt(myappt1);
    GregorianCalendar startday = new GregorianCalendar(2018,1,1);
    GregorianCalendar endday = new GregorianCalendar(2020,12,31);
    mydh.getApptRange(startday, endday);
    mydh.deleteAppt(myappt1);
  }
  
  @Test(timeout=5000)
  public void testGetApptRangeInvalid()
    throws Throwable
  {
    DataHandler mydh = new DataHandler("apptrangeinvalid.xml", false);
    Appt myappt1 = new Appt(14, 30, 25, 2, -1, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    mydh.saveAppt(myappt1);
    GregorianCalendar startday = new GregorianCalendar(2018,1,1);
    GregorianCalendar endday = new GregorianCalendar(2020,12,31);
    mydh.getApptRange(startday, endday);
    mydh.deleteAppt(myappt1);
  }
  
  @Test(timeout=5000)
  public void testMultiAppt()
    throws Throwable
  {
    DataHandler mydh = new DataHandler("apptrangemulti.xml", false);
    Appt myappt1 = new Appt(14, 30, 25, 2, 2020, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    Appt myappt2 = new Appt(14, 30, 25, 2, 2018, "Discord Meetup 2", "2nd IRL meetup for Discord Server", "real-email@real-email-website.com");
    
    Appt myappt3 = new Appt(14, 30, 25, 2, 2019, "Discord Meetup 3", "3rd IRL meetup for Discord Server", "real-email3@real-email-website.com");
    int[] recurDaysArr={2,3,5};
    myappt3.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, 10);
    myappt3.setValid();    
    int hi = myappt3.getRecurNumber();
    System.out.print(hi);
    mydh.saveAppt(myappt1);
    mydh.saveAppt(myappt2);
    mydh.saveAppt(myappt3);
    GregorianCalendar startday = new GregorianCalendar(2018,1,1);
    GregorianCalendar endday = new GregorianCalendar(2020,12,31);
    LinkedList<CalDay> calDays = new LinkedList<CalDay>();
	calDays = (LinkedList<CalDay>) mydh.getApptRange(startday,endday);
    mydh.getApptRange(startday, endday);
    CalDay calday = calDays.get(2);
    String mystr = calday.getFullInfomrationApp(calday);
    System.out.println(mystr);
    mydh.deleteAppt(myappt1);
    mydh.deleteAppt(myappt2);
    mydh.deleteAppt(myappt3);
  }
  
  @Test(timeout=5000)
  public void testMultiApptBadCal()
    throws Throwable
  {
    DataHandler mydh = new DataHandler("apptrangemultibadcal.xml", false);
    Appt myappt1 = new Appt(14, 30, 25, 2, 2020, "Discord Meetup", "IRL meetup for Discord Server", "real-email@real-email-website.com");
    Appt myappt2 = new Appt(14, 30, 25, 2, 2018, "Discord Meetup 2", "2nd IRL meetup for Discord Server", "real-email@real-email-website.com");
    
    Appt myappt3 = new Appt(14, 30, 25, 2, 2019, "Discord Meetup 3", "3rd IRL meetup for Discord Server", "real-email3@real-email-website.com");
    int[] recurDaysArr={2,3,5};
    myappt3.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, 10);
    myappt3.setValid();    
    int hi = myappt3.getRecurNumber();
    System.out.print(hi);
    mydh.saveAppt(myappt1);
    mydh.saveAppt(myappt2);
    mydh.saveAppt(myappt3);
    GregorianCalendar startday = new GregorianCalendar(2010,1,1);
    GregorianCalendar endday = new GregorianCalendar(2010,12,31);
    LinkedList<CalDay> calDays = new LinkedList<CalDay>();
	calDays = (LinkedList<CalDay>) mydh.getApptRange(startday,endday);
    mydh.getApptRange(startday, endday);
    CalDay calday = calDays.get(2);
    String mystr = calday.getFullInfomrationApp(calday);
    System.out.println(mystr);
    mydh.deleteAppt(myappt1);
    mydh.deleteAppt(myappt2);
    mydh.deleteAppt(myappt3);
  }
}
