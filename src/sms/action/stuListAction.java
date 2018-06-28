package sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import sms.dto.Student;
import sms.service.StudentAddService;
import sms.service.StudentListService;
import sms.view.ConsoleView;

public class stuListAction implements Action{

	ConsoleView view = new ConsoleView();
	StudentListService stuListService = new StudentListService();

	@Override
	public void execute(Scanner sc) throws Exception {
		
		ArrayList<Student> students = stuListService.Find();
		if(students.isEmpty()) {
			view.studentNotFound();
			return;
		}
		
		view.showAllStudents(students);
	}
}
