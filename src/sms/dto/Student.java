package sms.dto;

public class Student {
	private int stu_no;
	private String stu_name;
	private int stu_year;
	private String stu_addr;
	private String stu_tel;
	private String stu_birth;
	
	@Override
	public String toString() {
		return stu_no+" "+stu_name+" "+stu_year+" "+stu_addr+" "+stu_tel+" "+stu_birth;
	}
	public int getStu_no() {
		return stu_no;
	}

	public void setStu_no(int stu_no) {
		this.stu_no = stu_no;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public int getStu_year() {
		return stu_year;
	}

	public void setStu_year(int stu_year) {
		this.stu_year = stu_year;
	}

	public String getStu_addr() {
		return stu_addr;
	}

	public void setStu_addr(String stu_addr) {
		this.stu_addr = stu_addr;
	}

	public String getStu_tel() {
		return stu_tel;
	}

	public void setStu_tel(String stu_tel) {
		this.stu_tel = stu_tel;
	}

	public String getStu_birth() {
		return stu_birth;
	}

	public void setStu_birth(String stu_birth) {
		this.stu_birth = stu_birth;
	}

	public Student(int stu_no, String stu_name, int stu_year, String stu_addr, String stu_tel, String stu_birth) {
		super();
		this.stu_no = stu_no;
		this.stu_name = stu_name;
		this.stu_year = stu_year;
		this.stu_addr = stu_addr;
		this.stu_tel = stu_tel;
		this.stu_birth = stu_birth;
	}
	
	public Student(int stu_no, String stu_name, int stu_year, String stu_addr, String stu_tel) {
		super();
		this.stu_no = stu_no;
		this.stu_name = stu_name;
		this.stu_year = stu_year;
		this.stu_addr = stu_addr;
		this.stu_tel = stu_tel;
		this.stu_birth = stu_birth;
	}

}
