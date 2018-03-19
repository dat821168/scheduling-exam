package ScheduleExam;
import java.util.ArrayList;

public class MonHoc {
	private String MaMH;
	private String TenMH;
	private int degree;
	private int color=0;
	private int type; // 0: Lý thuyết      #0: Thực hành
	private ArrayList<Group> group = new ArrayList<Group>();
	private ArrayList<String> Student= new ArrayList<String>();
	private ArrayList<MonHoc> adjlist= new ArrayList<MonHoc>();
	private ArrayList<ArrayList<Schedule>> schedule= new ArrayList<ArrayList<Schedule>>();
	
	MonHoc(){
		this.MaMH="";
		this.TenMH="";
		this.degree=0;
	}
	MonHoc(String MaMH, String TenMH, int degree,int type,String student){
		this.MaMH=MaMH;
		this.TenMH=TenMH;
		this.degree=degree;
		this.type=type;
		Student.add(student);
	}
	
	public String getMaMH(){
		return MaMH;
	}
	public String getTenMH(){
		return TenMH;
	}
	public int getdegree(){
		return degree;
	}
	public int getnumofstudent(){
		return Student.size();
	}
	public int getcolor(){
		return color;
	}
	public int gettype(){
		return type;
	}
	public String getStudent(int i){
		return Student.get(i);
	}
	public ArrayList<String> getStudent(){
		return Student;
	}
	public MonHoc getadjlist(int i){
		return adjlist.get(i);
	}
	public ArrayList<MonHoc> getadjlist(){
		return adjlist;
	}
	public ArrayList<Group> getGroup(){
		return group;
	}
	public Group getGroup(int i){
		return group.get(i);
	}
	public ArrayList<ArrayList<Schedule>> getSchedule(){
		return schedule;
	}
	public void setMaMH(String MaMH){
		this.MaMH=MaMH;
	}
	public void setcolor(int color){
		this.color=color;
	}
	public void setTenMH(String TenMH){
		this.TenMH=TenMH;
	}
	public void settype(int type){
		this.type=type;
	}
	public void adddegree(){
		this.degree++;
	}
	/*public void setSchedule(String room,int date, int phase){
		schedule.setRoom(room);
		schedule.setDate(date);
		schedule.setPhase(phase);
	}*/
	
}
