package sms.model;

import static sms.db.JDBCUtil.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sms.dto.Student;

public class StudentDAO {
	Connection con;
	public StudentDAO(Connection con) {
		this.con = con;
	}
	
	public Student selectStudent(int stu_no) {
		Student student = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student where stu_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,stu_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				student = new Student(rs.getInt("stu_no"),rs.getString("stu_name"),rs.getInt("stu_year"),rs.getString("stuaddr"),rs.getString("stu_tel"),rs.getDate("stu_birth").toString());
			}
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return student;
	}
	public int addStudent(Student newStudent, Date birth) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO student values (?,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newStudent.getStu_no());
			pstmt.setString(2, newStudent.getStu_name());
			pstmt.setInt(3, newStudent.getStu_year());
			pstmt.setString(4, newStudent.getStu_addr());
			pstmt.setString(5, newStudent.getStu_tel());
			pstmt.setString(6, newStudent.getStu_birth());
			insertCount = pstmt.executeUpdate();
			
			return insertCount;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return insertCount;
	}
}
