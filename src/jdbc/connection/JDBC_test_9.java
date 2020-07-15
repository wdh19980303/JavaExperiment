package jdbc.connection;

import java.sql.*;
import java.util.Scanner;

public class JDBC_test_9 {
    public static void main(String[] args) {
        String username = null;
        String password = null;
        // ����¼��
        Scanner sc = new Scanner(System.in);
        System.out.println("�����˻���");
        username = sc.nextLine();
        System.out.println("�������룺");
        password = sc.nextLine();

        // ���÷���
//        boolean flag = new JDBC_test_9().loginStatement(username, password);
        boolean flag = new JDBC_test_9().loginPreparedStatement(username, password);
        // �жϽ��
        if (flag) {
            System.out.println("successful");
        }else {
            System.out.println("lose");
        }
        sc.close();
    }

    /**
     * ��¼����
     */

    // sqlע��
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

    // ����sqlע��
    public boolean loginPreparedStatement(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement pstat = null; //ʹ��PreparedStatement��ֹsqlע��
        ResultSet res = null;
        String sqLogin = "select * from user where username = ? and password = ?";
        try {
            //��ȡ����
            conn = JDBCUtils.getConnection();
            pstat = conn.prepareStatement(sqLogin);
            //������ֵ
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
