package ScheduleExam;
import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class IO {
	/*******************************************************************************************
	 *                                                                                         *
	 * @param ArrayList<MonHoc> subject                                                        *
	 * @ đọc dữ liệu từ file KetQuaDangKyMonHoc.xlsx và tạo thành danh sách các object MonHoc  * 
	 * @throws IOException                                                  				   *
	 *                                                                                         *
	 *******************************************************************************************/
	public  void readExcelMonHoc(ArrayList<MonHoc> subject, ArrayList<Student> student,String inkq) throws IOException{
		// ------------------------Xử lý File Excel KetQuaDangKyMonHoc-----------------
		try{
			FileInputStream file = new FileInputStream(inkq);
			XSSFWorkbook wb= new XSSFWorkbook(file);
			XSSFSheet sheet=wb.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			//---------------------------------------------------------
			for(int i =1;i<=rows;i++){
				int index;
				//--------------------------------xử lý class Student-------------------------------------------
				String strst=sheet.getRow(i).getCell(5).toString();
				if(!sheet.getRow(i).getCell(1).toString().toLowerCase().contains("đồ án")){
				index=toSearchStudent(student,strst);
				if(index==-1){
					student.add(new Student(sheet.getRow(i).getCell(5).toString(),sheet.getRow(i).getCell(6).toString(),sheet.getRow(i).getCell(7).toString(),sheet.getRow(i).getCell(4).toString(),sheet.getRow(i).getCell(0).toString(),sheet.getRow(i).getCell(1).toString()));
				}
				else{
					student.get(index).getSubject().add(sheet.getRow(i).getCell(0).toString());
					student.get(index).getNameSubject().add(sheet.getRow(i).getCell(1).toString());
					student.get(index).getSchedule().add(new Schedule());
				}
				}
				//-------------------------------xử lý class MonHoc-------------------------------------------
				if(!sheet.getRow(i).getCell(1).toString().toLowerCase().contains("đồ án")){
				String str=sheet.getRow(i).getCell(0).toString();
				index=toSearchSubject(subject,str);
					if(index==-1){
						if(sheet.getRow(i).getCell(3).toString()==""){
							subject.add(new MonHoc(sheet.getRow(i).getCell(0).toString(),sheet.getRow(i).getCell(1).toString(),0,0,sheet.getRow(i).getCell(5).toString()));
							int size=Integer.parseInt(sheet.getRow(i).getCell(2).toString());
							if(size>subject.get(subject.size()-1).getGroup().size()){
								for(int tmp=subject.get(subject.size()-1).getGroup().size();tmp<size;tmp++){
									subject.get(subject.size()-1).getGroup().add(new Group());
									subject.get(subject.size()-1).getSchedule().add(new ArrayList<Schedule>());
								}
							}
							subject.get(subject.size()-1).getGroup().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).getParty().add(new ArrayList<String>());
							subject.get(subject.size()-1).getGroup().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).getParty().get(0).add(sheet.getRow(i).getCell(5).toString());
							subject.get(subject.size()-1).getSchedule().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).add(new Schedule());
						}
						else{
							subject.add(new MonHoc(sheet.getRow(i).getCell(0).toString(),sheet.getRow(i).getCell(1).toString(),0,1,sheet.getRow(i).getCell(5).toString()));
							int size=Integer.parseInt(sheet.getRow(i).getCell(2).toString());
							if(size>subject.get(subject.size()-1).getGroup().size()){
								for(int tmp=subject.get(subject.size()-1).getGroup().size();tmp<size;tmp++){
									subject.get(subject.size()-1).getGroup().add(new Group());
									subject.get(subject.size()-1).getSchedule().add(new ArrayList<Schedule>());
								}
							}
							size=Integer.parseInt(sheet.getRow(i).getCell(3).toString());
							if(size>subject.get(subject.size()-1).getGroup().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).getParty().size()){
								for(int tmp=subject.get(subject.size()-1).getGroup().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).getParty().size();tmp<size;tmp++){
									subject.get(subject.size()-1).getGroup().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).getParty().add(new ArrayList<String>());
									subject.get(subject.size()-1).getSchedule().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).add(new Schedule());
								}
							}
							subject.get(subject.size()-1).getGroup().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).getParty().get(size-1).add(sheet.getRow(i).getCell(5).toString());
						}
					}
					else{
						subject.get(index).getStudent().add(sheet.getRow(i).getCell(5).toString());
						if(sheet.getRow(i).getCell(3).toString()==""){
							int size=Integer.parseInt(sheet.getRow(i).getCell(2).toString());
							if(size>subject.get(index).getGroup().size()){
								for(int tmp=subject.get(index).getGroup().size();tmp<size;tmp++){
									subject.get(index).getGroup().add(new Group());
									subject.get(index).getSchedule().add(new ArrayList<Schedule>());
								}
								subject.get(index).getGroup().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).getParty().add(new ArrayList<String>());
								subject.get(index).getSchedule().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).add(new Schedule());
							}
						subject.get(index).getGroup().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).getParty().get(0).add(sheet.getRow(i).getCell(5).toString());
						}
						else{
							int size=Integer.parseInt(sheet.getRow(i).getCell(2).toString());
							if(size>subject.get(index).getGroup().size()){
								for(int tmp=subject.get(index).getGroup().size();tmp<size;tmp++){
									subject.get(index).getGroup().add(new Group());
									subject.get(index).getSchedule().add(new ArrayList<Schedule>());
								}
							}
							size=Integer.parseInt(sheet.getRow(i).getCell(3).toString());
							if(size>subject.get(index).getGroup().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).getParty().size()){
								for(int tmp=subject.get(subject.size()-1).getGroup().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).getParty().size();tmp<size;tmp++){
									subject.get(index).getGroup().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).getParty().add(new ArrayList<String>());
									subject.get(index).getSchedule().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).add(new Schedule());
								}
							}
							subject.get(index).getGroup().get(Integer.parseInt(sheet.getRow(i).getCell(2).toString())-1).getParty().get(size-1).add(sheet.getRow(i).getCell(5).toString());
						}
					}
				}
			}
			wb.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	// kiểm tra sự tồn tại của student trong list student
	private  int toSearchStudent(ArrayList<Student> student,String str){
			for(int i=0;i<student.size();i++){
				if(str.equals(student.get(i).getID().toString()))
					return i;
			}
			return -1;
		}
	// kiểm tra sự tồn tại của môn học trong list subject
	private  int toSearchSubject(ArrayList<MonHoc> subject,String str){
		for(int i=0;i<subject.size();i++){
			if(str.equals(subject.get(i).getMaMH().toString()))
				return i;
		}
		return -1;
	}

	/*******************************************************************************************
	 *                                                                                         *
	 * @param ArrayList<ArrayList<Room>> room                                                  *
	 * @ đọc dữ liệu từ file DanhSachPhongThi.xlsx và tạo thành danh sách các object Room      * 
	 * @throws IOException                                                  				   *
	 *                                                                                         *
	 *******************************************************************************************/
	public  void readExcelRoom(ArrayList<ArrayList<Room>> room,String inroom) throws IOException{
		// ------------------------Xử lý File Excel DanhSachPhongThi-----------------
		try{
			FileInputStream file = new FileInputStream(inroom);
			XSSFWorkbook wb= new XSSFWorkbook(file);
			XSSFSheet sheet=wb.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			//---------------------------------------------------------
			for(int i =1;i<=rows;i++){
				if(sheet.getRow(i).getCell(2).toString().toLowerCase().contains("pm")){
					room.get(0).add(new Room(sheet.getRow(i).getCell(0).toString(),Integer.parseInt(sheet.getRow(i).getCell(1).toString()),0));
				}
				if(sheet.getRow(i).getCell(2).toString().toLowerCase().contains("lt")){
					room.get(1).add(new Room(sheet.getRow(i).getCell(0).toString(),Integer.parseInt(sheet.getRow(i).getCell(1).toString()),1));
				}					
				if(sheet.getRow(i).getCell(2).toString().toLowerCase().contains("nt")){
					room.get(2).add(new Room(sheet.getRow(i).getCell(0).toString(),Integer.parseInt(sheet.getRow(i).getCell(1).toString()),2));
				}
				if(sheet.getRow(i).getCell(2).toString().toLowerCase().contains("h")){
					room.get(3).add(new Room(sheet.getRow(i).getCell(0).toString(),Integer.parseInt(sheet.getRow(i).getCell(1).toString()),3));
				}
			}
			wb.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	/*************************************************************************
	 *                                                                       *
	 * @param ArrayList<MonHoc>                                              *
	 * @ xuất dữ liệu ra file text theo sinh viên                            * 
	 * @throws IOException                                                   *
	 *                                                                       *
	 *************************************************************************/	
	public  void toStringStudent(ArrayList<Student> students,String output){
		File file = new File(output);
		FileWriter fileWriter=null;
		  BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(file);
		    bufferedWriter = new BufferedWriter(fileWriter);
			for(int i=0;i<students.size();i++){
				 bufferedWriter.write(students.get(i).getID()+" Name: "+students.get(i).getFname()+" "+students.get(i).getLname()+" class: "+students.get(i).getSclass()+":");
				bufferedWriter.write("\n");
				for(int x=0;x<students.get(i).getSchedule().size();x++){
					bufferedWriter.write("  [ "+students.get(i).getNameSubject(x).toString()+": Ngày thi: "+students.get(i).getSchedule().get(x).getDate()+" - Giờ thi: "+students.get(i).getSchedule().get(x).getPhase()+" - Phòng: "+students.get(i).getSchedule().get(x).getRoom()+" ]");
					bufferedWriter.write("\n");
				}
				bufferedWriter.write("\n");
			}
			bufferedWriter.close();
		    fileWriter.close();
		}catch (Exception e) {
		      e.printStackTrace();
		 }
	}
	/*************************************************************************
	 *                                                                       *
	 * @param ArrayList<MonHoc>                                              *
	 * @ xuất dữ liệu ra file text theo môn học                              * 
	 * @throws IOException                                                   *
	 *                                                                       *
	 *************************************************************************/	
	public  void toStringSubject(ArrayList<MonHoc> subjects,String output){
		File file = new File(output);
		FileWriter fileWriter=null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(file);
		    bufferedWriter = new BufferedWriter(fileWriter);
			for(int i=0;i<subjects.size();i++){
				bufferedWriter.write("Mon Hoc: "+ subjects.get(i).getMaMH());
				bufferedWriter.write("\n");
				for(int j =0;j<subjects.get(i).getSchedule().size();j++){
					bufferedWriter.write(" Nhom "+(j+1)+": ");
					bufferedWriter.write("\n");
					for(int x=0;x<subjects.get(i).getSchedule().get(j).size();x++){
						bufferedWriter.write("	[Tổ "+(x+1)+": Ngay: "+subjects.get(i).getSchedule().get(j).get(x).getDate()+"-Giờ Thi: "+subjects.get(i).getSchedule().get(j).get(x).getPhase()+"-Phong: "+subjects.get(i).getSchedule().get(j).get(x).getRoom()+" ]");
						bufferedWriter.write("\n");
					}	
				}
			}
			bufferedWriter.close();
		    fileWriter.close();
		}
		catch (Exception e) {
		      e.printStackTrace();
		 }
	}
	/*************************************************************************
	 *                                                                       *
	 * @param ArrayList<MonHoc>                                              *
	 * @ xuất dữ liệu ra file excel theo môn học                             * 
	 * @throws IOException                                                   *
	 *                                                                       *
	 *************************************************************************/	
	public void exportExcelSubject(ArrayList<MonHoc> subjects,String output) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Schedule");
       ArrayList<Object[]>  datatypes =new  ArrayList<Object[]>();
      
       Object[] objtmp = {"Môn Học", "Mã Môn Học", "Nhóm", "Tổ", "Ngày", "Ca", "phòng"};
       datatypes.add(objtmp); 
        int numOfCol=0;
        for(int i=0;i<subjects.size();i++){
			for(int j =0;j<subjects.get(i).getSchedule().size();j++){
				for(int x=0;x<subjects.get(i).getSchedule().get(j).size();x++){
					objtmp = new Object[7];
					numOfCol=0;
		        	objtmp[numOfCol]=subjects.get(i).getTenMH();
		        	numOfCol++;
		        	objtmp[numOfCol]=subjects.get(i).getMaMH();
					numOfCol++;
					objtmp[numOfCol]=j+1;
					numOfCol++;
					objtmp[numOfCol]=x+1;
					numOfCol++;
					objtmp[numOfCol]=subjects.get(i).getSchedule().get(j).get(x).getDate();
					numOfCol++;
					objtmp[numOfCol]=subjects.get(i).getSchedule().get(j).get(x).getPhase();
					numOfCol++;
					objtmp[numOfCol]=subjects.get(i).getSchedule().get(j).get(x).getRoom();
					datatypes.add(objtmp);
				}
			}
		}    
        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
        for (int i = 0; i <7 ; i++) {
            sheet.autoSizeColumn(i);
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(output);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
	/*************************************************************************
	 *                                                                       *
	 * @param ArrayList<MonHoc>                                              *
	 * @ xuất dữ liệu ra file excel theo sinh viên                           * 
	 * @throws IOException                                                   *
	 *                                                                       *
	 *************************************************************************/	
	public void exportExcelStudent(ArrayList<Student> students, String output) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Schedule");
       ArrayList<Object[]>  datatypes =new  ArrayList<Object[]>();
      
       Object[] objtmp = {"Lớp", "MSSV", "Họ Lót", "Tên", "Mã Môn Thi","Môn Thi", "Ngày", "Ca", "Phòng"};
       datatypes.add(objtmp);
        int numOfCol=0;
		for(int i=0;i<students.size();i++){
			for(int x=0;x<students.get(i).getSchedule().size();x++){
				objtmp = new Object[9];
				numOfCol=0;
				objtmp[numOfCol]=students.get(i).getSclass();
				numOfCol++;
				objtmp[numOfCol]=students.get(i).getID();
				numOfCol++;
				objtmp[numOfCol]=students.get(i).getFname();
				numOfCol++;
				objtmp[numOfCol]=students.get(i).getLname();
				numOfCol++;
				objtmp[numOfCol]=students.get(i).getSubject(x).toString();
				numOfCol++;
				objtmp[numOfCol]=students.get(i).getNameSubject(x).toString();
				numOfCol++;
				objtmp[numOfCol]=students.get(i).getSchedule().get(x).getDate();
				numOfCol++;
				objtmp[numOfCol]=students.get(i).getSchedule().get(x).getPhase();
				numOfCol++;
				objtmp[numOfCol]=students.get(i).getSchedule().get(x).getRoom();
				numOfCol++;
				datatypes.add(objtmp);
			}
		}    
        int rowNum = 0;

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
        for (int i = 0; i <8 ; i++) {
            sheet.autoSizeColumn(i);
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(output);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }
}