package sms.dto;

public class Grade {
	private int stu_no;
	private int grade_kor;
	private int grade_eng;
	private int grade_math;
	
	@Override
	public String toString() {
		return "학번 : "+stu_no+" 국어 : "+grade_kor+" 영어 : "+grade_eng+" 수학 : "+grade_math+" 합계 : "+sum()+" 평균 : "+avg();
	}

	public int getStu_no() {
		return stu_no;
	}

	public void setStu_no(int stu_no) {
		this.stu_no = stu_no;
	}

	public int getGrade_kor() {
		return grade_kor;
	}

	public void setGrade_kor(int grade_kor) {
		this.grade_kor = grade_kor;
	}

	public int getGrade_eng() {
		return grade_eng;
	}

	public void setGrade_eng(int grade_eng) {
		this.grade_eng = grade_eng;
	}

	public int getGrade_math() {
		return grade_math;
	}

	public void setGrade_math(int grade_math) {
		this.grade_math = grade_math;
	}

	public Grade(int stu_no, int grade_kor, int grade_eng, int grade_math) {
		super();
		this.stu_no = stu_no;
		this.grade_kor = grade_kor;
		this.grade_eng = grade_eng;
		this.grade_math = grade_math;
	}
	
	public int sum() {
		return this.grade_kor+this.grade_eng+this.grade_math;
	}
	
	public float avg() {
		float avg = (float)sum()/3;
		avg = (int)(avg*100+0.5f)/100f;
		return avg;
	}
}	
