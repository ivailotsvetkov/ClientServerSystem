package Testing;

import mediator.HotelDatabase;
import mediator.HotelModelManager;
import model.Customer;
import model.DateInterval;
import model.MyDate;
import model.Person;
import model.PersonList;
import model.Reservation;
import model.Room;
import model.RoomList;

public class Test {
	public static void main(String[] args) {
		MyDate birthday = new MyDate(2,2,1998);
		MyDate start = new MyDate(20, 2, 2018);
		MyDate end = new MyDate(21, 2, 2018);
		DateInterval dateInterval = new DateInterval(start, end);
		Customer cus = new Customer(2313, "Ceci", "Dimitrov", birthday, "Horsens", "123@abv.bg");
		Person per1 = new Person("Kito", "Ivov", birthday);
		PersonList listOfPeple  = new PersonList();
		listOfPeple.addPerson(per1);
		Room room = new Room(101, "SINGLe");
		Reservation reservation = new Reservation(0, cus, room, dateInterval, listOfPeple);
		HotelDatabase db = null;
		HotelModelManager dbManager = null;
		
		try {
			db = new HotelDatabase();
			dbManager = new HotelModelManager();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbManager.saveReservation(reservation);
//		System.out.println(db.findReservation(reservation).toString());
		
		
//		db.savePerson(2, per1);
//		System.out.println(db.findPeopleList(1).toString());
//		db.deletePeople(1);
//		dbManager.deleteReservation(5);
//		System.out.println(db.findCustomer(2312).toString());
//		System.out.println(db.findReservation(1).toString());
//		System.out.println(db.loadReservationList().toString());
//		System.out.println(db.loadRoomList().toString());
		
	}
}
