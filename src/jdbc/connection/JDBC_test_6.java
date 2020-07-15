package jdbc.connection;

import java.sql.*;

/**
 * Result 对象使用
 */
public class JDBC_test_6 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;

        try {
            // 1 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///java", "alice", "0000");
            // 3 定义sql
            String sqlQuery = "SELECT * FROM account ";
            // 4 获取执行sql对象
            stat = conn.createStatement();
            // 5 处理执行
            res = stat.executeQuery(sqlQuery);
            // 6 处理结果
            // 6.1 向下移动一行
            res.next();
            // 6.2 获取数据

            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getNString("name");
                double balance = res.getDouble(3);
                System.out.println(id + "______" + name + "______" + balance);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    res.close();
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
