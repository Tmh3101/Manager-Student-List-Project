package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Province;
import model.Student;

public class StudentDAO implements DAOInterface<Student>{

    public static StudentDAO getInstance(){
        return new StudentDAO();
    }

    @SuppressWarnings("deprecation")
    public int insert(Student s){
        int res = 0;    

        try {
            //step 1: create connection
            Connection con = JDBCUtil.getConnection();

            //step 2: create statement object
            String sql = "INSERT INTO student VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s.getId());
            pst.setString(2, s.getFullname());
            pst.setString(3, s.getBirthPlace().getName());
            pst.setDate(4, new Date(s.getBirthDay().getYear(), s.getBirthDay().getMonth(), s.getBirthDay().getDate()));
            pst.setBoolean(5, s.isSex_isMale());
            pst.setDouble (6, s.getScore1());
            pst.setDouble(7, s.getScore2());
            pst.setDouble(8, s.getScore3());

            //step 3: execute sql command
            res = pst.executeUpdate();

            //step 4: handle result
            System.out.println("there are/is " + res + " change line(s)");

            //step 5: disconnect
            JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    @SuppressWarnings("deprecation")
    public int update(Student s){
        int res = 0;    

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "UPDATE student SET"
                        + " fullname = ?,"
                        + " birthPlace = ?,"
                        + " birthDay = ?,"
                        + " sex_isMale = ?,"
                        + " score1 = ?,"
                        + " score2 = ?,"
                        + " score3 = ?"
                        + " WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s.getFullname());
            pst.setString(2, s.getBirthPlace().getName());
            pst.setDate(3, new Date(s.getBirthDay().getYear(), s.getBirthDay().getMonth(), s.getBirthDay().getDate()));
            pst.setBoolean(4, s.isSex_isMale());
            pst.setDouble (5, s.getScore1());
            pst.setDouble(6, s.getScore2());
            pst.setDouble(7, s.getScore3());
            pst.setString(8, s.getId());

            res = pst.executeUpdate();

            System.out.println("there are/is " + res + " change line(s)");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    public int delete(Student s){
        int res = 0;    

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "DELETE FROM student WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s.getId());

            res = pst.executeUpdate();

            System.out.println("there are/is " + res + " change line(s)");

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    @SuppressWarnings("deprecation")
    public ArrayList<Student> selectAll(){
        ArrayList<Student> res = new ArrayList<Student>();    

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM student";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                res.add(new Student(rs.getString(1),
                                    rs.getString(2),
                                    new Province(rs.getString(3)),
                                    new java.util.Date(rs.getDate(4).getYear(),
                                                        rs.getDate(4).getMonth(),
                                                        rs.getDate(4).getDate()),
                                    rs.getBoolean(5),
                                    rs.getDouble(6),
                                    rs.getDouble(7),
                                    rs.getDouble(8)));
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    @SuppressWarnings("deprecation")
    public Student selectById(Student s){
        Student res = null;    

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM student WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, s.getId());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                res = new Student(rs.getString(1),
                                    rs.getString(2),
                                    new Province(rs.getString(3)),
                                    new java.util.Date(rs.getDate(4).getYear(),
                                                        rs.getDate(4).getMonth(),
                                                        rs.getDate(4).getDate()),
                                    rs.getBoolean(5),
                                    rs.getDouble(6),
                                    rs.getDouble(7),
                                    rs.getDouble(8));
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    @SuppressWarnings("deprecation")
    public ArrayList<Student> selectByCondition(String condition){
        ArrayList<Student> res = new ArrayList<Student>();    

        try {
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM student " + condition;
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                res.add(new Student(rs.getString(1),
                                    rs.getString(2),
                                    new Province(rs.getString(3)),
                                    new java.util.Date(rs.getDate(4).getYear(),
                                                        rs.getDate(4).getMonth(),
                                                        rs.getDate(4).getDate()),
                                    rs.getBoolean(5),
                                    rs.getDouble(6),
                                    rs.getDouble(7),
                                    rs.getDouble(8)));
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
}
