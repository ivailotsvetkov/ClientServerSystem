package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDate implements Serializable
{
   private static final long serialVersionUID = 1L;
   private int month;
   private int day;
   private int year;
   private int monthName;

   public MyDate()
   {
      Calendar now = GregorianCalendar.getInstance();
      this.day = now.get(Calendar.DAY_OF_MONTH);
      this.month = (now.get(Calendar.MONTH) + 1);
      this.year = now.get(Calendar.YEAR);

   }

   public MyDate(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
   }

   public void setMonth(int month)
   {
      this.month = month;
   }

   public void setYear(int year)
   {
      this.year = year;
   }

   public void setDay(int day)
   {
      this.day = day;
   }
   public boolean isThisDateAfterToday()
   {
      Calendar now = GregorianCalendar.getInstance();
      if(this.year>now.get(Calendar.YEAR))
         return true;
      if(this.year==now.get(Calendar.YEAR) && this.month > (now.get(Calendar.MONTH)+1))
         return true;
      if(this.year==now.get(Calendar.YEAR) && this.month == (now.get(Calendar.MONTH)+1) && this.day >= now.get(Calendar.DAY_OF_MONTH))
         return true;
      else 
         return false;
         
      
   }
   // methods
   public int getMonth()
   {
      return (month);
   }

   public int getYear()
   {
      return (year);
   }

   public int getDay()
   {
      return (day);
   }

   public String toString()
   {
      String output = (day + "/" + month + "/" + year);
      return (output);
   }

   public boolean isLeapYear()
   {
      boolean status;
      if ((year % 4 == 0) && (year % 100 != 0))
         status = true;
      else
         status = false;
      return status;

   }

   public int numberOfDaysInMonth()
   {
      int DaysInMonth = 0;
      if ((month == 1) || (month == 3) || (month == 5) || (month == 7)
            || (month == 8) || (month == 10) || (month == 12))
         DaysInMonth = 31;
      else if ((month == 4) || (month == 6) || (month == 9) || (month == 11))
         DaysInMonth = 30;
      else
         DaysInMonth = 29;
      return DaysInMonth;
   }

   public void set(int day, int month, int year)
   {
      if (year < 0)
         this.year = +year;
      if (month < 1)
         this.month = 1;
      if (month > 13)
         this.month = 12;
      if (((day < 1) || (day > 31)) && ((month == 1) || (month == 3)
            || (month == 5) || (month == 7) || (month == 8) || (month == 10)
            || (month == 12)))
         this.day = 31;
      else if (((day < 1) || (day > 30)) && ((month == 4) || (month == 6)
            || (month == 9) || (month == 11)))
         this.day = 30;
      else if ((day < 1) || (day > 29) && (month == 2) && isLeapYear())
         this.day = 29;
      else if ((day < 1) || (day > 29) && (month == 2) && !(isLeapYear()))
         this.day = 28;
   }

   public String getMonthName()
   {
      {
         String name;
         switch (month)
         {
            case 1:
               name = "January";
               break;
            case 2:
               name = "February";
               break;
            case 3:
               name = "March";
               break;
            case 4:
               name = "April";
               break;
            case 5:
               name = "May";
               break;
            case 6:
               name = "June";
               break;
            case 7:
               name = "July";
               break;
            case 8:
               name = "August";
               break;
            case 9:
               name = "September";
               break;
            case 10:
               name = "October";
               break;
            case 11:
               name = "November";
               break;
            case 12:
               name = "December";
               break;
            default:
               name = "Unknown";
               break;
         }
         return name;
      }

   }

   public void stepForwardOneDay()
   {
      this.day = day++;
      this.year = year++;
      this.month = month++;

   }

   public String convertToMonthNumber(String monthName)
   {
      if (month == 1)
         monthName = "January";
      if (month == 2)
         monthName = "February";
      if (month == 3)
         monthName = "March";
      if (month == 4)
         monthName = "April";
      if (month == 5)
         monthName = "May";
      if (month == 6)
         monthName = "June";
      if (month == 7)
         monthName = "July";
      if (month == 8)
         monthName = "August";
      if (month == 9)
         monthName = "September";
      if (month == 10)
         monthName = "October";
      if (month == 11)
         monthName = "November";
      if (month == 12)
         monthName = "December";
      return monthName;
   }

   public void set(int day, String monthName, int year)
   {
      this.day = day;
      this.year = year;
      this.convertToMonthNumber(monthName);
   }

   public MyDate copy()
   {
      MyDate other = new MyDate(day, month, year);
      return other;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof MyDate))
         return false;

      MyDate other = (MyDate) obj;
      return this.day == other.day && this.month == other.month
            && this.year == other.year;

   }

}
