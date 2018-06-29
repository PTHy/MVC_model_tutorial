package sms.model;

import static sms.db.JDBCUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sms.dto.Grade;
import sms.dto.Student;

public class GradeDAO {
	Connection con;
	
	public GradeDAO(Connection con) {
		this.con = con;
	}

	public Grade selectGrade(int stu_no) {
		Grade grade = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM grade where stu_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,stu_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				grade = new Grade(stu_no, rs.getInt("grade_kor"), rs.getInt("grade_eng"), rs.getInt("grade_math"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return grade;
	}

	public int addGrade(Grade newGrade) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO grade values (?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newGrade.getStu_no());
			pstmt.setInt(2, newGrade.getGrade_kor());
			pstmt.setInt(3, newGrade.getGrade_eng());
			pstmt.setInt(4, newGrade.getGrade_math());
			insertCount = pstmt.executeUpdate();

			return insertCount;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<Grade> selectAllGrades() {
		ArrayList<Grade> grades = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM grade";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				grades.add(new Grade(rs.getInt("stu_no"),rs.getInt("grade_kor"),rs.getInt("grade_eng"),rs.getInt("grade_math")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return grades;
	}

	public ArrayList<Grade> searchGrades(int stu_no) {
		ArrayList<Grade> grades = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM grade WHERE stu_no = "+stu_no;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				grades.add(new Grade(rs.getInt("stu_no"),rs.getInt("grade_kor"),rs.getInt("grade_eng"),rs.getInt("grade_math")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null)
				close(pstmt);
			if(rs != null)
				close(rs);
		}
		
		return grades;
	}

	public int ModifyStudent(Grade newGrade) {
		int chk = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE grade SET grade_kor = ?,grade_eng = ?,grade_math = ? WHERE stu_no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newGrade.getGrade_kor());
			pstmt.setInt(2, newGrade.getGrade_eng());
			pstmt.setInt(3, newGrade.getGrade_math());
			pstmt.setInt(4, newGrade.getStu_no());
			chk = pstmt.executeUpdate();
			return chk;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return chk;
	}

	public int deleteGrade(int stu_no) {
		int chk = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM grade WHERE stu_no = ?;";		
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
}
