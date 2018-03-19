package ScheduleExam;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;







import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;







import javax.swing.JScrollPane;

import java.awt.Component;

import javax.swing.JRadioButton;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Panel;

import javax.swing.JTextArea;

public class Home {

	private JFrame frame;
	private JTextField courseTextField;
	private JFileChooser jChooser;
	private JTable courseTable;
	private JTextField roomTextField;
	private JTable roomTable;
	private JTextField textField;
	private JTextField textField_1;
	private String fileInputResult="";
	private String fileInputRoom="";
	private String fileresult="";
	private String datestart="";
	private int kinOfExam=0;
	private int kinOffileresult=0;
	private int kinOfdatat=0;
	private ButtonGroup bgType = new  ButtonGroup();
	private ButtonGroup bgFile = new  ButtonGroup();
	private ButtonGroup bgData = new  ButtonGroup();
	private JLabel lblResult;
	private Interface in = new MainClass();
	private JTable resultTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    frame.setUndecorated(true);
		frame.setBounds(100, 100, 1316, 822);	
		frame.getContentPane().setLayout(null);
		
		
		final Panel mainpanel4 = new Panel();
		mainpanel4.setBackground(Color.WHITE);
		mainpanel4.setBounds(287, 44, 1029, 778);
		frame.getContentPane().add(mainpanel4);
		mainpanel4.setLayout(null);
		
		
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(1, 1, 1016, 610);
		mainpanel4.add(textArea);
		
		final JScrollPane scrollPane_1 = new JScrollPane(textArea);
		scrollPane_1.setBounds(10, 115, 1007, 612);
		mainpanel4.add(scrollPane_1);
		
		resultTable = new JTable();
		resultTable.setBounds(0, 0, 1005, 600);
		mainpanel4.add(resultTable);
		resultTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		resultTable.setBackground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane(resultTable);
		scrollPane.setBounds(12, 115, 1005, 612);
		mainpanel4.add(scrollPane);
		
