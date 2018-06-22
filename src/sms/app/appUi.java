package sms.app;

import java.util.Scanner;
import sms.action.Action;
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
				System.exit(0);
				break;
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
			case 1 :
//				action = new stuAddAction();
				break;
			case 2 :
				break;
			case 3 :
				break;
			case 4 :
				break;
			case 5 :
				break;
			case 6 :
				return;
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
			case 1 :
				break;
			case 2 :
				break;
			case 3 :
				break;
			case 4 :
				break;
			case 5 :
				break;
			case 6 :
				return;
			}
		}
	}
}