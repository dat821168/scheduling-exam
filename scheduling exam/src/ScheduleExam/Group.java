package ScheduleExam;

import java.util.ArrayList;

public class Group {
	private int ID;
	private ArrayList<ArrayList<String>> party = new ArrayList<ArrayList<String>>();
	
	Group(){
		ID=0;
	}
	public int getID(){
		return ID;
	}
	public int getnumOfpartty(){
		return party.size();
	}
	public ArrayList<ArrayList<String>> getParty(){
		return party;
	}
	public ArrayList<String> getParty(int i){
		return party.get(i);
	}
	public void setID(int ID){
		this.ID=ID;
	}
}
