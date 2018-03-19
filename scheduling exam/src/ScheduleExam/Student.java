package ScheduleExam;

import java.util.ArrayList;

public class Student {
	private String ID;
	private String fname;
	private String lname;
	private String sclass;
	private ArrayList<String> subject=new ArrayList<String>();
	private ArrayList<String> nameSubject=new ArrayList<String>();
	private ArrayList<Schedule> schedule=new ArrayList<Schedule>();
	Student(){
		ID="";
		fname="";
		lname="";
		sclass="";
	}
	Student(String ID,String fname,String lname,String sclass,String subject,String nameSubject){
		this.ID=ID;
		this.fname=fname;
		this.lname=lname;
		this.sclass=sclass;
		this.subject.add(subject);
		this.nameSubject.add(nameSubject);
		this.schedule.add(new Schedule());
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public ArrayList<String> getSubject() {
		return subject;
	}
	public String getSubject(int i) {
		return subject.get(i);
	}
	public ArrayList<String> getNameSubject() {
		return nameSubject;
	}
	public String getNameSubject(int i) {
		return nameSubject.get(i);
	}
	public ArrayList<Schedule> getSchedule() {
		return schedule;
	}
}
