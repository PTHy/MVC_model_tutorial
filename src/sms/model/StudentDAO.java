package sms.model;

import static sms.db.JDBCUtil.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sms.dto.Student;

public class StudentDAO {
	Connection con;
	public StudentDAO(Connection con) {
		this.con = con;
	}
	
	public ArrayList<Student> selectAllStudents() {
		ArrayList<Student> students = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				students.add(new Student(rs.getInt("stu_no"),rs.getString("stu_name"),rs.getInt("stu_year"),rs.getString("stu_addr"),rs.getString("stu_tel"),rs.getDate("stu_birth").toString()));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return students;
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
				student = new Student(rs.getInt("stu_no"),rs.getString("stu_name"),rs.getInt("stu_year"),rs.getString("stu_addr"),rs.getString("stu_tel"),rs.getDate("stu_birth").toString());
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
	
	public int deleteStudent(int stu_no) {
		int chk = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM student WHERE stu_no = ?;";		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stu_no);
			chk = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return chk;
	}

	public ArrayList<Student> searchStudents(int type,String input) {
		ArrayList<Student> students = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student WHERE ";
		
		switch (type) {
		case 1:
			sql += "stu_name = '"+input+"';";
			break;
		case 2:
			sql += "stu_no = "+Integer.parseInt(input)+";";
			break;
		case 3:
			sql += "stu_year = "+Integer.parseInt(input)+";";
			break;
		}
		
		System.out.println("sql = "+sql);
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				students.add(new Student(rs.getInt("stu_no"),rs.getString("stu_name"),rs.getInt("stu_year"),rs.getString("stu_addr"),rs.getString("stu_tel"),rs.getDate("stu_birth").toString()));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)
				close(pstmt);
			if(rs != null)
				close(rs);
		}
		
		return students;
	}

	public int ModifyStudent(Student newStudent, Date birth) {
		int chk = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE student SET stu_name = ?,stu_year = ?,stu_addr = ?,stu_tel = ?,stu_birth = ? WHERE stu_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newStudent.getStu_name());
			pstmt.setInt(2, newStudent.getStu_year());
			pstmt.setString(3, newStudent.getStu_addr());
			pstmt.setString(4, newStudent.getStu_tel());
			pstmt.setString(5, newStudent.getStu_birth());
			pstmt.setInt(6, newStudent.getStu_no());
			chk = pstmt.executeUpdate();
			
			return chk;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return chk;
	}
}
