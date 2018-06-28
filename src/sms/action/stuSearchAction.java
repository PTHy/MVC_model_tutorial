package sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import sms.dto.Student;
import sms.service.StudentListService;
import sms.service.StudentSearchService;
import sms.view.ConsoleView;

public class stuSearchAction implements Action{
	
	ConsoleView view = new ConsoleView();
	StudentSearchService stuSearchService = new StudentSearchService();
	int type = 0;
	
	public stuSearchAction(int type) {
		this.type = type;
	}

	@Override
	public void execute(Scanner sc) throws Exception {
		String input = null;
		switch(type) {
		case 1 :
			//이름으로 검색
			input  = view.getStudentNo(sc, "검색할 이름");
			break;
		case 2 :
			//학번으로 검색
			input = view.getStudentNo(sc, "검색할 학번");
			break;
		case 3 :
			//학년으로 검색
			input = view.getStudentNo(sc, "검색할 학년");
			break;
		}
		
		ArrayList<Student> students = stuSearchService.Search(type,input);
		
		if(students.isEmpty()) {
			view.studentNotFound();
			return;
		}
		
		view.showAllStudents(students);
	}
	
}
