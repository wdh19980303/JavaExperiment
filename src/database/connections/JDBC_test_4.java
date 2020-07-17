package database.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DML删除
 */
public class JDBC_test_4 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///java", "alice", "0000");
            String sqlDelete = "delete from account where id = 5";
            stat = conn.createStatement();
            int count = stat.executeUpdate(sqlDelete);
            if (count > 0) {
                System.out.println("successful");
            } else {
                System.out.println("lose");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if( stat != null){
                try {
                    stat.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
