package mediator;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import model.Reservation;
import model.ReservationList;
import model.RoomList;

public class RemoteServer extends UnicastRemoteObject implements IRemoteServer{
	private static final long serialVersionUID = 1L;
	private IHotelModel db;

	public RemoteServer() throws RemoteException {
		super();
		try {
			db = new HotelModelManager();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			IRemoteServer rmiServer = new RemoteServer();
			Naming.rebind("HotelSystem", rmiServer);
			System.out.println("Starting Server...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void saveReservation(Reservation reservation) {
		db.saveReservation(reservation);
		System.out.println("Saved");

	}

	@Override
	public void deleteReservation(int reservationNum) {
		db.deleteReservation(reservationNum);
	}

	@Override
	public ReservationList allReservations() {
		return db.allReseraavtions();
	}

	@Override
	public Reservation findReservation(int reservationNum) {
		return db.findReservation(reservationNum);
	}

	@Override
	public RoomList allRooms() {
		return db.allRooms();
	}

}
