package model;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomList implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Room> rooms;
	
	public RoomList() {
		rooms = new ArrayList<>();
	}
	public  void addRoom(Room room){
		rooms.add(room);
	}
	public Room getRoom(int index){
		return rooms.get(index);
	}
	public String toString()
	{
		String s="";
		for (int i = 0; i < rooms.size(); i++) {
			s+= rooms.get(i).toString() + "\n";
		}
		return s;
	}


}
