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
		//학번 입력 받기
		int stu_no = Integer.parseInt(view.getStudentNo(sc,"수정할 학번"));
		
		//학번으로 존재검사
		boolean isExit = stuAddService.searchStudent(stu_no);
		if(!isExit) {
			view.studentNotFound();
			return;
		}
		
		//새로운 확생을 view를 통해 입력받음
		Grade newGrade = view.addNewGrade(stu_no, sc);

		boolean isRegistStudent = gradeModifyService.ModifyStudent(newGrade);
		
		if(isRegistStudent){
			view.printModifySuccessGrade(newGrade);
		}else {
			view.printModifyFailGrade(newGrade);
		}
	}

}
