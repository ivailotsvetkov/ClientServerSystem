package view;

import controller.Controller;

public interface IReceptionistGui {
	void start(Controller controller);
	void show(String value);
	void showFoundRes(String value);
	String get(String what);
}
