package model;

import java.io.Serializable;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private MyDate birthday;
	private String email, fname, lname, address;
	private int cpr;

	public Customer(int cpr, String fname, String lname, MyDate birthday,
			String address, String email) {
		this.birthday = birthday;
		this.address = address;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.cpr = cpr;

	}
	
	public int getCPR() {

		return this.cpr;
	}
	public String getEmail() {

		return this.email;
	}

	public String getAddress() {

		return this.address;
	}

	public String toString() {
		return "CPR: " + this.cpr +" Name: " + this.fname +" "+ this.lname + "\n Birthday: " + this.birthday
				+ "\n Addres: " + this.address  + "\n E-mail: " + this.email;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Customer))
			return false;

		Customer other = (Customer) obj;
		return fname.equals(other.fname) && this.lname.equals(other.lname) && this.birthday.equals(other.birthday)
				&& this.email.equals(other.email);
	}
	public MyDate getBirthday()
	{
		return birthday;
	}
	public String getfName() {
		return this.fname;
	}

	public String getLname() {
		return this.lname;
	}

}
