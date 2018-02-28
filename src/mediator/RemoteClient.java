package mediator;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import model.Customer;
import model.DateInterval;
import model.MyDate;
import model.PersonList;
import model.Reservation;
import model.ReservationList;
import model.Room;
import model.RoomList;

public class RemoteClient extends UnicastRemoteObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private IRemoteServer server;

	public RemoteClient() throws RemoteException {
		try {
			server = (IRemoteServer) Naming
					.lookup("rmi://localhost:1099/HotelSystem");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveReservation(Reservation reservation) throws RemoteException {
		server.saveReservation(reservation);
	}

	public void deleteReservation(int resNum) throws RemoteException {
		server.deleteReservation(resNum);
	}
	public ReservationList allReservations() throws RemoteException
	{
		return server.allReservations();
	}
	public Reservation findReservation(int resNum) throws RemoteException
	{
		return server.findReservation(resNum);
	}
	public RoomList allRooms() throws RemoteException
	{
		return server.allRooms();
	}
}
