package database.connections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示jdbc工具类
 */
public class JDBC_test_8 {
    public static void main(String[] args) {
        List<Emp> empList = new JDBC_test_8().findAll();
//        System.out.println(emp.getAge() + "___" + emp.getId() + "___" + emp.getId());
        System.out.println(empList);
//        JDBCUtils.getConfig();
    }

    public List<Emp> findAll() {
        int count = 0;
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        List<Emp> listEmp = new ArrayList<Emp>();
        String sqlQuery = "select * from employee";
        Emp emp = null;
        try {
            /*Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///java", "alice", "0000");*/

            conn = JDBCUtils.getConnection();
            stat = conn.createStatement();
            res = stat.executeQuery(sqlQuery);
            while (res.next()) {
                count++;
                int id = res.getInt("id");
                int age = res.getInt("age");
                String name = res.getNString("name");

                //创建emp对象 并赋值
                emp = new Emp();
                emp.setId(id);
                emp.setAge(age);
                emp.setName(name);
                //装载
                listEmp.add(emp);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(res,stat,conn);
            /*if (res != null) {
                try {
                    res.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }


            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }*/

        }
        System.out.println(count);
        return listEmp;
    }
}
