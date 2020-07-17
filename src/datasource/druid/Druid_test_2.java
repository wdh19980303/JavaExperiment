package datasource.druid;

import datasource.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用新的工具类
 */
public class Druid_test_2 {
    /**
     * 给account添加一条记录
     */
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtils.getConnection();
            String sqlAdd = "insert into account values(5,?,?)";

            ps = conn.prepareStatement(sqlAdd);

            ps.setString(1, "YoYo");
            ps.setDouble(2, 5000);

            if (ps.executeUpdate() > 0) {
                System.out.println("successful");
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {

            JDBCUtils.close(ps, conn);

        }
    }
}
