package sms.view;

import java.util.ArrayList;
import java.util.Scanner;

import sms.dto.Grade;
import sms.dto.Student;

public class ConsoleView {
	
	public String getStudentNo(Scanner sc, String msg) {
		System.out.println("\n> "+msg+" : ");
		return sc.next();
	}

	public void printRegistedStudent(int stu_no) {
		System.out.println("> �̹� ��ϵ� �л��Դϴ�.");
	}
	
	public void showAllStudents(ArrayList<Student> students) {
		int cnt = 1;
		System.out.println("\n> ��"+students.size()+"���� �л��� ��ȸ�մϴ�.");
		System.out.println("    �й�        �̸�        �г�        �ּ�                ��ȭ��ȣ        �������");
		
		for(Student student : students) {
			System.out.println(cnt+"."+student.getStu_no()+" "+student.getStu_name()+" "+student.getStu_year()+" "+student.getStu_addr()+" "+student.getStu_tel()+" "+student.getStu_birth()+" ");
			cnt++;
		}
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
		System.out.println("> �й� : "+newStudent.getStu_no()+" �л��� ������ ��ϵǾ����ϴ�.");
	}

	public void printAddFail(Student newStudent) {
		// TODO Auto-generated method stub
		System.out.println("> �й� : "+newStudent.getStu_no()+" �л��� ������ ����� �����߽��ϴ�.");
	}
	
	public void printUnfitForm(String unfitForm) {
		System.out.println("> �������: "+unfitForm+" �� ���Ŀ� ���� �ʽ��ϴ�."
				+ "(����: 2001-01-01)");
	}
	
	public void studentNotFound() {
		System.out.println("> ã�� �л��� �������� �ʽ��ϴ�.");
	}

	public void printDeleteSuccess(int stu_no) {
		System.out.println("> �й� : "+stu_no+" �л��� ������ �����Ǿ����ϴ�.");
	}

	public void printDeleteFail(int stu_no) {
		System.out.println("> �й� : "+stu_no+" �л��� ������ ������ �����Ͽ����ϴ�.");
	}

	public void printModifySuccess(Student student) {
		System.out.println("> �й� : "+student.getStu_no()+" �л��� ������ �����Ǿ����ϴ�.");
	}

	public void printModifyFail(Student student) {
		System.out.println("> �й� : "+student.getStu_no()+" �л��� ������ ������ �����Ͽ����ϴ�.");
	}

	public void printAddSuccessGrade(Grade newGrade) {
		System.out.println("> �й� : "+newGrade.getStu_no()+" �л��� ������ ��ϵǾ����ϴ�");
	}
	
	public void printAddFailGrade(Grade newGrade) {
		System.out.println("> �й� : "+newGrade.getStu_no()+" �л��� ������ ��Ͽ� �����Ͽ����ϴ�");
	}


	public Grade addNewGrade(int stu_no, Scanner sc) {
		sc.useDelimiter(System.getProperty("line.separator"));
		
		System.out.println("\n> ���ο� �������� �Է�\n");
		System.out.print("> ����:");
		int grade_kor = sc.nextInt();
		System.out.println("> ����:");
		int grade_math = sc.nextInt();
		System.out.println("> ����:");
		int grade_eng = sc.nextInt();
		
		return new Grade(stu_no, grade_kor, grade_eng, grade_math);
	}

	public void printRegistedGrade(int stu_no) {
		System.out.println("> �̹� ��ϵ� �л��Դϴ�.");
	}

	public void showAllGrades(ArrayList<Grade> grades) {
		int cnt = 1;
		System.out.println("\n> ��"+grades.size()+"���� �л��� ������ ��ȸ�մϴ�.");
		System.out.println("    �й�        ����        ����        ����");
		
		for(Grade grade : grades) {
			System.out.println(cnt+"."+grade.getStu_no()+" "+grade.getGrade_kor()+" "+grade.getGrade_eng()+" "+grade.getGrade_math());
			cnt++;
		}
	}

	public void printModifySuccessGrade(Grade grade) {
		System.out.println("> �й� : "+grade.getStu_no()+" �л��� ������ �����Ǿ����ϴ�.");
	}

	public void printModifyFailGrade(Grade grade) {
		System.out.println("> �й� : "+grade.getStu_no()+" �л��� ������ ������ �����Ͽ����ϴ�.");
	}
}
