package ScheduleExam;


public class Schedule {
	private String room;
	private String date;
	private String phase;
	
	Schedule(){
		this.room="";
		this.date="";
		this.phase="";
	}
	Schedule(String room, String date, String phase){
		this.room=room;	
		this.date=date;
		this.phase=phase;
	}
	
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public void setschedule(String room, String date, String phase){
		this.room=room;
		this.date=date;
		this.phase=phase;
	}
}
