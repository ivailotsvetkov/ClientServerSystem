package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable{
	private static final long serialVersionUID = 1L;
	private String type;
	private int roomNumber;
	private DateIntervalList list;

	public Room(int roomNumber, String roomType) {
		this.roomNumber = roomNumber;
		this.type = roomType;
	}

	public String getType() {
		return type;
	}

	public int getNumber() {
		return roomNumber;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setNumber(int number) {
		this.roomNumber = number;
	}

	public void addDateInterval(DateInterval dateInterval) {
		list.add(dateInterval);

	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Room))
			return false;

		Room other = (Room) obj;
		return roomNumber==other.roomNumber && type.equalsIgnoreCase(other.type);
	}
	
	public String toString() {
//		String listOfTheUnavailability = "";
//		for (int i = 0; i < list.size(); i++) {
//			listOfTheUnavailability += list.getDateInterval(i).toString()
//					+ "\n";
//		}
		return "Room type: " + type + "\nRoom number: " + roomNumber;
//				+ "\nList Of unavailability: " + listOfTheUnavailability;
	}

}
