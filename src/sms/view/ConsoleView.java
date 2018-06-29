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
		System.out.println("> 이미 등록된 학생입니다.");
	}
	
	public void showAllStudents(ArrayList<Student> students) {
		int cnt = 1;
		System.out.println("\n> 총"+students.size()+"명의 학생을 조회합니다.");
		System.out.println("    학번        이름        학년        주소                전화번호        생년월일");
		
		for(Student student : students) {
			System.out.println(cnt+"."+student.getStu_no()+" "+student.getStu_name()+" "+student.getStu_year()+" "+student.getStu_addr()+" "+student.getStu_tel()+" "+student.getStu_birth()+" ");
			cnt++;
		}
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
		System.out.println("> 학번 : "+newStudent.getStu_no()+" 학생의 정보가 등록되었습니다.");
	}

	public void printAddFail(Student newStudent) {
		// TODO Auto-generated method stub
		System.out.println("> 학번 : "+newStudent.getStu_no()+" 학생의 정보가 등록이 실패했습니다.");
	}
	
	public void printUnfitForm(String unfitForm) {
		System.out.println("> 생년월일: "+unfitForm+" 이 형식에 맞지 않습니다."
				+ "(예시: 2001-01-01)");
	}
	
	public void studentNotFound() {
		System.out.println("> 찾는 학생이 존재하지 않습니다.");
	}

	public void printDeleteSuccess(int stu_no) {
		System.out.println("> 학번 : "+stu_no+" 학생의 정보가 삭제되었습니다.");
	}

	public void printDeleteFail(int stu_no) {
		System.out.println("> 학번 : "+stu_no+" 학생의 정보가 삭제에 실패하였습니다.");
	}

	public void printModifySuccess(Student student) {
		System.out.println("> 학번 : "+student.getStu_no()+" 학생의 정보가 수정되었습니다.");
	}

	public void printModifyFail(Student student) {
		System.out.println("> 학번 : "+student.getStu_no()+" 학생의 정보가 수정에 실패하였습니다.");
	}

	public void printAddSuccessGrade(Grade newGrade) {
		System.out.println("> 학번 : "+newGrade.getStu_no()+" 학생의 성적이 등록되었습니다");
	}
	
	public void printAddFailGrade(Grade newGrade) {
		System.out.println("> 학번 : "+newGrade.getStu_no()+" 학생의 성적이 등록에 실패하였습니다");
	}


	public Grade addNewGrade(int stu_no, Scanner sc) {
		sc.useDelimiter(System.getProperty("line.separator"));
		
		System.out.println("\n> 새로운 성적정보 입력\n");
		System.out.print("> 국어:");
		int grade_kor = sc.nextInt();
		System.out.println("> 수학:");
		int grade_math = sc.nextInt();
		System.out.println("> 영어:");
		int grade_eng = sc.nextInt();
		
		return new Grade(stu_no, grade_kor, grade_eng, grade_math);
	}

	public void printRegistedGrade(int stu_no) {
		System.out.println("> 이미 등록된 학생입니다.");
	}

	public void showAllGrades(ArrayList<Grade> grades) {
		int cnt = 1;
		System.out.println("\n> 총"+grades.size()+"명의 학생의 성적을 조회합니다.");
		System.out.println("    학번        국어        영어        수학");
		
		for(Grade grade : grades) {
			System.out.println(cnt+"."+grade.getStu_no()+" "+grade.getGrade_kor()+" "+grade.getGrade_eng()+" "+grade.getGrade_math());
			cnt++;
		}
	}

	public void printModifySuccessGrade(Grade grade) {
		System.out.println("> 학번 : "+grade.getStu_no()+" 학생의 정보가 수정되었습니다.");
	}

	public void printModifyFailGrade(Grade grade) {
		System.out.println("> 학번 : "+grade.getStu_no()+" 학생의 정보가 수정에 실패하였습니다.");
	}

	public void printDeleteSuccessGrade (int stu_no) {
		System.out.println("> 학번 : "+stu_no+" 학생의 성적 정보가 삭제되었습니다.");
	}

	public void printDeleteFailGrade(int stu_no) {
		System.out.println("> 학번 : "+stu_no+" 학생의 성적 정보가 삭제에 실패하였습니다.");
	}
}
