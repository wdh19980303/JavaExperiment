package datasource.template;

import datasource.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class Template_test_2 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sqlUpdate = "update account set name = ? where name = ? ";

        if (template.update(sqlUpdate, "Sam.Fisher", "Tom.Fisher") != 0) {
            System.out.println("update successful");
        } else {
            System.out.println("lose");
        }
    }
}
