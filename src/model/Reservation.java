package model;

import java.io.Serializable;

public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private Room room;
	private DateInterval dateInterval;
	private PersonList personList;
	private int reservationNumber;

	public Reservation(int reservationNumber, Customer customer, Room room,
			DateInterval dateInterval, PersonList personList) {
		this.reservationNumber = reservationNumber;
		this.customer = customer;
		this.room = room;
		this.dateInterval = dateInterval;
		this.personList = personList;
	}

	public int getCPR() {
		return customer.getCPR();
	}

	public Customer getCustomer() {
		return customer;
	}

	public Room getRoom() {
		return room;
	}

	public DateInterval getDateInterval() {
		return dateInterval;
	}

	public PersonList getPersonList() {
		return personList;
	}

	public int getReservationNumber() {
		return reservationNumber;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Reservation))
			return false;

		Reservation other = (Reservation) obj;
		return customer.equals(other.customer)
				&& dateInterval.equals(other.dateInterval)
				&& room.equals(other.room);
	}

	public String toString() {
		return " Date interval: " + this.dateInterval.toString()
				+ "\n Customer: " + "\n " + this.customer.toString()
				+ "\n Room: " + room.toString() + "\n \n Reservation number: "
				+ this.reservationNumber + "\n \n People:" + "\n "
				+ this.personList.toString()
				+ "\n _______________________________________";
	}

	public String toStringForClient() {
		return " Date interval: " + this.dateInterval.toString()
				+ "\n Customer: " + "\n " + this.customer.toString()
				+ "\n Room: " + room.toString()
				+ "\n \n People:" + "\n " + this.personList.toString()
				+ "\n _______________________________________";
	}
}
