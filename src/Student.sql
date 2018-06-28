CREATE TABLE Student(
	stu_no INT NOT NULL,
	stu_name VARCHAR(12) NOT NULL,
	stu_year INT NOT NULL,
	stu_addr VARCHAR(100) NOT NULL,
	stu_tel VARCHAR(20) NOT NULL,
	stu_birth DATE,
	PRIMARY KEY(stu_no)
) default character set utf8 collate utf8_general_ci ;

drop table Student;

CREATE TABLE Grade(
	stu_no INT NOT NULL,
	grade_kor INT NOT NULL,
	grade_eng INT NOT NULL,
	grade_math INT NOT NULL,
	PRIMARY KEY(stu_no),
	CONSTRAINT grade_stu_no_fk
	FOREIGN KEY(stu_no) REFERENCES Student(stu_no) ON DELETE CASCADE
) default character set utf8 collate utf8_general_ci ;

drop table grade;

INSERT INTO Student values (20170001,'김나라',2,'서울특별시 강남구','011-222-1111','2001-05-05');

delete from Student;

INSERT INTO Student values (20170002,'오필승',2,'대구광역시 동구','010-555-2365','2001-12-24');

INSERT INTO Student values (20180001,'오판석',1,'경상남도 창원시','010-878-7979','2002-03-09');

INSERT INTO Grade values (20170001,90,89,90);
INSERT INTO Grade values (20170002,57,68,82);
INSERT INTO Grade values (20180001,100,75,97);

SELECT * FROM Student;