package model;

import java.io.Serializable;

public class DateInterval implements Serializable
{
   private static final long serialVersionUID = 1L;
   private MyDate startDate;
   private MyDate endDate;

   public DateInterval(MyDate startDate, MyDate endDate)
   {
      this.startDate = startDate.copy();
      this.endDate = endDate.copy();
   }

   public DateInterval()
   {
     
   }
   
   public MyDate getStartDate()
   {
      return startDate;
   }

   public MyDate getEndDate()
   {
      return endDate;
   }

   public boolean validateDates()
   {
      if (startDate.getYear() < endDate.getYear())
         return true;

      else if ((startDate.getYear() == endDate.getYear())
            && (startDate.getMonth() < endDate.getMonth()))
         return true;

      else if ((startDate.getYear() == endDate.getYear())
            && (startDate.getMonth() == endDate.getMonth())
            && (startDate.getDay() <= endDate.getDay()))
         return true;
      return false;

   }

   public String toString()
   {
      return this.startDate.toString() + " - " + this.endDate.toString();
   }

   public boolean isBeforeThan(DateInterval dateIntervalsFromList)
   {
      if (this.endDate.getYear() < dateIntervalsFromList
            .getStartDate().getYear())
         return true;
      if (this.endDate.getYear() == dateIntervalsFromList
            .getStartDate().getYear()
            && this.endDate.getMonth() < dateIntervalsFromList
                  .getStartDate().getMonth())
         return true;
      if (this.endDate.getYear() == dateIntervalsFromList
            .getStartDate().getYear()
            && this.endDate.getMonth() == dateIntervalsFromList
                  .getStartDate().getMonth()
            && this.endDate.getDay() < dateIntervalsFromList
                  .getStartDate().getDay())
         return true;
      else
         return false;
   }

   public boolean isAfterThan(DateInterval object1)
   {
      if (this.startDate.getYear() > (object1)
            .getEndDate().getYear())
         return true;
      if (this.startDate.getYear() == (object1)
            .getEndDate().getYear()
            && this.startDate.getMonth() > (object1)
                  .getEndDate().getMonth())
         return true;
      if (this.startDate.getYear() == (object1)
            .getEndDate().getYear()
            && this.startDate.getMonth() == (object1)
                  .getEndDate().getMonth()
            && this.startDate.getDay() > (object1)
                  .getEndDate().getDay())
         return true;
      else
         return false;

   }
    public boolean equals(Object obj)
    {
       if (!(obj instanceof DateInterval))
          return false;

       DateInterval other = (DateInterval) obj;
       return this.startDate.equals(other.startDate) && this.endDate.equals(other.endDate); 
    }
    

   

  


  

}