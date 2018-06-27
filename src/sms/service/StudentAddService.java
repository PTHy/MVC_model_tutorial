package sms.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static sms.db.JDBCUtil.*;
import sms.dto.Student;
import sms.model.StudentDAO;
import sms.view.*;

public class StudentAddService {
	
	ConsoleView view = new ConsoleView();
	
	public boolean searchStudent(int stu_no) {
		boolean isRegisted = false;
		Connection con = getConnection();
		StudentDAO stuDAO = new StudentDAO(con);
		Student student = stuDAO.selectStudent(stu_no);
		
		if(student != null)
			isRegisted = true;
		
		close(con);
		return isRegisted;
		
	}
	
	public String compareBirthForm(Student newStudent){
		String unfitForm = null;
		String birth = newStudent.getStu_birth();
		
		if(birth.length()!=10 || birth.indexOf("-") !=4 
				|| birth.indexOf("-", 5)!=7){
			return birth;
		}
		
		String birthYear = birth.substring(0, 4);
		String birthMonth = birth.substring(5, 7);
		String birthDay = birth.substring(8);
		
		if(Integer.parseInt(birthYear)>Calendar.getInstance().get(Calendar.YEAR)){
			return birth;
		}
		
		int day=0;
		switch(birthMonth){
		case "01": case "03": case "05": case "07":
		case "08": case "10": case "12":
			day=31;
			break;
		case "04": case "06": case"09": case "11":
			day=30;
			break;
		case "02":
			day=28;
			if(Integer.parseInt(birthYear)%4==0 
					&& Integer.parseInt(birthYear)%100!=0
					|| Integer.parseInt(birthYear)%400==0){
				day=29;
			}
			break;
		default:
			return birth;
		}
		
		if(Integer.parseInt(birthDay)>day 
				|| Integer.parseInt(birthDay)<1)
			return birth;
		
		return unfitForm;
	}

	public boolean addStudent(Student newStudent) {
		boolean isRegiestStudent = false;
		Connection con = getConnection();
		StudentDAO stuDAO = new StudentDAO(con);
		Date birth = null;
		
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long time = sdf.parse(newStudent.getStu_birth()).getTime();
			birth = new Date(time);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//»ðÀÔµÈ Çà¼ö¸¦ ¹Þ¾Æ¿È
		int insertCount = stuDAO.addStudent(newStudent, birth);
		if(insertCount>0) {
			isRegiestStudent = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return isRegiestStudent;
	}
}
