package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String fullname;
	private Province birthPlace;
	private Date birthDay;
	private boolean sex_isMale;
	private double score1, score2, score3;
	
	public Student() {
		id = new String();
		fullname = new String();
		birthPlace = new Province();
		birthDay = new Date();
		sex_isMale = true;
		score1 = 0;
		score2 = 0;
		score3 = 0;
	}

	public Student(String code, String fullname, Province birthPlace, Date birthDay, boolean sex_isMale, double score1, double score2, double score3) {
		this.id = code;
		this.fullname = fullname;
		this.birthPlace = new Province(birthPlace);
		this.birthDay = birthDay;
		this.sex_isMale = sex_isMale;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
	}

	public Student(Student student) {
		id = student.id;
		fullname = student.fullname;
		birthPlace = student.birthPlace;
		birthDay = student.birthDay;
		sex_isMale = student.sex_isMale;
		score1 = student.score1;
		score2 = student.score2;
		score3 = student.score3;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Province getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(Province birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public boolean isSex_isMale() {
		return sex_isMale;
	}

	public void setSex_isMale(boolean sex_isMale) {
		this.sex_isMale = sex_isMale;
	}

	public double getScore1() {
		return score1;
	}

	public void setScore1(double score1) {
		this.score1 = score1;
	}

	public double getScore2() {
		return score2;
	}

	public void setScore2(double score2) {
		this.score2 = score2;
	}

	public double getScore3() {
		return score3;
	}

	public void setScore_3(double score3) {
		this.score3 = score3;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDay, birthPlace, id, fullname, score1, score2, score3, sex_isMale);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(birthDay, other.birthDay) && Objects.equals(birthPlace, other.birthPlace)
				&& id == other.id && Objects.equals(fullname, other.fullname)
				&& Double.doubleToLongBits(score1) == Double.doubleToLongBits(other.score1)
				&& Double.doubleToLongBits(score2) == Double.doubleToLongBits(other.score2)
				&& Double.doubleToLongBits(score3) == Double.doubleToLongBits(other.score3)
				&& sex_isMale == other.sex_isMale;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return "[ID=" + id + ", fullname=" + fullname + ", birthPlace=" + birthPlace + ", birthDay=" + birthDay.getDate() + "/" + (birthDay.getMonth() + 1) + "/" + (birthDay.getYear() + 1900)
				+ ", sex_isMale=" + sex_isMale + ", score1=" + score1 + ", score2=" + score2 + ", score3="
				+ score3 + "]";
	}
	
	
	public void edit(Student student) {
		id = student.id;
		fullname = student.fullname;
		birthPlace = student.birthPlace;
		birthDay = student.birthDay;
		sex_isMale = student.sex_isMale;
		score1 = student.score1;
		score2 = student.score2;
		score3 = student.score3;
	}
	
}
