package jdbc.connection;

import java.sql.*;
import java.util.Scanner;

public class JDBC_test_9 {
    public static void main(String[] args) {
        String username = null;
        String password = null;
        // 键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("输入账户：");
        username = sc.nextLine();
        System.out.println("输入密码：");
        password = sc.nextLine();

        // 调用方法
//        boolean flag = new JDBC_test_9().loginStatement(username, password);
        boolean flag = new JDBC_test_9().loginPreparedStatement(username, password);
        // 判断结果
        if (flag) {
            System.out.println("successful");
        }else {
            System.out.println("lose");
        }
        sc.close();
    }

    /**
     * 登录方法
     */

    // sql注入
    public boolean loginStatement(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        String sqLogin = "select * from user where username = '" + username + "' and password = '" + password + "'";
        try {
            conn = JDBCUtils.getConnection();
            stat = conn.createStatement();
            res = stat.executeQuery(sqLogin);
            return res.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, stat, conn);
        }
        return false;
    }

    // 避免sql注入
    public boolean loginPreparedStatement(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement pstat = null; //使用PreparedStatement防止sql注入
        ResultSet res = null;
        String sqLogin = "select * from user where username = ? and password = ?";
        try {
            //获取对象
            conn = JDBCUtils.getConnection();
            pstat = conn.prepareStatement(sqLogin);
            //给？赋值
            pstat.setString(1,username);
            pstat.setString(2,password);
            res = pstat.executeQuery();
            return res.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(res, pstat, conn);
        }
        return false;
    }

}
