package model;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String fname, lname;
	private MyDate birthday;

	public Person(String fname, String lname, MyDate birthday) {
		this.fname = fname;
		this.lname = lname;
		this.birthday = birthday;

	}
	
	public String getFName()
	{
		return this.fname;
	}
	
	public MyDate getBirthday()
	{
		return birthday;
	}
	
	public String getLName()
	{
		return this.lname;
	}
		
	public String toString() {
		return "Name: " + this.fname + " " + this.lname + "\n Birthday: "
				+ this.birthday ;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Person))
			return false;

		Person other = (Person) obj;
		return fname.equals(other.fname) && lname.equals(other.lname) && birthday.equals(other.birthday);
	}

	
}
