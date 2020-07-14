package database.connection;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// DML修改记录
public class JDBC_test_3 {
    public static void main(String[] args)  {
        Connection conn = null;
        Statement stat = null;

        try {
            // 1 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///java","alice","0000");
            // 3 定义sql
            String sqlUpdate = "update account set balance = 5000 where balance = 500";
            // 4 获取执行sql对象
            stat = conn.createStatement();
            // 5 处理执行
            int count = stat.executeUpdate(sqlUpdate);
            if (count > 0) {
                System.out.println("successful");
            } else {
                System.out.println("lose");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
