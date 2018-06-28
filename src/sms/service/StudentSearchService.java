package sms.service;

import java.sql.*;
import java.util.ArrayList;

import sms.dto.Student;
import sms.model.StudentDAO;

import static sms.db.JDBCUtil.*;

public class StudentSearchService {
	
	public ArrayList<Student> Search(int type,String input) {
		
		Connection con = getConnection();
		StudentDAO stuDAO = new StudentDAO(con);
		ArrayList<Student> students = stuDAO.searchStudents(type,input);
	
		close(con);
		return students;
	}
}
