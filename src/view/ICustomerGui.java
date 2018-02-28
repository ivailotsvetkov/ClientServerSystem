package view;

import controller.Controller;

public interface ICustomerGui {
	void start(Controller controller);
	void showMaxPeople(int peopleInTheMoment);
	void show(String value);
	String get(String what);
}
