package sms.service;

import static sms.db.JDBCUtil.close;
import static sms.db.JDBCUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import sms.dto.Grade;
import sms.dto.Student;
import sms.model.GradeDAO;
import sms.model.StudentDAO;

public class GradeListService {

	public ArrayList<Grade> Find() {
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		ArrayList<Grade> grades = gradeDAO.selectAllGrades();
		
		close(con);
		return grades;
	}

}
