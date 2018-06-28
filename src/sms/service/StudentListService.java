package sms.service;

import java.sql.*;
import java.util.ArrayList;

import static sms.db.JDBCUtil.*;
import sms.dto.Student;
import sms.model.StudentDAO;

public class StudentListService {
	
	public ArrayList<Student> Find() {
		Connection con = getConnection();
		StudentDAO stuDAO = new StudentDAO(con);
		ArrayList<Student> students = stuDAO.selectAllStudents();
		
		close(con);
		return students;
	}
}
