package sms.action;

import java.util.Scanner;

import sms.dto.Student;
import sms.service.StudentAddService;
import sms.service.StudentDeleteService;
import sms.service.StudentModifyService;
import sms.view.ConsoleView;

public class stuModifyAction implements Action{

	ConsoleView view = new ConsoleView();
	StudentModifyService stuModifyService = new StudentModifyService();
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
		Student newStudent = view.addNewStudent(stu_no, sc);
		
		//��¥����üũ
		String unfitForm = stuAddService.compareBirthForm(newStudent);
		
		if(unfitForm != null){
			view.printUnfitForm(unfitForm);
			return;
		}
		
		boolean isRegistStudent = stuModifyService.ModifyStudent(newStudent);
		
		if(isRegistStudent){
			view.printModifySuccess(newStudent);
		}else {
			view.printModifyFail(newStudent);
		}
	}
}
