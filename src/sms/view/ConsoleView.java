package sms.view;

import java.util.Scanner;

import sms.dto.Student;

public class ConsoleView {
	
	public int getStudentNo(Scanner sc, String msg) {
		System.out.println("\n> "+msg+" : ");
		return sc.nextInt();
	}

	public void printRegistedStudent(int stu_no) {
		System.out.println("�̹� ��ϵ� �л��Դϴ�.");
	}

	public Student addNewStudent(int stu_no, Scanner sc) {
		
		sc.useDelimiter(System.getProperty("line.separator"));
		
		System.out.println("\n> ���ο� �л����� �Է�\n");
		System.out.print("> �̸�:");
		String stu_name = sc.next();
		System.out.println("> �г�:");
		int stu_year = sc.nextInt();
		System.out.println("> �ּ�:");
		String stu_addr = sc.next();
		System.out.println("> ��ȭ��ȣ:");
		String stu_tel = sc.next();
		System.out.println("> �������");
		String stu_birth = sc.next();
		
		return new Student(stu_no, stu_name, stu_year, stu_addr, stu_tel,stu_birth);
	}

	public void printAddSuccess(Student newStudent) {
		System.out.println("�й� "+newStudent.getStu_no()+" �л��� ������ ��ϵǾ����ϴ�.");
	}

	public void printAddFail(Student newStudent) {
		// TODO Auto-generated method stub
		System.out.println("�й� "+newStudent.getStu_no()+" �л��� ������ ����� �����߽��ϴ�.");
	}
	
	public void printUnfitForm(String unfitForm) {
		System.out.println("> �������: "+unfitForm+" �� ���Ŀ� ���� �ʽ��ϴ�."
				+ "(����: 2001-01-01)");
	}
}
