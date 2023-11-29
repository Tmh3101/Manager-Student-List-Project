package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ManagerListModel {
	private ProvinceList provinceList;
	private ArrayList<Student> studentList;
	private String curentFileName;
	
	public ManagerListModel() {
		provinceList = new ProvinceList();
		studentList = new ArrayList<Student>();
		curentFileName =  new String();
	}

	public ManagerListModel(ArrayList<Student> studentList) {
		provinceList = new ProvinceList();
		this.studentList = studentList;
		curentFileName =  new String();
	}

	public ProvinceList getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(ProvinceList provinceList) {
		this.provinceList = provinceList;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public String getCurentFileName() {
		return curentFileName;
	}

	public void setCurentFileName(String curentFileName) {
		this.curentFileName = curentFileName;
	}

	public void insert(Student student) {
		studentList.add(student);
	}
	
	public void delete(int i) {
		studentList.remove(i);
	}
	
	public void delete(Student student) {
		studentList.remove(student);
	}
	
	public boolean isDuplicate(String code) {
		for (Student st : studentList) {
			if(st.getCode().equals(code)) return true;
		}
		return false;
	}
	
	public int getIndexOf(Student student) {
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).equals(student)) return i;
		}
		return -1;
	}
	
	public void removeStudent(Student student) {
		studentList.remove(student);
	}
	
	public void saveStudentListToFile(File file) {
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			for (Student student : studentList) {
				oos.writeObject(student);
			}
			oos.flush();
			oos.close();

			
		} catch(Exception e) {
			e.printStackTrace();
		}
		curentFileName = file.getAbsolutePath();
	}
	
	public void loadStudentListFromFile(File file) {
		try {
			
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			while(is.available() > 0) {
				studentList.add((Student)ois.readObject());
			}
			ois.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		curentFileName = file.getAbsolutePath();
	}
	
	
}
