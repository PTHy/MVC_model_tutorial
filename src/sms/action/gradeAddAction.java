package sms.action;

import java.util.Scanner;
import sms.service.*;
import sms.view.ConsoleView;
import sms.dto.Grade;

public class gradeAddAction implements Action{
	
	ConsoleView view = new ConsoleView();
	GradeAddService gradeAddService = new GradeAddService();
	StudentAddService studentAddService = new StudentAddService();
	
	@Override
	public void execute(Scanner sc) throws Exception {
		//�й� �Է� �ޱ�
		int stu_no = Integer.parseInt(view.getStudentNo(sc,"����� �й�"));
		
		//�й����� �ߺ��˻�
		boolean isRegisted = gradeAddService.searchGrade(stu_no);
		
		boolean isExit = studentAddService.searchStudent(stu_no);
		
		if(isRegisted) {
			view.printRegistedGrade(stu_no);
			return;
		}
		
		if(!isExit) {
			view.studentNotFound();
			return;
		}
		
		//���ο� ������ view�� ���� �Է¹���
		Grade newGrade = view.addNewGrade(stu_no, sc);
		
		boolean isRegistGrade = gradeAddService.addGrade(newGrade);
		
		if(isRegistGrade){
			view.printAddSuccessGrade(newGrade);
		}else {
			view.printAddFailGrade(newGrade);
		}
	}
}
