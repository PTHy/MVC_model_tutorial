package sms.action;

import java.util.Scanner;
import sms.service.*;
import sms.view.ConsoleView;
import sms.dto.Student;

public class stuAddAction implements Action{
	
	ConsoleView view = new ConsoleView();
	StudentAddService stuAddService = new StudentAddService();
	
	@Override
	public void execute(Scanner sc) throws Exception {
		//�й� �Է� �ޱ�
		int stu_no = Integer.parseInt(view.getStudentNo(sc,"����� �й�"));
		
		//�й����� �ߺ��˻�
		boolean isRegisted = stuAddService.searchStudent(stu_no);
		if(isRegisted) {
			view.printRegistedStudent(stu_no);
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
		
		boolean isRegistStudent = stuAddService.addStudent(newStudent);
		
		if(isRegistStudent){
			view.printAddSuccess(newStudent);
		}else {
			view.printAddFail(newStudent);
		}
	}
}
