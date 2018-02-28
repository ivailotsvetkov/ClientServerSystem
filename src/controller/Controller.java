package controller;

import java.rmi.RemoteException;

import view.CustomerGui;
import view.ICustomerGui;
import view.IReceptionistGui;
import view.ReceptionistGui;
import mediator.RemoteClient;
import model.Customer;
import model.DateInterval;
import model.MyDate;
import model.Person;
import model.PersonList;
import model.Reservation;
import model.Room;

public class Controller implements IController {
	private ICustomerGui customerGUI;
	private IReceptionistGui receptionistGui;
	private RemoteClient client;
	private PersonList listOfPeople;
	private Customer customer;
	private Room room;
	private Reservation reservation;
	private DateInterval dateInterval;

	// Constructor for customer
	public Controller(CustomerGui customerGui) {
		this.customerGUI = customerGui;
		try {
			client = new RemoteClient();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	// Constructor for receptionist
	public Controller(ReceptionistGui receptionistGui) {
		this.receptionistGui = receptionistGui;
		try {
			client = new RemoteClient();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute(String what, String[] objects) {
		if (what.equalsIgnoreCase("Customer")) {
			String fname, lname, email, address;
			int bDay, bMonth, cpr, bYear;
			fname = objects[0];
			lname = objects[1];
			cpr = Integer.parseInt(objects[2].toString());
			bDay = Integer.parseInt(objects[3].toString());
			bMonth = Integer.parseInt(objects[4].toString());
			bYear = Integer.parseInt(objects[5].toString());
			email = objects[6];
			address = objects[7];
			MyDate birthday = new MyDate(bDay, bMonth, bYear);
			customer = new Customer(cpr, fname, lname, birthday, address, email);
		}

		else if (what.equalsIgnoreCase("DateInterval")) {
			int inDay, inMonth, inYear, outDay, outMonth, outYear;
			inDay = Integer.parseInt(objects[0].toString());
			inMonth = Integer.parseInt(objects[1].toString());
			inYear = Integer.parseInt(objects[2].toString());
			outDay = Integer.parseInt(objects[3].toString());
			outMonth = Integer.parseInt(objects[4].toString());
			outYear = Integer.parseInt(objects[5].toString());

			MyDate startDate = new MyDate(inDay, inMonth, inYear);
			MyDate endDate = new MyDate(outDay, outMonth, outYear);
			dateInterval = new DateInterval(startDate, endDate);
		}

		else if (what.equalsIgnoreCase("NewPersonList")) {
			listOfPeople = new PersonList();
		} else if (what.equalsIgnoreCase("AddPerson")) {
			String fname, lname;
			int pbday, pbmonth, pbyear;
			fname = objects[0].toString();
			lname = objects[1].toString();
			pbday = Integer.parseInt(objects[2]);
			pbmonth = Integer.parseInt(objects[3]);
			pbyear = Integer.parseInt(objects[4]);

			MyDate birthday = new MyDate(pbday, pbmonth, pbyear);
			Person person = new Person(fname, lname, birthday);
			System.out.println(person.toString());
			int maxPeople = Integer.parseInt(objects[5].toString());
			listOfPeople.addPersonMAX(person, maxPeople);
			System.out.println(listOfPeople.toString());
			customerGUI.showMaxPeople(listOfPeople.getPeopleInTheMoment());
		} else if (what.equalsIgnoreCase("Room")) {
			int number = Integer.parseInt(objects[0].toString());
			String type = objects[1].toString();

			room = new Room(number, type);

		} else if (what.equalsIgnoreCase("ShowReservation")) {
			reservation = new Reservation(0, customer, room, dateInterval,
					listOfPeople);
			customerGUI.show(reservation.toStringForClient());
		} else if (what.equalsIgnoreCase("SaveReservation")) {
			try {
				client.saveReservation(reservation);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (what.equalsIgnoreCase("AllReservations")) {
			try {
				receptionistGui.show(client.allReservations().toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else if (what.equalsIgnoreCase("FindReservation"))
		{
			int resNum = Integer.parseInt(objects[0].toString());
			try {
				receptionistGui.showFoundRes(client.findReservation(resNum).toString());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(what.equalsIgnoreCase("DeleteReservation"))
		{
			int resNum = Integer.parseInt(objects[0].toString());
			try {
				client.deleteReservation(resNum);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
