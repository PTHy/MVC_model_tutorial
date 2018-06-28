package sms.service;

import static sms.db.JDBCUtil.close;
import static sms.db.JDBCUtil.commit;
import static sms.db.JDBCUtil.getConnection;
import static sms.db.JDBCUtil.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import sms.dto.Grade;
import sms.dto.Student;
import sms.model.GradeDAO;
import sms.model.StudentDAO;

public class GradeAddService {

	public boolean searchGrade(int stu_no) {
		boolean isRegisted = false;
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		Grade grade = gradeDAO.selectGrade(stu_no);
		
		if(grade != null)
			isRegisted = true;
		
		close(con);
		return isRegisted;
	}

	public boolean addGrade(Grade newGrade) {
		boolean isRegiestStudent = false;
		Connection con = getConnection();
		GradeDAO stuDAO = new GradeDAO(con);
		
		//»ðÀÔµÈ Çà¼ö¸¦ ¹Þ¾Æ¿È
		int insertCount = stuDAO.addGrade(newGrade);
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
