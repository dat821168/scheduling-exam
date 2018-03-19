package ScheduleExam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Graph {
	private int numofcolor;
	/****************************************************
	 *       Tính bậc của các đỉnh của đồ thị           *
	 ****************************************************/
	public void computedegree(ArrayList<MonHoc> subject){
		for(int i=0;i<subject.size();i++){
			for(int j=i+1;j<subject.size();j++){
				if(contains(subject.get(i).getStudent(),subject.get(j).getStudent())){
					subject.get(i).adddegree();
					subject.get(j).adddegree();
					subject.get(i).getadjlist().add(subject.get(j));
					subject.get(j).getadjlist().add(subject.get(i));
				}
			}
		}
	}
	private Boolean contains(ArrayList<String> a,ArrayList<String> b){
		
		for(int i=0;i<a.size();i++){
			for(int j=0;j<b.size();j++){
				if(a.get(i).equals(b.get(j))){
					return true;
				}
			}
		}
		return false;
	}
	/****************************************************
	 *  Sắp xếp các đỉnh của đồ thị tăng dần theo bậc   *
	 *  của các đỉnh                                    *
	 ****************************************************/
	public void sortdegree(ArrayList<MonHoc> subject){
		for(int i=0;i<subject.size();i++){
			for(int j=i+1;j<subject.size();j++){
				if(subject.get(i).getdegree()<subject.get(j).getdegree()){
					MonHoc tmp = subject.get(i);
					subject.set(i,subject.get(j));
					subject.set(j,tmp);
				}
			}
		}
	}
	/****************************************************
	 *                  Tô màu đồ thị                   *
	 ****************************************************/
	public void coloringGraph(ArrayList<MonHoc> subject){
		numofcolor=0;
		ArrayList<MonHoc> Group= new ArrayList<MonHoc>();
		while(subject.size()>0){
			numofcolor++;
			ArrayList<MonHoc> Grouptmp= new ArrayList<MonHoc>();
			MonHoc tmp = subject.get(0);
			subject.remove(0);
			tmp.setcolor(numofcolor);
			Grouptmp.add(tmp);
			for(int i=0;i<subject.size();i++){
				int count=0;
				for(int j=0;j<Grouptmp.size();j++){
					if(check(subject.get(i).getadjlist(),Grouptmp.get(j).getMaMH())){
						count++;
					}
				}
				if(count==0){
					subject.get(i).setcolor(numofcolor);
					Grouptmp.add(subject.get(i));
					subject.remove(i);
					i--;
				}
			}
			for(int i=0;i<Grouptmp.size();i++){
				Group.add(Grouptmp.get(i));
			}
			
		}
		for(int i=0;i<Group.size();i++){
			subject.add(Group.get(i));
		}
	}
	private static boolean check(ArrayList<MonHoc> adj,String MaMH){
		for(int i =0;i<adj.size();i++){
			if(adj.get(i).getMaMH().equals(MaMH)){
				return true;
			}
		}
		return false;
	}
	/****************************************************
	 *       In đồ thị theo dạng danh sách kề           *
	 ****************************************************/
	public void tostring(ArrayList<MonHoc> subject){
		for(int i=0;i<subject.size();i++){
			System.out.print(subject.get(i).getMaMH()+" Type: "+subject.get(i).gettype()+" Degree: "+subject.get(i).getdegree()+" color: "+subject.get(i).getcolor()+"  Adjlist: ");
			for(int j=0;j<subject.get(i).getadjlist().size();j++){
				System.out.print(subject.get(i).getadjlist(j).getMaMH()+" and ");
			}
			System.out.println();
			for(int j=0;j<subject.get(i).getGroup().size();j++){
				System.out.println(" \t Danh sach nhóm "+(j+1)+": ");
				for(int x=0;x<subject.get(i).getGroup().get(j).getParty().size();x++){
					System.out.print("\t \t Danh sach tổ "+(x+1)+" size: "+subject.get(i).getGroup().get(j).getParty().get(x).size()+" :");
					for(int z=0;z<subject.get(i).getGroup().get(j).getParty().get(x).size();z++){
						System.out.print(subject.get(i).getGroup().get(j).getParty().get(x).get(z)+" and ");
					}
					System.out.println();
				}
			}
			
			System.out.println();
		}
	}
	/****************************************************
	 *       Xây dựng thời khóa biểu                    *
	 ****************************************************/
	public boolean BuildSchedule(ArrayList<MonHoc> subject,ArrayList<ArrayList<Room>> roomlist,ArrayList<Student> student,String dateStart,int typeexam){
		ArrayList<String> roomchecked=new ArrayList<String>();;
		
		int numOfdate,numOfphase;
		if(typeexam==0){
			numOfdate=7;
			numOfphase=10;
		}
		else{
			numOfdate=12;
			numOfphase=4;
		}
		int tmp=0,color=1;
		//----------------------------------------------------------------------------------------------------------
		for(int phase=1;phase<=numOfphase;phase++){
			for(int date=1;date<=numOfdate;date++){
				
				roomchecked=new ArrayList<String>();
				while(subject.get(tmp).getcolor()==color){
					ArrayList<String> room_tmp= new ArrayList<String>();
					if(subject.get(tmp).gettype()==0){
						for(int i=0;i<subject.get(tmp).getGroup().size();i++){ // check tung nhom
							boolean exit=false;
							//subject.get(tmp).getSchedule().add(new ArrayList<Schedule>());
							for(int j=0 ;j<subject.get(tmp).getGroup(i).getnumOfpartty();j++){// check tung tổ
								boolean complete= false; // tim duoc phong chua
								for(int r=0;r<roomlist.get(1).size();r++){ // check tung phong trong danh sach
									if(subject.get(tmp).getGroup(i).getParty(j).size()<=roomlist.get(1).get(r).getSize()){
										if(checkroom(room_tmp,roomchecked,roomlist.get(1).get(r).getID())){
											complete=true;
											room_tmp.add(roomlist.get(1).get(i).getID());
											subject.get(tmp).getSchedule().get(i).get(j).setschedule(roomlist.get(1).get(r).getID(),calculatedate(date,dateStart),calculatephase(phase,typeexam));
											setschedulestudent(student,subject.get(tmp).getGroup(i).getParty(j),subject.get(tmp).getMaMH(),roomlist.get(1).get(i).getID(),calculatedate(date,dateStart),calculatephase(phase,typeexam),0,subject.get(tmp).getGroup(i).getParty(j).size()-1);
											break;
										}
									}
								} // end for check phòng
								if(complete==false){
									int size=subject.get(tmp).getGroup(i).getParty(j).size()/2;
									int count=0;
										for(int r=0;r<roomlist.get(1).size();r++){ // check tung phong trong danh sach
											if(size<=roomlist.get(1).get(r).getSize()){
												if(checkroom(room_tmp,roomchecked,roomlist.get(1).get(i).getID())){
													if(count==0){
														room_tmp.add(roomlist.get(1).get(i).getID());
														subject.get(tmp).getSchedule().get(i).get(j).setschedule(roomlist.get(1).get(r).getID(),calculatedate(date,dateStart),calculatephase(phase,typeexam));
														setschedulestudent(student,subject.get(tmp).getGroup(i).getParty(j),subject.get(tmp).getMaMH(),roomlist.get(1).get(i).getID(),calculatedate(date,dateStart),calculatephase(phase,typeexam),0,size);
														count++;
													}
													else{
														room_tmp.add(roomlist.get(1).get(i).getID());
														
														setschedulestudent(student,subject.get(tmp).getGroup(i).getParty(j),subject.get(tmp).getMaMH(),roomlist.get(1).get(i).getID(),calculatedate(date,dateStart),calculatephase(phase,typeexam),size+1,subject.get(tmp).getGroup(i).getParty(j).size()-1);
														complete=true;
														break;
													}
													
												}
											}
										} // end for check phòng
									if(complete==false){
										System.out.println("zo");
										room_tmp=new ArrayList<String>();
										roomchecked=new ArrayList<String>();
										if(date++>numOfdate){
											date=0;
											phase++;
											if(phase>numOfdate)return false;
											tmp--;
											exit=true;
											break;
										}
										else{
											date++;
											tmp--;
											exit=true;
											break;
										}
									}
								}
							} // end for check tổ
							if(exit) break;
						}
					}
					//------------------------------------------------- Thuc hanh------------------------------------------
					else{
						for(int i=0; i<subject.get(tmp).getGroup().size();i++){
							boolean exit= false;
							
							for(int j=0 ;j<subject.get(tmp).getGroup(i).getnumOfpartty();j++){
								boolean complete=false;
								for(int r=0;r<roomlist.get(0).size();r++){
									if(subject.get(tmp).getGroup().get(i).getParty().get(j).size()<=roomlist.get(0).get(r).getSize()){
										if(checkroom(room_tmp,roomchecked,roomlist.get(0).get(r).getID())){
											complete=true;
											room_tmp.add(roomlist.get(0).get(r).getID());
											subject.get(tmp).getSchedule().get(i).get(j).setschedule(roomlist.get(0).get(r).getID(),calculatedate(date,dateStart),calculatephase(phase,typeexam));
											setschedulestudent(student,subject.get(tmp).getGroup(i).getParty(j),subject.get(tmp).getMaMH(),roomlist.get(0).get(r).getID(),calculatedate(date,dateStart),calculatephase(phase,typeexam),0,subject.get(tmp).getGroup(i).getParty(j).size()-1);
											break;
										}
									}
								}
								if(complete==false){
									int size=subject.get(tmp).getGroup(i).getParty(j).size()/2;
									int count=0;
										for(int r=0;r<roomlist.get(0).size();r++){ // check tung phong trong danh sach
											if(size<=roomlist.get(0).get(r).getSize()){
												if(checkroom(room_tmp,roomchecked,roomlist.get(1).get(i).getID())){
													if(count==0){
														room_tmp.add(roomlist.get(0).get(i).getID());
														subject.get(tmp).getSchedule().get(i).get(j).setschedule(roomlist.get(0).get(r).getID(),calculatedate(date,dateStart),calculatephase(phase,typeexam));
														setschedulestudent(student,subject.get(tmp).getGroup(i).getParty(j),subject.get(tmp).getMaMH(),roomlist.get(0).get(i).getID(),calculatedate(date,dateStart),calculatephase(phase,typeexam),0,size);
														count++;
													}
													else{
														room_tmp.add(roomlist.get(0).get(i).getID());
														//subject.get(tmp).getSchedule().get(i).add(new Schedule(roomlist.get(1).get(r).getID(),date,phase));
														setschedulestudent(student,subject.get(tmp).getGroup(i).getParty(j),subject.get(tmp).getMaMH(),roomlist.get(0).get(i).getID(),calculatedate(date,dateStart),calculatephase(phase,typeexam),size+1,subject.get(tmp).getGroup(i).getParty(j).size()-1);
														complete=true;
														break;
													}
													
												}
											}
										} // end for check phòng
										if(complete==false){
											//System.out.println("zo");
											room_tmp=new ArrayList<String>();
											roomchecked=new ArrayList<String>();
											if(date++>numOfdate){
												date=0;
												phase++;
												if(phase>numOfdate)return false;
												tmp--;
												exit=true;
												break;
											}
											else{
												date++;
												tmp--;
												exit=true;
												break;
											}
										}
								}
							}// check tổ
							if(exit) break;
						}
					}
					for(int i=0;i<room_tmp.size();i++){
						roomchecked.add(room_tmp.get(i));
					}
					tmp++;
					if(tmp>=subject.size()) return true;
				}
				color++;
				if(color>numofcolor){
					return true;
				}
			}
		}
		
		return false;
	}
	public void setschedulestudent(ArrayList<Student> student,ArrayList<String> party,String mon,String room,String date,String phase, int start,int end){
		for(int i=start;i<=end;i++){
			for(int j=0;j<student.size();j++){
				if(student.get(j).getID().toString().toLowerCase().contains(party.get(i).toString().toLowerCase())){
					for(int z=0;z<student.get(j).getSubject().size();z++){
						if(student.get(j).getSubject().get(z).toString().toLowerCase().contains(mon.toString().toLowerCase())){
							student.get(j).getSchedule().get(z).setRoom(room);
							student.get(j).getSchedule().get(z).setDate(date);
							student.get(j).getSchedule().get(z).setPhase(phase);
						}
					}
				}
			}
			
		}
	}
	public boolean checkroom(ArrayList<String> room_tmp,ArrayList<String> roomchecked,String roomID){
		for(int i=0;i<room_tmp.size();i++){
			if(room_tmp.get(i).toString().toLowerCase().contains(roomID.toString().toLowerCase())){
				return false;
			}
		}
		for(int i=0;i<roomchecked.size();i++){
			if(roomchecked.get(i).toString().toLowerCase().contains(roomID.toString().toLowerCase())){
				return false;
			}
		}
		return true;
	}
	@SuppressWarnings("deprecation")
	private String calculatedate(int date, String dateStart){
		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
		Date t;
		 try {
			t = ft.parse(dateStart);
			t.setDate(t.getDate()+(date-1));
			return 	ft.format(t).toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
	private String calculatephase(int phase, int typeexam){
		if(typeexam==0){
			switch(phase){
			case(1): return "7:00";
			case(2): return "8:00";
			case(3): return "9:00";
			case(4): return "10:00";
			case(5): return "13:00";
			case(6): return "14:00";
			case(7): return "15:00";
			case(8): return "16:00";
			case(9): return "17:00";
			default: return "18:00";
			}
		}else{
			switch(phase){
			case(1): return "7:00";
			case(2): return "9:00";
			case(3): return "13:00";
			default: return "15:00";
			}
		}
	}
}
