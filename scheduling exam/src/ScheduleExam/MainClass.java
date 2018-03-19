package ScheduleExam;
import java.io.IOException;
import java.util.ArrayList;
public  class MainClass implements Interface  {
	private IO io=new IO();
	private Graph graph = new Graph();
	private Room room=new Room();
	private ArrayList<MonHoc> subject = new ArrayList<MonHoc>();
	private ArrayList<Student> student = new ArrayList<Student>();
	private ArrayList<ArrayList<Room>> roomlist = new ArrayList<ArrayList<Room>>();
	public void buildSchedule(String inkq, String inroom, String output,String dateStart, int kindOfTest, int datatype, int filetype ) throws IOException {
		// TODO Auto-generated method stub
		for(int i=0;i<=3;i++){
			roomlist.add(new ArrayList<Room>());
		}
		io.readExcelMonHoc(subject,student,inkq);
		io.readExcelRoom(roomlist,inroom);
		graph.computedegree(subject);
		graph.sortdegree(subject);
		room.sortRoom(roomlist);
		graph.coloringGraph(subject);
		graph.BuildSchedule(subject, roomlist, student,dateStart, kindOfTest);
		if(datatype==0&& filetype==0){
			toStringSubject(output);
		}
		if(datatype==0&& filetype==1){
			exportExcelSubject(output);
		}
		if(datatype==1&& filetype==0){
			toStringStudent(output);
		}
		if(datatype==1&& filetype==1){
			exportExcelStudent(output);
		}
	}
	
	public void toStringStudent(String output) {
		// TODO Auto-generated method stub
		io.toStringStudent(student,output);
		
		
	}
	public void toStringSubject(String output) {
		// TODO Auto-generated method stub
		io.toStringSubject(subject,output);
		
	}
	public void exportExcelSubject(String output) throws IOException {
		// TODO Auto-generated method stub
		io.exportExcelSubject(subject,output);
	}
	public void exportExcelStudent(String output) throws IOException {
		// TODO Auto-generated method stub
		io.exportExcelStudent(student,output);	
	}

}
