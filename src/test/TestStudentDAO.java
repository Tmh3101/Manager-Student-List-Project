package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import database.StudentDAO;
import model.Province;
import model.Student;

public class TestStudentDAO {
    public static void main(String[] args) {
        // try {
        //     SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		//     //Date birthDay = df.parse("31/01/2004");
        //     StudentDAO.getInstance().insert(new Student("003", "Tran Quoc Nhu",
        //                                 new Province("Kien Giang"),
        //                                 (Date)df.parse("31/01/2004"),
        //                                 true, 7.0f, 4.0f, 5.0f));
        // } catch (Exception e) {
        //     System.out.println("error");
        //     e.printStackTrace();
        // }

        ArrayList<Student> list = StudentDAO.getInstance().selectByCondition("Where fullname LIKE '%Nhu'");
        for (Student student : list) {
            System.out.println(student);
        }



    }
}
