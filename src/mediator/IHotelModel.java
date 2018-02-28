package mediator;

import model.Reservation;
import model.ReservationList;
import model.RoomList;

public interface IHotelModel {
	public void saveReservation(Reservation reservation);
	public void deleteReservation(int reservationNum);
	public ReservationList allReseraavtions();
	public Reservation findReservation(int reservationNum);
	public RoomList allRooms();
}
