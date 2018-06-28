package sms.action;

import java.util.Scanner;
import sms.service.*;
import sms.view.ConsoleView;
import sms.dto.Grade;

public class gradeAddAction implements Action{
	
	ConsoleView view = new ConsoleView();
	GradeAddService gradeAddService = new GradeAddService();
	
	@Override
	public void execute(Scanner sc) throws Exception {
		//학번 입력 받기
		int stu_no = Integer.parseInt(view.getStudentNo(sc,"등록할 학번"));
		
		//학번으로 중복검사
		boolean isRegisted = gradeAddService.searchGrade(stu_no);
		
		if(isRegisted) {
			view.printRegistedGrade(stu_no);
			return;
		}
		
		//새로운 확생을 view를 통해 입력받음
		Grade newGrade = view.addNewGrade(stu_no, sc);
		
		boolean isRegistGrade = gradeAddService.addGrade(newGrade);
		
		
		
		if(isRegistGrade){
			view.printAddSuccessGrade(newGrade);
		}else {
			view.printAddFailGrade(newGrade);
		}
	}
}
