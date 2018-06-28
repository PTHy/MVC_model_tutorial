package sms.action;

import java.util.ArrayList;
import java.util.Scanner;

import sms.dto.Grade;
import sms.dto.Student;
import sms.service.GradeSearchService;
import sms.view.ConsoleView;

public class gradeSearchAction implements Action{
	
	ConsoleView view = new ConsoleView();
	GradeSearchService gradeSearchService = new GradeSearchService();
	
	@Override
	public void execute(Scanner sc) throws Exception {
		int stu_no = Integer.parseInt(view.getStudentNo(sc, "검색할 학번"));
		
		ArrayList<Grade> grades = gradeSearchService.Search(stu_no);
		
		if(grades.isEmpty()) {
			view.studentNotFound();
			return;
		}
		
		view.showAllGrades(grades);
	}
}
