package sms.action;

import java.util.Scanner;
import sms.service.*;
import sms.view.ConsoleView;
import sms.dto.Student;



public class stuDeleteAction implements Action{

	ConsoleView view = new ConsoleView();
	StudentDeleteService stuDeleteService = new StudentDeleteService();
	StudentAddService stuAddService = new StudentAddService();
	
	@Override
	public void execute(Scanner sc) throws Exception {
		int stu_no = view.getStudentNo(sc, "������ �л�");
		boolean isExit = stuAddService.searchStudent(stu_no);
		
		if(!isExit) {
			view.studentNotFound();
			return;
		}
		boolean chk = stuDeleteService.Delete(stu_no);
		
		if(chk) {
			view.printDeleteSuccess(stu_no);
			return;
		}else {
			view.printDeleteFail(stu_no);
			return;
		}
	}
}
