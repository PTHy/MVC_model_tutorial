package sms.service;

import static sms.db.JDBCUtil.close;
import static sms.db.JDBCUtil.commit;
import static sms.db.JDBCUtil.getConnection;
import static sms.db.JDBCUtil.rollback;

import java.sql.Connection;

import sms.model.GradeDAO;
import sms.model.StudentDAO;

public class GradeDeleteService {
	public boolean Delete(int stu_no) {
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		boolean chk = false;
		int del_chk = gradeDAO.deleteGrade(stu_no);
		
		if(del_chk != 0){
			chk = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return chk;	
	}
}
