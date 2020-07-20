package datasource.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Set;

public class test {
    @Before
    public void start(){
        System.out.println("start");
    }
    @Test
    public void test1() {
        String sql = "select * from account";
        ResultSet resultSet = null;
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, ps, connection);
        }

    }


    @Test
    public void test2() {
        int i = 0;
        do {
            System.out.println(i++);
        } while (i < 5);
    }

    @Test
    public void test4() {
        System.out.println(DataSourceUtils.getConnection());
    }

    @Test
    public void test3() {
        Integer x = Integer.valueOf(9);
        Double c = Double.valueOf(5);
        Float a = Float.valueOf("80");

        Integer b = Integer.valueOf("444", 16);   // 使用 16 进制

        /*System.out.println(x);
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);*/
        System.out.println(4 * 16 * 16 + 4 * 16 + 4);
    }

    @After
    public void ending(){
        System.out.println("ending");
    }
}
