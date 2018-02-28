package model;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

public class PersonList implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Person> passangerList = new ArrayList<Person>();
	private Person passanger;
	private int peopleIn;

	public PersonList() {
		peopleIn = 0;
	}

	public int size() {
		return passangerList.size();
	}

	
	public void remove(int i) {
		passangerList.remove(i);
	}
	
	private boolean contains(Person person)
	{
		for (int i = 0; i < passangerList.size(); i++) {
			if(person.equals(passangerList.get(i)))
				return true;
			
		}
		return false;
	}

	public void addPersonMAX(Person person, int maxPeople)
	{
		if (!(contains(person)) && passangerList.size() < maxPeople) {
			passangerList.add(person);
			peopleIn++;
		}
	}
	public int getPeopleInTheMoment()
	{
		return peopleIn;
	}
	
	public void addPerson(Person passanger1) {

		if (!passangerList.contains(passanger1)) {
			passangerList.add(passanger1);
		}

	}

	public void removePassanger(String fname) {
		for (int i = 0; i < passangerList.size(); i++) {
			if (fname.equals(passangerList.get(i).getFName())) {
				passangerList.remove(i);
			}
		}
	}

	public Person getPassager(int index) {
		return passangerList.get(index);
	}

	public String searchPassanger(String fname) {
		for (int i = 0; i < passangerList.size(); i++) {
			if (fname.equals(passangerList.get(i).getFName()))
				return passangerList.get(i).toString();

		}
		return null;

	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < passangerList.size(); i++) {
			temp += passangerList.get(i).toString() + "\n";
		}
		return temp;
	}
	
}
