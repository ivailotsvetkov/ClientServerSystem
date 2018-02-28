package mediator;

import model.Reservation;
import model.ReservationList;
import model.RoomList;

public class HotelModelManager implements IHotelModel {
	IHotelPersistance db;

	public HotelModelManager() throws ClassNotFoundException {
		db = new HotelDatabase();
	}

	@Override
	public void saveReservation(Reservation reservation) {
		db.saveCustomer(reservation.getCustomer());
		db.saveReservation(reservation);
		int resNum = db.findReservation(reservation).getReservationNumber();
		for (int i = 0; i < reservation.getPersonList().size(); i++) {
			if(!reservation.getPersonList().getPassager(i).equals(null)){
			db.savePerson(resNum, reservation
					.getPersonList().getPassager(i));
			}
		}
	}

	@Override
	public void deleteReservation(int reservationNum) {
		db.deletePeople(reservationNum);
		db.deleteReservation(reservationNum);

	}

	@Override
	public ReservationList allReseraavtions() {
		return db.loadReservationList();
	}

	@Override
	public Reservation findReservation(int reservationNum) {
		return db.findReservation(reservationNum);
	}

	@Override
	public RoomList allRooms() {
		return db.loadRoomList();
	}

}
