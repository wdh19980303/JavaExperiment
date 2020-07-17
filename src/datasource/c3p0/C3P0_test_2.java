package datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * c3p0 演示
 */
public class C3P0_test_2 {
    public static void main(String[] args) {
        // 1.获取DataSource

        DataSource ds = new ComboPooledDataSource("root"); //使用配置名称选择指定配置
//        DataSource ds = new ComboPooledDataSource();
        // 2. 获取连接
        for (int i = 0; i < 11; i++) {
            try {
                Connection conn = ds.getConnection();
                System.out.println(i + ":" + conn);
                if (i%2 == 1){
                    conn.close();//通过连接池连接数据库，close不是删除，而是归还
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }


}
