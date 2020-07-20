package datasource.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;


import javax.sql.DataSource;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataSourceUtils {
    private static DataSource dataSource = null;
    private static Connection connection = null;


    static {
        Properties properties = new Properties();
        try {
            properties.load(DataSourceUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            System.out.println(properties.getProperty("username"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {

        return dataSource;
    }

    public static Connection getConnection() {

        try {
            connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}


