package sms.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import static sms.db.JDBCUtil.*;
import sms.dto.Student;
import sms.model.StudentDAO;

public class StudentAddService {

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

	public boolean addStudent(Student newStudent) {
		boolean isRegiestStudent = false;
		Connection con = getConnection();
		StudentDAO stuDAO = new StudentDAO(con);
		Date birth = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long time = sdf.parse(newStudent.getStu_birth()).getTime();
			birth = new Date(time);
		}catch (Exception e) {
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
