package mediator;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;
import model.DateInterval;
import model.MyDate;
import model.Person;
import model.PersonList;
import model.Reservation;
import model.ReservationList;
import model.Room;
import model.RoomList;
import utility.persistence.MyDatabase;

public class HotelDatabase implements IHotelPersistance {
	private MyDatabase db;
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "admin";

	public HotelDatabase() throws ClassNotFoundException {
		this.db = new MyDatabase(DRIVER, URL, USER, PASSWORD);
	}

	@Override
	public ReservationList loadReservationList() {
		String sql = "SELECT reservation.reservationnumber,reservation.cpr,reservation.roomnumber, reservation.inday,"
				+ "reservation.inmonth, reservation.inyear, reservation.outday, reservation.outmonth, reservation.outyear"
				+ " FROM \"SEP2\".reservation ;";
		ArrayList<Object[]> result;
		int reservationnumber = 0,cpr=0, roomnumber = 0;
		Reservation reservation = null;
		int inDay= 0, inMonth = 0, inYear = 0, outDay = 0 , outMonth = 0, outYear = 0;
		ReservationList listOfReservations = new ReservationList();
		try{
			result = db.query(sql);
					for (int i = 0; i < result.size(); i++) {
						Object[] row = result.get(i);
						reservationnumber = Integer.parseInt(row[0].toString());
						cpr = Integer.parseInt(row[1].toString());
						roomnumber = Integer.parseInt(row[2].toString());
						Customer cus = findCustomer(cpr);
						Room room = findRoom(roomnumber);
						PersonList pl = findPeopleList(reservationnumber);
						inDay = Integer.parseInt(row[3].toString());
						inMonth = Integer.parseInt(row[4].toString());
						inYear = Integer.parseInt(row[5].toString());
						outDay = Integer.parseInt(row[6].toString());
						outMonth = Integer.parseInt(row[7].toString());
						outYear = Integer.parseInt(row[8].toString());
						MyDate startDateDate = new MyDate(inDay, inMonth, inYear);
						MyDate endDateDate = new MyDate(outDay, outMonth, outYear);
						DateInterval dateInterval = new DateInterval(startDateDate, endDateDate);
						reservation = new Reservation(reservationnumber, cus, room, dateInterval , pl);
						listOfReservations.addReservation(reservation);
					}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listOfReservations;
	}

	@Override
	public RoomList loadRoomList() {
		String sql = "SELECT rooms.number, rooms.type"
				+ " FROM \"SEP2\".rooms ;";
		ArrayList<Object[]> result;
		int roomnumber = 0;
		String roomType = "?";
		RoomList listOfRooms = new RoomList();
		try{
			result = db.query(sql);
					for (int i = 0; i < result.size(); i++) {
						Object[] row = result.get(i);
						roomnumber = Integer.parseInt(row[0].toString());
						roomType =  (String) row[1].toString();
						Room room1 = new Room(roomnumber, roomType);
						listOfRooms.addRoom(room1);
					}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return listOfRooms;
	}

	@Override
	public void saveReservation(Reservation reservation) {
		try {
			String sql = "SELECT RESERVATIONNUMBER FROM \"SEP2\".reservation WHERE reservationnumber = ?;";
			ArrayList<Object[]> results = db.query(sql,
					reservation.getReservationNumber());
			if (results.size() > 0) {
				return;
			}
			sql = "INSERT INTO \"SEP2\".reservation(cpr,roomnumber,inday,inmonth,inyear,outday,outmonth,outyear)"
					+ " VALUES (?,?,?,?,?,?,?,?);";
			db.update(sql, reservation.getCPR(),  reservation.getRoom().getNumber(),
					reservation.getDateInterval().getStartDate().getDay(),
					reservation.getDateInterval().getStartDate().getMonth(),
					reservation.getDateInterval().getStartDate().getYear(),
					reservation.getDateInterval().getEndDate().getDay(),
					reservation.getDateInterval().getEndDate().getMonth(),
					reservation.getDateInterval().getEndDate().getYear());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveCustomer(Customer customer) {
		try {
			String sql = "SELECT CPR FROM \"SEP2\".clients WHERE cpr = ?;";
			ArrayList<Object[]> results = db.query(sql, customer.getCPR());
			if (results.size() > 0) {
				return;
			}
			sql = "INSERT INTO \"SEP2\".clients(addres,cpr,email,fname,lname,bday,bmonth,byear)"
					+ " VALUES (?,?,?,?,?,?,?,?);";
			db.update(sql, customer.getAddress(), customer.getCPR(), customer
					.getEmail(), customer.getfName(), customer.getLname(),
					customer.getBirthday().getDay(), customer.getBirthday()
							.getMonth(), customer.getBirthday().getYear());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveRoomDateInterval(int roomNumber, DateInterval interval) {
		// TODO Auto-generated method stub

	}

	@Override
	public Room findRoom(int roomNum) {
		String sql = "SELECT rooms.number, rooms.type FROM \"SEP2\".rooms WHERE rooms.number = "
				+ roomNum + ";";
		ArrayList<Object[]> result;
		String type = "?";
		int number = 0;
		Room room = null;
		try {

			result = db.query(sql);

			for (int i = 0; i < result.size(); i++) {
				Object[] row = result.get(i);
				number = Integer.parseInt(row[0].toString());
				type = row[1].toString();
				room = new Room(number, type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;

	}

	@Override
	public Customer findCustomer(int cpr) {
		String sql = "SELECT clients.cpr, clients.fname, clients.lname, clients.addres, clients.email,"
				+ "clients.bday,clients.bmonth,clients.byear FROM \"SEP2\".clients WHERE clients.cpr = "
				+ cpr + ";";
		ArrayList<Object[]> result;
		String fname = "?", lname = "?", addres = "?", email = "?";
		int cprNumber = 0, bday = 0, bmonth = 0, byear = 0;
		Customer customer = null;
		try {

			result = db.query(sql);

			for (int i = 0; i < result.size(); i++) {
				Object[] row = result.get(i);
				cprNumber = Integer.parseInt(row[0].toString());
				fname = row[1].toString();
				lname = row[2].toString();
				addres = row[3].toString();
				email = row[4].toString();
				bday = Integer.parseInt(row[5].toString());
				bmonth = Integer.parseInt(row[6].toString());
				byear = Integer.parseInt(row[7].toString());

				MyDate birthday = new MyDate(bday, bmonth, byear);
				customer = new Customer(cprNumber, fname, lname, birthday,
						addres, email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;

	}

	@Override
	public Reservation findReservation(int reservationNum) {
		String sql = "SELECT reservation.reservationnumber,reservation.cpr,reservation.roomnumber, reservation.inday,"
				+ "reservation.inmonth, reservation.inyear, reservation.outday, reservation.outmonth, reservation.outyear"
				+ " FROM \"SEP2\".reservation WHERE reservation.reservationnumber = ?;";
		ArrayList<Object[]> result;
		int reservationnumber = 0,cpr=0, roomnumber = 0;
		Reservation reservation = null;
		int inDay= 0, inMonth = 0, inYear = 0, outDay = 0 , outMonth = 0, outYear = 0;
		try{
			result = db.query(sql,reservationNum);
					for (int i = 0; i < result.size(); i++) {
						Object[] row = result.get(i);
						reservationnumber = Integer.parseInt(row[0].toString());
						cpr = Integer.parseInt(row[1].toString());
						roomnumber = Integer.parseInt(row[2].toString());
						Customer cus = findCustomer(cpr);
						Room room = findRoom(roomnumber);
						PersonList pl = findPeopleList(reservationnumber);
						inDay = Integer.parseInt(row[3].toString());
						inMonth = Integer.parseInt(row[4].toString());
						inYear = Integer.parseInt(row[5].toString());
						outDay = Integer.parseInt(row[6].toString());
						outMonth = Integer.parseInt(row[7].toString());
						outYear = Integer.parseInt(row[8].toString());
						MyDate startDateDate = new MyDate(inDay, inMonth, inYear);
						MyDate endDateDate = new MyDate(outDay, outMonth, outYear);
						DateInterval dateInterval = new DateInterval(startDateDate, endDateDate);
						reservation = new Reservation(reservationnumber, cus, room, dateInterval , pl);
					}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return reservation;
	}

	@Override
	public void deleteReservation(int reservationNum) {
		try{
			
			String sql = "DELETE FROM \"SEP2\".reservation WHERE reservationnumber = " + reservationNum + ";";
	        db.update(sql);
			}catch(SQLException e){
				e.printStackTrace();
			}
	}

	@Override
	public void deleteDateIntervalFromRoom(int roomNum, DateInterval interval) {
		// TODO Auto-generated method stub

	}

	@Override
	public PersonList findPeopleList(int reservationNum) {
		String sql = "SELECT otherpeople.reservationnum, otherpeople.fname, otherpeople.lname, otherpeople.bday,"
				+ " otherpeople.bmonth, otherpeople.byear"
				+ "  FROM \"SEP2\".otherpeople "
				+ " WHERE otherpeople.reservationnum = ?";
		ArrayList<Object[]> results;
		PersonList people = new PersonList();
		String fname = "?", lname = "?";
		int reservationNumber = 0, bday = 0, bmonth = 0, byear = 0;

		try {
			results = db.query(sql,reservationNum);
			for (int i = 0; i < results.size(); i++) {
				Object[] row = results.get(i);
				reservationNumber = Integer.parseInt(row[0].toString());

				fname = row[1].toString();
				lname = row[2].toString();
				bday = Integer.parseInt(row[3].toString());
				bmonth = Integer.parseInt(row[4].toString());
				byear = Integer.parseInt(row[5].toString());

				MyDate birthday = new MyDate(bday, bmonth, byear);
				Person person = new Person(fname, lname, birthday);
				people.addPerson(person);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return people;
	}

	@Override
	public void savePerson(int reservationNum, Person person) {
		try {
			String sql = "SELECT reservationnum FROM \"SEP2\".otherpeople WHERE fname = ? and lname = ? and reservationnum = ?;";
			ArrayList<Object[]> results = db.query(sql, person.getFName(),
					person.getLName(), reservationNum);
			if (results.size() > 0) {
				return;
			}
			sql = "INSERT INTO \"SEP2\".otherpeople(reservationnum,fname,lname,bday,bmonth,byear)"
					+ " VALUES (?,?,?,?,?,?);";
			db.update(sql, reservationNum, person.getFName(),
					person.getLName(), person.getBirthday().getDay(), person
							.getBirthday().getMonth(), person.getBirthday()
							.getYear());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletePeople(int reservationNum) {
try{
			
			String sql = "DELETE FROM \"SEP2\".otherpeople WHERE reservationnum = " + reservationNum + ";";
	        db.update(sql);
			}catch(SQLException e){
				e.printStackTrace();
			}
		
	}

	@Override
	public Reservation findReservation(Reservation reservation) {
		ReservationList list = loadReservationList();
		for (int i = 0; i < list.size(); i++) {
			if(list.getReservation(i).equals(reservation))
					return list.getReservation(i);
		}
		return null;
	}

}
