package database.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_test_10 {

    public static void main(String[] args)  {
        Connection conn = null;
        PreparedStatement pStatAdd = null;
        PreparedStatement pStatSub = null;
        String sqlSub = null;
        String sqlAdd = null;

        try {
            // 获取连接
            conn = JDBCUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false); //关闭自动提交，开启手动提交
            // 定义sql连接
            sqlSub = "update account set balance = balance - ? where id = ? ";
            sqlAdd = "update account set balance = balance + ? where id = ? ";

            pStatAdd = conn.prepareStatement(sqlAdd);
            pStatAdd.setInt(2,2);
            pStatAdd.setDouble(1,500);

            // 获取sql执行对象
            pStatSub = conn.prepareStatement(sqlSub);
            pStatSub.setInt(2,3); // 设置参数
            pStatSub.setDouble(1,500);

            pStatAdd.executeUpdate();//执行sql
            int i = 1/0; //手动设置异常
            pStatSub.executeUpdate();
            conn.commit(); //如果没有问题就提交事务

        } catch (Exception throwables) {
            if(conn != null){
                try {
                    conn.rollback();//有异常就回滚事务
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(pStatAdd,null);
            JDBCUtils.close(pStatSub,null);
        }

    }
}
