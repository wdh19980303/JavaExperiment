package datasource.template;

import datasource.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate入门
 */
public class Template_test_1 {
    public static void main(String[] args) {
        // 1.导入jar包
        // 2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        // 3.调用方法
        String sqlUpdate = "insert into account values(null,?,?)";
        int count = template.update(sqlUpdate, "Tom.Fisher", 5000); //会返回一个影响的行数
        if (count != 0) {
            System.out.println("successful affect : " + count);
        } else {
            System.out.println("lose");
        }
        // 不需要释放连接 template内部封装了这些方法
        //
    }


}
