package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private Province birthPlace;
	private Date birthDay;
	private boolean sex_isMale;
	private float score1, score2, score3;
	
	public Student() {
		id = new String();
		name = new String();
		birthPlace = new Province();
		birthDay = new Date();
		sex_isMale = true;
		score1 = 0;
		score2 = 0;
		score3 = 0;
	}

	public Student(String code, String name, Province birthPlace, Date birthDay, boolean sex_isMale, float score1, float score2, float score3) {
		this.id = code;
		this.name = name;
		this.birthPlace = new Province(birthPlace);
		this.birthDay = birthDay;
		this.sex_isMale = sex_isMale;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
	}

	public Student(Student student) {
		id = student.id;
		name = student.name;
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

	public float getScore1() {
		return score1;
	}

	public void setScore1(float score1) {
		this.score1 = score1;
	}

	public float getScore2() {
		return score2;
	}

	public void setScore2(float score2) {
		this.score2 = score2;
	}

	public float getScore3() {
		return score3;
	}

	public void setScore_3(float score3) {
		this.score3 = score3;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDay, birthPlace, id, name, score1, score2, score3, sex_isMale);
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
				&& id == other.id && Objects.equals(name, other.name)
				&& Float.floatToIntBits(score1) == Float.floatToIntBits(other.score1)
				&& Float.floatToIntBits(score2) == Float.floatToIntBits(other.score2)
				&& Float.floatToIntBits(score3) == Float.floatToIntBits(other.score3)
				&& sex_isMale == other.sex_isMale;
	}

	@Override
	public String toString() {
		return "Student [ID=" + id + ", name=" + name + ", birthPlace=" + birthPlace + ", birthDay=" + birthDay
				+ ", sex_isMale=" + sex_isMale + ", score1=" + score1 + ", score2=" + score2 + ", score3="
				+ score3 + "]";
	}
	
	
	public void edit(Student student) {
		id = student.id;
		name = student.name;
		birthPlace = student.birthPlace;
		birthDay = student.birthDay;
		sex_isMale = student.sex_isMale;
		score1 = student.score1;
		score2 = student.score2;
		score3 = student.score3;
	}
	
}
