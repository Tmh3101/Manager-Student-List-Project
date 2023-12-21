package database;

import java.sql.Connection;
import java.sql.DriverManager;
//import com.mysql.jdbc.Driver;

public class JDBCUtil {
    
    public static Connection getConnection(){
        Connection c = null;
        try {
            
            //DriverManager.registerDriver(new Driver());
            
            String url = "jdbc:mySQL://localhost:3306/manager_student_list";
            String name = "root";
            String password = "";
            c = DriverManager.getConnection(url, name, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }


    public static void closeConnection(Connection c){
        try {
            if(c != null) c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
