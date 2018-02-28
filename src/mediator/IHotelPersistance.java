package mediator;

import model.Customer;
import model.DateInterval;
import model.Person;
import model.PersonList;
import model.Reservation;
import model.ReservationList;
import model.Room;
import model.RoomList;

public interface IHotelPersistance {
	public ReservationList loadReservationList();
	public RoomList loadRoomList();
	public void saveReservation(Reservation reservation);
	public void saveCustomer(Customer customer);
	public void saveRoomDateInterval(int roomNumber, DateInterval interval);
	public Room findRoom(int roomNum);
	public Customer findCustomer(int cpr);
	public Reservation findReservation(int reservationNum);
	public void deleteReservation(int reservationNum);
	public void deleteDateIntervalFromRoom(int roomNum, DateInterval interval);
	public PersonList findPeopleList(int reservationNum);
	public void savePerson(int reservationNum, Person person);
	public void deletePeople(int reservationNum);
	public Reservation findReservation(Reservation reservation);
}
