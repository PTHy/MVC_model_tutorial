package sms.service;

import static sms.db.JDBCUtil.close;
import static sms.db.JDBCUtil.commit;
import static sms.db.JDBCUtil.getConnection;
import static sms.db.JDBCUtil.rollback;

import java.sql.Connection;

import sms.dto.Student;
import sms.model.StudentDAO;

public class StudentDeleteService {
	
	public boolean Delete(int stu_no) {
		Connection con = getConnection();
		StudentDAO stuDAO = new StudentDAO(con);
		boolean chk = false;
		int del_chk = stuDAO.deleteStudent(stu_no);
		
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
