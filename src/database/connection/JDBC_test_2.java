package database.connection;

import org.hamcrest.Condition;
import org.hamcrest.Factory;

import java.sql.*;
import java.util.Collections;

/**
 * 添加一条记录
 */
public class JDBC_test_2 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //定义sql
            String sqlInsert = "insert into account values (4,'Violet',3000 )";
            //获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql:///java", "alice", "0000");
            // 获取执行sql对象
            stat = conn.createStatement();
            // 执行sql
            int count = stat.executeUpdate(sqlInsert);
            if (count > 0) {
                System.out.println("successful");
            } else {
                System.out.println("lose");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //避免空指针异常
            if (stat != null){
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
