package sms.view;

import java.util.Scanner;

import sms.dto.Student;

public class ConsoleView {
	
	public int getStudentNo(Scanner sc, String msg) {
		System.out.println("\n> "+msg+" : ");
		return sc.nextInt();
	}

	public void printRegistedStudent(int stu_no) {
		System.out.println("이미 등록된 학생입니다.");
	}

	public Student addNewStudent(int stu_no, Scanner sc) {
		
		sc.useDelimiter(System.getProperty("line.separator"));
		
		System.out.println("\n> 새로운 학생정보 입력\n");
		System.out.print("> 이름:");
		String stu_name = sc.next();
		System.out.println("> 학년:");
		int stu_year = sc.nextInt();
		System.out.println("> 주소:");
		String stu_addr = sc.next();
		System.out.println("> 전화번호:");
		String stu_tel = sc.next();
		System.out.println("> 생년월일");
		String stu_birth = sc.next();
		
		return new Student(stu_no, stu_name, stu_year, stu_addr, stu_tel,stu_birth);
	}

	public void printAddSuccess(Student newStudent) {
		System.out.println("학번 "+newStudent.getStu_no()+" 학생의 정보가 등록되었습니다.");
	}

	public void printAddFail(Student newStudent) {
		// TODO Auto-generated method stub
		System.out.println("학번 "+newStudent.getStu_no()+" 학생의 정보가 등록이 실패했습니다.");
	}
	
	public void printUnfitForm(String unfitForm) {
		System.out.println("> 생년월일: "+unfitForm+" 이 형식에 맞지 않습니다."
				+ "(예시: 2001-01-01)");
	}
}
