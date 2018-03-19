package ScheduleExam;

import java.io.IOException;

public interface Interface {
	
	public void buildSchedule(String inkq, String inroom, String output,String dateStart, int kindOfTest, int datatype, int filetype ) throws IOException;
	public void toStringStudent(String output);
	public void toStringSubject(String output);
	public void exportExcelSubject(String output) throws IOException;
	public void exportExcelStudent(String output) throws IOException;
}
