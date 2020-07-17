package database.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**
 * JDBC快速入门
 */

public class JDBC_test_1 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver"); //实际上写不写无所谓，新版本会自动加载
        //3.获取数据库连接对象
//        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/java", "root", "wdh5201314");
        Connection conn = DriverManager.getConnection( "jdbc:mysql:///java", "root", "wdh5201314");
        //4.定义Sql有语句
        String sqlUpdate = "update account set balance = 500 where name = 'lisi' ";
        //5.获取执行SQL对象 Statement；
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count  = stmt.executeUpdate(sqlUpdate); //返回值是影响的行数
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();


    }
}
