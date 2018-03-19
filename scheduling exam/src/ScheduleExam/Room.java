package ScheduleExam;

import java.util.ArrayList;

public class Room {
	private String ID;
	private int size;
	private int type; /* 0-PM; 1-LT; 2-NT; 3-H */
	
	Room(){
		ID="";
		size=0;
		type=0;
	}
	Room(String ID, int size, int type){
		this.ID=ID;
		this.size=size;
		this.type=type;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID =ID;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public void sortRoom(ArrayList<ArrayList<Room>> room){
		for(int i=0;i<room.size();i++){
			for(int j=0;j<room.get(i).size();j++){
				for(int z=j+1;z<room.get(i).size();z++){
					if(room.get(i).get(j).getSize()>room.get(i).get(z).getSize()){
						Room tmp = room.get(i).get(j);
						room.get(i).set(j,room.get(i).get(z));
						room.get(i).set(z,tmp);
					}
				}
			}
		}
	}
}