		JLabel lblNewLabel_2 = new JLabel("Successful");
		lblNewLabel_2.setBounds(350, 0, 323, 61);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 42));
		mainpanel4.add(lblNewLabel_2);
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.setBounds(892, 13, 125, 25);
		btnHomePage.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnHomePage.setBackground(new Color(204, 204, 204));
		mainpanel4.add(btnHomePage);
		mainpanel4.hide();
		
		final JPanel mainpanel3 = new JPanel();
		mainpanel3.setBackground(Color.WHITE);
		mainpanel3.setBounds(287, 44, 1029, 778);
		frame.getContentPane().add(mainpanel3);
		mainpanel3.setLayout(null);
		mainpanel3.hide();
		
		JLabel lblNewLabel_1 = new JLabel("Type of exam:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(48, 146, 151, 16);
		mainpanel3.add(lblNewLabel_1);
		
		final JRadioButton rdbtnMidtermtest = new JRadioButton("Mid-Term Test");
		rdbtnMidtermtest.setBackground(Color.WHITE);
		rdbtnMidtermtest.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnMidtermtest.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnMidtermtest.setBounds(284, 142, 177, 25);
		mainpanel3.add(rdbtnMidtermtest);
		
		JRadioButton rdbtnFinaltermTest = new JRadioButton("Final-Term Test");
		rdbtnFinaltermTest.setBackground(Color.WHITE);
		rdbtnFinaltermTest.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnFinaltermTest.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnFinaltermTest.setBounds(510, 142, 172, 25);
		mainpanel3.add(rdbtnFinaltermTest);
		
		JLabel lblWhichDayBegan = new JLabel("Start date of exam: \r\n");
		lblWhichDayBegan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblWhichDayBegan.setBounds(48, 448, 164, 23);
		mainpanel3.add(lblWhichDayBegan);
		
		textField = new JTextField();
		textField.setBounds(284, 449, 381, 22);
		mainpanel3.add(textField);
		textField.setColumns(10);
		
		JButton settingButton = new JButton("Finish");
		settingButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		settingButton.setBackground(new Color(204, 204, 204));
		settingButton.setBounds(920, 13, 97, 25);
		mainpanel3.add(settingButton);
		
		JLabel lblDataTypeReturned = new JLabel("File type returned:");
		lblDataTypeReturned.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDataTypeReturned.setBounds(48, 246, 207, 23);
		mainpanel3.add(lblDataTypeReturned);
		
		final JRadioButton rdbtnText = new JRadioButton("text");
		rdbtnText.setBackground(Color.WHITE);
		rdbtnText.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnText.setBounds(284, 247, 177, 25);
		mainpanel3.add(rdbtnText);
		
		JRadioButton rdbtnExcel = new JRadioButton("Excel");
		rdbtnExcel.setBackground(Color.WHITE);
		rdbtnExcel.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnExcel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnExcel.setBounds(510, 247, 172, 25);
		mainpanel3.add(rdbtnExcel);
		
		JLabel lblDataTypeReturned_1 = new JLabel("Data type returned:");
		lblDataTypeReturned_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDataTypeReturned_1.setBounds(48, 353, 207, 23);
		mainpanel3.add(lblDataTypeReturned_1);
		
		JRadioButton rdbtnSubject = new JRadioButton("Subject");
		rdbtnSubject.setBackground(Color.WHITE);
		rdbtnSubject.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnSubject.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnSubject.setBounds(284, 353, 177, 25);
		mainpanel3.add(rdbtnSubject);
		
		final JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setBackground(Color.WHITE);
		rdbtnStudent.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnStudent.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnStudent.setBounds(510, 353, 172, 25);
		mainpanel3.add(rdbtnStudent);
		
		JLabel lblCompleteSomeInformation = new JLabel("Complete some information about the exam:");
		lblCompleteSomeInformation.setForeground(Color.RED);
		lblCompleteSomeInformation.setBackground(Color.WHITE);
		lblCompleteSomeInformation.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCompleteSomeInformation.setBounds(12, 63, 617, 23);
		mainpanel3.add(lblCompleteSomeInformation);
		
		JLabel lblSaveResultFile = new JLabel("Save result file in: ");
		lblSaveResultFile.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSaveResultFile.setBounds(48, 550, 164, 23);
		mainpanel3.add(lblSaveResultFile);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(284, 551, 381, 22);
		mainpanel3.add(textField_1);
		
		JLabel lblddmmyyyy = new JLabel("(dd/mm/yyyy)\r\n");
		lblddmmyyyy.setHorizontalAlignment(SwingConstants.CENTER);
		lblddmmyyyy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblddmmyyyy.setBounds(35, 473, 164, 23);
		mainpanel3.add(lblddmmyyyy);
		
		bgData.add(rdbtnStudent);
		bgData.add(rdbtnSubject);
		bgFile.add(rdbtnText);
		bgFile.add(rdbtnExcel);
		bgType.add(rdbtnMidtermtest);
		bgType.add(rdbtnFinaltermTest);
		
		JButton btnBrowse = new JButton("Browse");
		
		btnBrowse.setBackground(new Color(204, 204, 204));
		btnBrowse.setBounds(687, 551, 97, 25);
		mainpanel3.add(btnBrowse);
		mainpanel3.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{rdbtnMidtermtest, lblNewLabel_1, lblCompleteSomeInformation, rdbtnText, rdbtnFinaltermTest, lblWhichDayBegan, textField, settingButton, lblDataTypeReturned, rdbtnExcel, lblDataTypeReturned_1, rdbtnSubject, rdbtnStudent, lblSaveResultFile, textField_1, lblddmmyyyy}));
		
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jChooser = new JFileChooser();
				int result = jChooser.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION){
					textField_1.setText(jChooser.getSelectedFile().getAbsolutePath());
					fileresult=jChooser.getSelectedFile().getAbsolutePath();
				}
			}
		});
		
		final JPanel mainpanel2 = new JPanel();
		mainpanel2.setBackground(new Color(255, 255, 255));
		mainpanel2.setBounds(287, 44, 1029, 778);
		frame.getContentPane().add(mainpanel2);
		mainpanel2.hide();
		mainpanel2.setLayout(null);
		
		roomTextField = new JTextField();
		roomTextField.setEditable(false);
		roomTextField.setBounds(118, 48, 541, 22);
		roomTextField.setColumns(10);
		mainpanel2.add(roomTextField);
		
		JButton roomFileButton = new JButton("Open file ...");
		roomFileButton.setBounds(12, 47, 97, 25);
		roomFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jChooser = new JFileChooser();
				int result = jChooser.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION){
					String excelPath = jChooser.getSelectedFile().getAbsolutePath();
					roomTextField.setText(jChooser.getSelectedFile().getAbsolutePath());
					fileInputRoom=jChooser.getSelectedFile().getAbsolutePath();
					try {
						FileInputStream file = new FileInputStream(excelPath);
						@SuppressWarnings("resource")
						XSSFWorkbook wb= new XSSFWorkbook(file);
						XSSFSheet sheet=wb.getSheetAt(0);
						int rows = sheet.getLastRowNum();
						DefaultTableModel dtm = new DefaultTableModel();	
							dtm.addColumn("Ma Phong");
							dtm.addColumn("Suc Chua");
							dtm.addColumn("Tinh Chat Phong");
							dtm.addColumn("Note");
						for(int i =1;i<=rows;i++){
							ArrayList<String> arrtmp = new ArrayList<String>();
							for(int j=0;j<3;j++){
								arrtmp.add(sheet.getRow(i).getCell(j).toString());
								
							}
							dtm.addRow(new Object[]{arrtmp.get(0),arrtmp.get(1),arrtmp.get(2),""});
						}
						roomTable.setModel(dtm);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			}
		});
		roomFileButton.setBackground(new Color(204, 204, 204));
		mainpanel2.add(roomFileButton);
		
		roomTable = new JTable();
		roomTable.setBounds(1, 1, 1003, 0);
		roomTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		roomTable.setBackground(Color.WHITE);
		mainpanel2.add(roomTable);
		
		JScrollPane roomScrollPane = new JScrollPane(roomTable);
		roomScrollPane.setBounds(12, 116, 1005, 611);
		mainpanel2.add(roomScrollPane);
		
		JButton roomButton = new JButton("Next");
		
		roomButton.setBounds(920, 13, 97, 25);
		roomButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		roomButton.setBackground(new Color(204, 204, 204));
		mainpanel2.add(roomButton);
		
		JLabel lblChoosesRoomFile = new JLabel("Chooses Room File: ");
		lblChoosesRoomFile.setForeground(Color.RED);
		lblChoosesRoomFile.setBounds(12, 13, 283, 24);
		lblChoosesRoomFile.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		mainpanel2.add(lblChoosesRoomFile);
		
		JButton btnBack = new JButton("Back");
		
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBack.setBackground(new Color(204, 204, 204));
		btnBack.setBounds(811, 13, 97, 25);
		mainpanel2.add(btnBack);
		
		
		
		JPanel toppanel = new JPanel();
		toppanel.setBackground(new Color(102, 153, 255));
		toppanel.setBounds(0, 0, 1316, 45);
		frame.getContentPane().add(toppanel);
		toppanel.setLayout(null);
		
		JLabel lblExit = new JLabel("Exit");
		lblExit.setForeground(new Color(255, 255, 255));
		lblExit.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblExit.setIcon(new ImageIcon(Home.class.getResource("/images/icons8_Exit_40px.png")));
		lblExit.setBounds(1221, 0, 83, 45);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		toppanel.add(lblExit);
		
		
		JPanel leftpanel = new JPanel();
		leftpanel.setBackground(new Color(0, 51, 153));
		leftpanel.setBounds(0, 0, 287, 822);
		frame.getContentPane().add(leftpanel);
		leftpanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(39, 61, 189, 107);
		leftpanel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/images/icons8_Students_100px.png")));
		
		JLabel label = new JLabel("");
		label.setBounds(82, 168, 100, 19);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Home.class.getResource("/images/icons8_Horizontal_Line_100px.png")));
		leftpanel.add(label);
		
		final JPanel filepanel = new JPanel();
		filepanel.setBackground(new Color(153, 153, 255));
		filepanel.setBounds(0, 288, 287, 58);
		leftpanel.add(filepanel);
		filepanel.setLayout(null);
		
		JLabel lblImportFileList = new JLabel("Import Course Registration File");
		lblImportFileList.setForeground(new Color(255, 255, 255));
		lblImportFileList.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblImportFileList.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportFileList.setBounds(0, 0, 287, 58);
		filepanel.add(lblImportFileList);
		
		final JPanel roompanel = new JPanel();
		roompanel.setBackground(new Color(0, 51, 204));
		roompanel.setBounds(0, 390, 287, 58);
		leftpanel.add(roompanel);
		roompanel.setLayout(null);
		
		JLabel lblImportListOf = new JLabel("Import List Of Room File");
		lblImportListOf.setForeground(new Color(255, 255, 255));
		lblImportListOf.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblImportListOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblImportListOf.setBounds(0, 0, 287, 58);
		roompanel.add(lblImportListOf);
		
		final JPanel setttingpanel = new JPanel();
		setttingpanel.setBackground(new Color(0, 51, 204));
		setttingpanel.setBounds(0, 487, 287, 58);
		leftpanel.add(setttingpanel);
		setttingpanel.setLayout(null);
		
		JLabel lblSetting = new JLabel("Setting");
		lblSetting.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetting.setForeground(Color.WHITE);
		lblSetting.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSetting.setBounds(0, 0, 287, 58);
		setttingpanel.add(lblSetting);
		
		final JPanel resultpanel = new JPanel();
		resultpanel.setBackground(new Color(0, 51, 204));
		resultpanel.setBounds(0, 589, 287, 58);
		leftpanel.add(resultpanel);
		resultpanel.setLayout(null);
		
		lblResult = new JLabel("Result");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setForeground(Color.WHITE);
		lblResult.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblResult.setBounds(0, 0, 287, 58);
		resultpanel.add(lblResult);
		
		final JPanel mainpanel = new JPanel();
		mainpanel.setBackground(new Color(255, 255, 255));
		mainpanel.setBounds(287, 44, 1029, 778);
		frame.getContentPane().add(mainpanel);
		mainpanel.setLayout(null);
		
		courseTextField = new JTextField();
		courseTextField.setEditable(false);
		courseTextField.setBounds(121, 51, 541, 22);
		mainpanel.add(courseTextField);
		courseTextField.setColumns(10);
		
				JButton courseFileButton = new JButton("Open file ...");
				courseFileButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						jChooser = new JFileChooser();
						int result = jChooser.showOpenDialog(null);
						if(result == JFileChooser.APPROVE_OPTION){
							String excelPath = jChooser.getSelectedFile().getAbsolutePath();
							courseTextField.setText(jChooser.getSelectedFile().getAbsolutePath());
							fileInputResult=jChooser.getSelectedFile().getAbsolutePath();
							try {
								FileInputStream file = new FileInputStream(excelPath);
								@SuppressWarnings("resource")
								XSSFWorkbook wb= new XSSFWorkbook(file);
								XSSFSheet sheet=wb.getSheetAt(0);
								int rows = sheet.getLastRowNum();
								DefaultTableModel dtm = new DefaultTableModel();	
									dtm.addColumn("Ma MH");
									dtm.addColumn("Ten MH");
									dtm.addColumn("Nhom");
									dtm.addColumn("To");
									dtm.addColumn("Lop");
									dtm.addColumn("MSSV");
									dtm.addColumn("Ho");
									dtm.addColumn("Ten");
								for(int i =1;i<=rows;i++){
									ArrayList<String> arrtmp = new ArrayList<String>();
									for(int j=0;j<8;j++){
										arrtmp.add(sheet.getRow(i).getCell(j).toString());
										
									}
									dtm.addRow(new Object[]{arrtmp.get(0),arrtmp.get(1),arrtmp.get(2),arrtmp.get(3),
											arrtmp.get(4),arrtmp.get(5),arrtmp.get(6),arrtmp.get(7)});
								}
								courseTable.setModel(dtm);
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							
						}
					}
				});
				courseFileButton.setBackground(new Color(204, 204, 204));
				courseFileButton.setBounds(12, 50, 97, 25);
				mainpanel.add(courseFileButton);
				
				courseTable = new JTable();
				courseTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				courseTable.setBackground(new Color(255, 255, 255));
				courseTable.setBounds(37, 80, 924, 685);
				mainpanel.add(courseTable);
				
				JScrollPane courseScrollPane = new JScrollPane(courseTable);
				courseScrollPane.setBounds(12, 78, 1005, 651);
				mainpanel.add(courseScrollPane);
				
				JButton courseButton = new JButton("Next");
				courseButton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent arg0) {
						if(courseTextField.getText().equals("")){
							
						}else{
							mainpanel.hide();
							filepanel.setBackground(new Color(0, 51, 204));
							roompanel.setBackground(new Color(153, 153, 255));
							mainpanel2.show();
						}
					}
				});
				courseButton.setBackground(new Color(204, 204, 204));
				courseButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				courseButton.setBounds(920, 13, 97, 25);
				mainpanel.add(courseButton);
				
				JLabel lblChoosesCourseRegistration = new JLabel("Chooses Course Registration File: ");
				lblChoosesCourseRegistration.setForeground(Color.RED);
				lblChoosesCourseRegistration.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				lblChoosesCourseRegistration.setBounds(12, 13, 283, 24);
				mainpanel.add(lblChoosesCourseRegistration);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainpanel2.hide();
				roompanel.setBackground(new Color(0, 51, 204));
				filepanel.setBackground(new Color(153, 153, 255));
				mainpanel.show();
			}
		});
		roomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(roomTextField.getText().equals("")){
					
				}else{
					mainpanel2.hide();
					roompanel.setBackground(new Color(0, 51, 204));
					setttingpanel.setBackground(new Color(153, 153, 255));
					mainpanel3.show();
				}
			}
		});
		settingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("")||fileresult.equals("")){
					
				}else{	
					mainpanel3.hide();
					setttingpanel.setBackground(new Color(0, 51, 204));
					resultpanel.setBackground(new Color(153, 153, 255));
					mainpanel4.show();
					datestart=textField.getText().trim().toString();
					if(rdbtnStudent.isSelected()){
						kinOfdatat=1; 
					}else{
						kinOfdatat=0;
					}
					if(rdbtnText.isSelected()){
						kinOffileresult=0;
						fileresult=fileresult+".txt";
					}else{
						kinOffileresult=1;
						fileresult=fileresult+".xlsx";
					}
					if(rdbtnMidtermtest.isSelected()){
						kinOfExam=0;
					}else{
						kinOfExam=1;
					}
					try{
						in.buildSchedule(fileInputResult,fileInputRoom,fileresult ,datestart,kinOfExam, kinOfdatat, kinOffileresult);
					}
					catch(IOException e){
						
					}
					if(kinOffileresult==1){
						textArea.hide();
						scrollPane_1.hide();
						if(kinOfdatat==1){
						try {
								FileInputStream file = new FileInputStream(fileresult);
								@SuppressWarnings("resource")
								XSSFWorkbook wb= new XSSFWorkbook(file);
								XSSFSheet sheet=wb.getSheetAt(0);
								int rows = sheet.getLastRowNum();
								DefaultTableModel dtm = new DefaultTableModel();	
									dtm.addColumn("Lớp");
									dtm.addColumn("MSSV");
									dtm.addColumn("Họ Lót");
									dtm.addColumn("Tên");
									dtm.addColumn("Mã Môn Thi");
									dtm.addColumn("Môn Thi");
									dtm.addColumn("Ngày");
									dtm.addColumn("Ca");
									dtm.addColumn("Phòng");
								for(int i =1;i<=rows;i++){
									ArrayList<String> arrtmp = new ArrayList<String>();
									for(int j=0;j<9;j++){
										arrtmp.add(sheet.getRow(i).getCell(j).toString());
										
									}
									dtm.addRow(new Object[]{arrtmp.get(0),arrtmp.get(1),arrtmp.get(2),arrtmp.get(3),
											arrtmp.get(4),arrtmp.get(5),arrtmp.get(6),arrtmp.get(7),arrtmp.get(8)});
								}
								resultTable.setModel(dtm);
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}else{
							try {
								FileInputStream file = new FileInputStream(fileresult);
								@SuppressWarnings("resource")
								XSSFWorkbook wb= new XSSFWorkbook(file);
								XSSFSheet sheet=wb.getSheetAt(0);
								int rows = sheet.getLastRowNum();
								DefaultTableModel dtm = new DefaultTableModel();	
									dtm.addColumn("Môn Học");
									dtm.addColumn("Mã Môn Học");
									dtm.addColumn("Nhóm");
									dtm.addColumn("Tổ");
									dtm.addColumn("Ngày");
									dtm.addColumn("Ca");
									dtm.addColumn("Phòng");
								for(int i =1;i<=rows;i++){
									ArrayList<String> arrtmp = new ArrayList<String>();
									for(int j=0;j<7;j++){
										arrtmp.add(sheet.getRow(i).getCell(j).toString());
										
									}
									dtm.addRow(new Object[]{arrtmp.get(0),arrtmp.get(1),arrtmp.get(2),arrtmp.get(3),
											arrtmp.get(4),arrtmp.get(5),arrtmp.get(6)});
								}
								resultTable.setModel(dtm);
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}else{
						
						try{
							File file = new File(fileresult);
							BufferedReader in = new BufferedReader(new FileReader(file));
							String line = in.readLine();
							while(line != null){
								textArea.append(line + "\n");
								line = in.readLine();
							}
						}catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					}
				}
			}
		});
      
		}
}
