package sms.service;

import static sms.db.JDBCUtil.close;
import static sms.db.JDBCUtil.commit;
import static sms.db.JDBCUtil.getConnection;
import static sms.db.JDBCUtil.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

import sms.dto.Grade;
import sms.model.GradeDAO;
import sms.model.StudentDAO;

public class GradeModifyService {

	public boolean ModifyStudent(Grade newGrade) {
		boolean chk = false;
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		
		//수정된 행수를 받아옴
		int ModifyCount = gradeDAO.ModifyStudent(newGrade);
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
