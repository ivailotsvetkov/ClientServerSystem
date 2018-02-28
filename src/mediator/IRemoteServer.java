package mediator;

import java.rmi.Remote;
import java.rmi.RemoteException;

import model.Reservation;
import model.ReservationList;
import model.RoomList;

public interface IRemoteServer extends Remote{
public void saveReservation(Reservation reservation) throws RemoteException;
public void deleteReservation(int reservationNum) throws RemoteException;
public ReservationList allReservations() throws RemoteException;
public Reservation findReservation(int reservationNum) throws RemoteException;
public RoomList allRooms() throws RemoteException;
}






