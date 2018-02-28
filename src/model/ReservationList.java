package model;

import java.io.Serializable;
import java.util.ArrayList;

public class ReservationList implements Serializable{
	private static final long serialVersionUID = 1L;
	   private ArrayList<Reservation> list = new ArrayList<>();
	   
	   public ReservationList()
	   {
		   
	   }
	   public int size()
	   {
	      return list.size();
	   }

	   public Reservation getReservation(int index)
	   {
	      return list.get(index);
	   }

	   public void addReservation(Reservation reservation)
	   {

	      if (!list.contains(reservation))
	      {
	         list.add(reservation);
	      }
	   }

	   public void remove(int number)
	   {
	      list.remove(number);
	   }

	   public void removeByResNumber(int number)
	   {
	      for (int i = 0; i < list.size(); i++)
	      {
	         if (list.get(i).getReservationNumber()== number)
	         {
	            list.remove(i);
	         }
	      }
	   }
	   public Reservation searchReservation(int resNum)
	   {
	      for (int i = 0; i < list.size(); i++)
	      {
	         if (resNum == list.get(i).getReservationNumber())
	            return list.get(i);
	      }
	      return null;
	   }
	   public String toString()
	   {
	      String temp = "";
	      for (int i = 0; i < list.size(); i++)
	      {
	         temp += list.get(i).toString() + "\n";
	      }
	      return temp;
	   }
	   public boolean isTheReservationAdded(Reservation reservation)
	   {
	      if (!list.contains(reservation))
	      {
	         return true;
	      }
	      else
	         return false;
	   }
}
