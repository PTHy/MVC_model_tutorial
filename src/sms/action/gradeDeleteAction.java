package sms.action;

import java.util.Scanner;

import sms.service.GradeAddService;
import sms.service.GradeDeleteService;
import sms.view.ConsoleView;

public class gradeDeleteAction implements Action{

	ConsoleView view = new ConsoleView();
	GradeDeleteService gradeDeleteService = new GradeDeleteService();
	GradeAddService gradeAddService = new GradeAddService();
	
	@Override
	public void execute(Scanner sc) throws Exception {
		int stu_no = Integer.parseInt(view.getStudentNo(sc, "삭제할 학생"));
		boolean isExit = gradeAddService.searchGrade(stu_no);
		
		if(!isExit) {
			view.studentNotFound();
			return;
		}
		
		boolean chk = gradeDeleteService.Delete(stu_no);
		
		if(chk) {
			view.printDeleteSuccessGrade(stu_no);
			return;
		}else {
			view.printDeleteFailGrade(stu_no);
			return;
		}
	}
}
