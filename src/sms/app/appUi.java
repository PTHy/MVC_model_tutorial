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
			System.out.println("----------<�л��������� �ý���>----------");
			System.out.println("          1. �л����� ����");
			System.out.println("          2. �������� ����");
			System.out.println("          3. ���α׷� ����");
			System.out.print("      ����:");
			input = sc.nextInt();
			
			if(input > 3 || input < 1)
				System.out.println("�߸��� �Է��Դϴ�.");
			switch(input) {
			case 1 :
				showStudentMenu();
				break;
			case 2 :
				showGradeMenu();
				break;
			case 3 :
				System.out.println("���α׷��� �����մϴ�...");
				System.exit(0);
				break;
			default :
				System.out.println("�߸��� �Է��Դϴ�");
			}
		}
	}
	
	public static void showStudentMenu() {
		while(true) {
			System.out.println("----------<�л� ����>----------");
			System.out.println("          1. �л����� �Է�");
			System.out.println("          2. �л����� ��ȸ");
			System.out.println("          3. �л����� �˻�");
			System.out.println("          4. �л����� ����");
			System.out.println("          5. �л����� ����");
			System.out.println("          6. ù ȭ������");
			System.out.print("      ����:");
			input = sc.nextInt();
			
			if(input > 6 || input < 1)
				System.out.println("�߸��� �Է��Դϴ�.");
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
				System.out.println("ù ȭ������ �����ϴ�.");
				return;
			default :
				System.out.println("�߸��� �Է��Դϴ�");
			}
			if(action != null) {
				stuController.requestProcess(action, sc);
			}
		}
	}
	
	public static void showSearchMenu() {
		while(true) {
			System.out.println("----------<�л����� �˻�>----------");
			System.out.println("          1. �̸����� �˻�");
			System.out.println("          2. �й����� �˻�");
			System.out.println("          3. �г����� �˻�");
			System.out.println("          4. �˻� ���");
			System.out.print("      ����:");
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
				System.out.println("�˻��� ����մϴ�.");
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
			}
			if(action != null) {
				stuController.requestProcess(action, sc);
			}
		}
	}
	
	public static void showGradeMenu() {
		while(true) {
			System.out.println("----------<�л��������� �ý���>----------");
			System.out.println("          1. �������� �Է�");
			System.out.println("          2. �������� ��ȸ");
			System.out.println("          3. �������� �˻�");
			System.out.println("          4. �������� ����");
			System.out.println("          5. �������� ����");
			System.out.println("          6. ù ȭ������");
			System.out.print("      ����:");
			input = sc.nextInt();
			
			if(input > 6 || input < 1)
				System.out.println("�߸��� �Է��Դϴ�.");
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
				System.out.println("ù ȭ������ �����ϴ�.");
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				return;
			}
			if(action != null) {
				stuController.requestProcess(action, sc);
			}
		}
	}
}
