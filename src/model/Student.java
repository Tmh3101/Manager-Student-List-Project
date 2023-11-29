package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String name;
	private Province birthPlace;
	private Date birthDay;
	private boolean sex_isMale;
	private float score_1, score_2, score_3;
	
	public Student() {
		code = new String();
		name = new String();
		birthPlace = new Province();
		birthDay = new Date();
		sex_isMale = true;
		score_1 = -1;
		score_2 = -1;
		score_3 = -1;
	}

	public Student(String code, String name, Province birthPlace, Date birthDay, boolean sex_isMale, float score_1, float score_2, float score_3) {
		this.code = code;
		this.name = name;
		this.birthPlace = new Province(birthPlace);
		this.birthDay = birthDay;
		this.sex_isMale = sex_isMale;
		this.score_1 = score_1;
		this.score_2 = score_2;
		this.score_3 = score_3;
	}

	public Student(Student student) {
		code = student.code;
		name = student.name;
		birthPlace = student.birthPlace;
		birthDay = student.birthDay;
		sex_isMale = student.sex_isMale;
		score_1 = student.score_1;
		score_2 = student.score_2;
		score_3 = student.score_3;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public float getScore_1() {
		return score_1;
	}

	public void setScore_1(float score_1) {
		this.score_1 = score_1;
	}

	public float getScore_2() {
		return score_2;
	}

	public void setScore_2(float score_2) {
		this.score_2 = score_2;
	}

	public float getScore_3() {
		return score_3;
	}

	public void setScore_3(float score_3) {
		this.score_3 = score_3;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDay, birthPlace, code, name, score_1, score_2, score_3, sex_isMale);
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
				&& code == other.code && Objects.equals(name, other.name)
				&& Float.floatToIntBits(score_1) == Float.floatToIntBits(other.score_1)
				&& Float.floatToIntBits(score_2) == Float.floatToIntBits(other.score_2)
				&& Float.floatToIntBits(score_3) == Float.floatToIntBits(other.score_3)
				&& sex_isMale == other.sex_isMale;
	}

	@Override
	public String toString() {
		return "Student [code=" + code + ", name=" + name + ", birthPlace=" + birthPlace + ", birthDay=" + birthDay
				+ ", sex_isMale=" + sex_isMale + ", score_1=" + score_1 + ", score_2=" + score_2 + ", score_3="
				+ score_3 + "]";
	}
	
	
	public void edit(Student student) {
		code = student.code;
		name = student.name;
		birthPlace = student.birthPlace;
		birthDay = student.birthDay;
		sex_isMale = student.sex_isMale;
		score_1 = student.score_1;
		score_2 = student.score_2;
		score_3 = student.score_3;
	}
	
}
