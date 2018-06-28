package sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import sms.dto.Grade;
import sms.dto.Student;
import sms.service.GradeListService;
import sms.service.StudentListService;
import sms.view.ConsoleView;

public class gradeListAction implements Action{
	
	ConsoleView view = new ConsoleView();
	GradeListService gradeListService = new GradeListService();
	
	@Override
	public void execute(Scanner sc) throws Exception {
		ArrayList<Grade> grades = gradeListService.Find();
		if(grades.isEmpty()) {
			view.studentNotFound();
			return;
		}
		view.showAllGrades(grades);
	}
	
}
