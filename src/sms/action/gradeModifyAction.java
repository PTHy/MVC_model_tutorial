package sms.action;

import java.util.Scanner;

import sms.dto.Grade;
import sms.dto.Student;
import sms.service.GradeModifyService;
import sms.service.StudentAddService;
import sms.service.StudentModifyService;
import sms.view.ConsoleView;

public class gradeModifyAction implements Action{

	ConsoleView view = new ConsoleView();
	GradeModifyService gradeModifyService = new GradeModifyService();
	StudentAddService stuAddService = new StudentAddService();
	
	@Override
	public void execute(Scanner sc) throws Exception {
		//�й� �Է� �ޱ�
		int stu_no = Integer.parseInt(view.getStudentNo(sc,"������ �й�"));
		
		//�й����� ����˻�
		boolean isExit = stuAddService.searchStudent(stu_no);
		if(!isExit) {
			view.studentNotFound();
			return;
		}
		
		//���ο� Ȯ���� view�� ���� �Է¹���
		Grade newGrade = view.addNewGrade(stu_no, sc);

		boolean isRegistStudent = gradeModifyService.ModifyStudent(newGrade);
		
		if(isRegistStudent){
			view.printModifySuccessGrade(newGrade);
		}else {
			view.printModifyFailGrade(newGrade);
		}
	}

}
