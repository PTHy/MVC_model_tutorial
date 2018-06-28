package sms.service;

import static sms.db.JDBCUtil.close;
import static sms.db.JDBCUtil.commit;
import static sms.db.JDBCUtil.getConnection;
import static sms.db.JDBCUtil.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

import sms.dto.Student;
import sms.model.StudentDAO;

public class StudentModifyService {
	
	public boolean ModifyStudent(Student newStudent) {
		boolean chk = false;
		Connection con = getConnection();
		StudentDAO stuDAO = new StudentDAO(con);
		Date birth = null;
		
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long time = sdf.parse(newStudent.getStu_birth()).getTime();
			birth = new Date(time);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//수정된 행수를 받아옴
		int ModifyCount = stuDAO.ModifyStudent(newStudent, birth);
		if(ModifyCount>0) {
			chk = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return chk;
	}
}	
