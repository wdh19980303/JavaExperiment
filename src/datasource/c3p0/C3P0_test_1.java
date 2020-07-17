package datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0演示
 */
public class C3P0_test_1 {
    public static void main(String[] args) {
        // 1. 创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        // 2. 获取连接对象
        try {
            Connection conn = ds.getConnection();
            System.out.println("-----------");
            System.out.println(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
