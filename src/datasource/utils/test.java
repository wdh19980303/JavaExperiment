package datasource.utils;

import org.junit.Test;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Set;

public class test {
    @Test
    public void uu() {
        String sql = "select * from account";
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = DataSourceUtils.getConnection();
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DataSourceUtils.close(resultSet,ps,connection);
        }

    }
}
