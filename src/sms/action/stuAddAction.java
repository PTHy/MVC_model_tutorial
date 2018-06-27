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
		//학번 입력 받기
		int stu_no = view.getStudentNo(sc,"등록할 학번");
		
		//학번으로 중복검사
		boolean isRegisted = stuAddService.searchStudent(stu_no);
		if(isRegisted) {
			view.printRegistedStudent(stu_no);
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
		
		boolean isRegistStudent = stuAddService.addStudent(newStudent);
		
		if(isRegistStudent){
			view.printAddSuccess(newStudent);
		}else {
			view.printAddFail(newStudent);
		}
	}
}
