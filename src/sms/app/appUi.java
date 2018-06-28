package sms.app;

import java.util.Scanner;
import sms.action.Action;
import sms.action.*;
import sms.controller.StudentController;

public class appUi{
	static Scanner sc = new Scanner(System.in);
	static int input;
	
	static Action action = null;     						//execute()
	static StudentController stuController = new StudentController();  	 	//requestProcess()
	
	public static void main(String[] args) {
		showMainMenu();
	}
	public static void showMainMenu() {
		while(true) {
			System.out.println("----------<학생정보관리 시스템>----------");
			System.out.println("          1. 학생정보 관리");
			System.out.println("          2. 성적정보 관리");
			System.out.println("          3. 프로그램 종료");
			System.out.print("      선택:");
			input = sc.nextInt();
			
			if(input > 3 || input < 1)
				System.out.println("잘못된 입력입니다.");
			switch(input) {
			case 1 :
				showStudentMenu();
				break;
			case 2 :
				showGradeMenu();
				break;
			case 3 :
				System.out.println("프로그램을 종료합니다...");
				System.exit(0);
				break;
			default :
				System.out.println("잘못된 입력입니다");
			}
		}
	}
	
	public static void showStudentMenu() {
		while(true) {
			System.out.println("----------<학생 관리>----------");
			System.out.println("          1. 학생정보 입력");
			System.out.println("          2. 학생정보 조회");
			System.out.println("          3. 학생정보 검색");
			System.out.println("          4. 학생정보 변경");
			System.out.println("          5. 학생정보 삭제");
			System.out.println("          6. 첫 화면으로");
			System.out.print("      선택:");
			input = sc.nextInt();
			
			if(input > 6 || input < 1)
				System.out.println("잘못된 입력입니다.");
			switch(input) {
			case 1:
				action = new stuAddAction();
				break;
			case 2:
				action = new stuListAction();
				break;
			case 3:
				showSearchMenu();
				break;
			case 4:
				action = new stuModifyAction();
				break;
			case 5:
				action = new stuDeleteAction();
				break;
			case 6 :
				System.out.println("첫 화면으로 나갑니다.");
				return;
			default :
				System.out.println("잘못된 입력입니다");
			}
			if(action != null) {
				stuController.requestProcess(action, sc);
			}
		}
	}
	
	public static void showSearchMenu() {
		while(true) {
			System.out.println("----------<학생정보 검색>----------");
			System.out.println("          1. 이름으로 검색");
			System.out.println("          2. 학번으로 검색");
			System.out.println("          3. 학년으로 검색");
			System.out.println("          4. 검색 취소");
			System.out.print("      선택:");
			input = sc.nextInt();
			switch(input) {
			case 1:
				action = new stuSearchAction(input);
				break;
			case 2:
				action = new stuSearchAction(input);
				break;
			case 3:
				action = new stuSearchAction(input);
				break;
			case 4:
				action = null;
				System.out.println("검색을 취소합니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
			if(action != null) {
				stuController.requestProcess(action, sc);
			}
		}
	}
	
	public static void showGradeMenu() {
		while(true) {
			System.out.println("----------<학생정보관리 시스템>----------");
			System.out.println("          1. 성적정보 입력");
			System.out.println("          2. 성적정보 조회");
			System.out.println("          3. 성적정보 검색");
			System.out.println("          4. 성적정보 변경");
			System.out.println("          5. 성적정보 삭제");
			System.out.println("          6. 첫 화면으로");
			System.out.print("      선택:");
			input = sc.nextInt();
			
			if(input > 6 || input < 1)
				System.out.println("잘못된 입력입니다.");
			switch(input) {
			case 1:
				action = new gradeAddAction();
				break;
			case 2:
				action = new gradeListAction();
				break;
			case 3:
				action = new gradeSearchAction();
				break;
			case 4:
				action = new gradeModifyAction();
				break;
			case 5:
				action = new gradeDeleteAction();
				break;
			case 6:
				System.out.println("첫 화면으로 나갑니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				return;
			}
			if(action != null) {
				stuController.requestProcess(action, sc);
			}
		}
	}
}
