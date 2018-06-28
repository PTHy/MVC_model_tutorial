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
		//학번 입력 받기
		int stu_no = Integer.parseInt(view.getStudentNo(sc,"수정할 학번"));
		
		//학번으로 존재검사
		boolean isExit = stuAddService.searchStudent(stu_no);
		if(!isExit) {
			view.studentNotFound();
			return;
		}
		
		//새로운 확생을 view를 통해 입력받음
		Student newStudent = view.addNewStudent(stu_no, sc);
		
		//날짜형식체크
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
