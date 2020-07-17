package database.connections;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具
 */
public class JDBCUtils {
    /**
     * 获取连接方法，返回连接对象
     *
     * @return 返回连接对象
     */
    private static String path;
    private static String url;
    private static String user;
    private static String password;
//    private static String driver;

    static {
        //读取资源文件，获取值
        //1 创建properties集合类

        Properties configuration = new Properties();
        //2 加载文件
        //使用ClassLoader加载器获取路径，类加载器默认路径是scr下

        /*ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        URL res = classLoader.getResource("jdbc.properties");
        path = res.getPath();*/
//        System.out.println(path);
        try {

            configuration.load(JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
//            configuration.load(new FileReader(path));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        //3 获取数据，赋值
        url = configuration.getProperty("url");
        user = configuration.getProperty("user");
        password = configuration.getProperty("password");

        try {
            Class.forName(configuration.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        JDBCUtils.close(statement, connection);
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void  getConfig(){
        System.out.println(new File(path).exists());
        System.out.println(new File(path).isFile());
        System.out.println(url);
        System.out.println(user);
    }
}
