package sms.service;

import static sms.db.JDBCUtil.close;
import static sms.db.JDBCUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import sms.dto.Grade;
import sms.dto.Student;
import sms.model.GradeDAO;
import sms.model.StudentDAO;

public class GradeSearchService {

public ArrayList<Grade> Search(int stu_no) {
		
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		
		ArrayList<Grade> grades = gradeDAO.searchGrades(stu_no);
	
		close(con);
		return grades;
	}
	
}
