package model;

import java.io.Serializable;
import java.util.ArrayList;

public class DateIntervalList implements Serializable
{
   private static final long serialVersionUID = 1L;
   private ArrayList<DateInterval> list = new ArrayList<>();
   public DateIntervalList()
   {
      
   }
   public int size()
   {
      return list.size();
   }
   public void remove(int index)
   {
      list.remove(index);
   }
   public void removeByDateinterval(DateInterval date)
   {
      for(int i= 0; i < list.size(); i++)
      {
         if(list.get(i).equals(date))
         {
            list.remove(i);
         }
      }
   }
   public void add(DateInterval date)
   {
      if(!list.contains(date))
         {
         list.add(date);
         }
   }
   public DateInterval getDateInterval(int index)
   {
     return list.get(index);
   }
   public String toString()
   {
      String temp = "";
      for(int i =1; i< list.size(); i++)
      {
         try{
         temp += list.get(i).toString() + "\n";
         }
         catch(IndexOutOfBoundsException e)
         {
            e.getStackTrace();
         }
      }
      return temp;
   }
   
  


}
