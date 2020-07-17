package datasource.template;

import datasource.utils.JDBCUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Template_test_3 {
    /**
     * Junit单元测试，可以让方法独立执行
     */

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test // 1 .修改Alice的balance为8848,如果没参数可以不加参数
    public void test1() {
        String sqlUpdate = "update account set balance = ? where name = ?";
        if (template.update(sqlUpdate, 8848, "Alice") != 0) {
            System.out.println("successful");
        } else {
            System.out.println("lose");
        }

    }

    @Test // 2 .添加记录，操作是尽可能使用？，避免sql注入
    public void test2() {
        String sqlInsert = "insert account values(null,?,?)";
        if (template.update(sqlInsert, "Cell", 9527) != 0) {
            System.out.println("successful");
        } else {
            System.out.println("lose");
        }
    }

    @Test // 3 .删除语句
    public void test3() {
        String sqlDelete = "delete from account where name = ?";
        if (template.update(sqlDelete, "Cell") != 0) {
            System.out.println("successful");
        } else {
            System.out.println("lose");
        }
    }

    @Test // 4 .查询 :queryForMap 这个方法返回的结果只能是1，将列名作为key，将值作为value，返回一个map
    public void test4() {
        String sqlQuery = "select * from account where name = ?";
        System.out.println(template.queryForMap(sqlQuery, "alice"));
    }

    @Test // 5 .查询更多的结果
    //返回值将多个map封装到list中,用遍历list的方法遍历
    public void test5() {
        String sqlQuery = "select * from account ";
        List<Map<String, Object>> mapList = template.queryForList(sqlQuery);
        for (Map<String, Object> mapString : mapList) {
            System.out.println(mapString);
        }
    }

    @Test // 6 .查询多条记录，封装成emp对象(未简化，自己造轮子）
    public void test6() {
        String sqlQuery = "select * from account ";
        List<Emp> empList = template.query(sqlQuery, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                int id = resultSet.getInt("id");
                double balance = resultSet.getDouble("balance");
                String name = resultSet.getNString("name");
                emp.setBalance(balance);
                emp.setId(id);
                emp.setName(name);
                return emp;
            }
        });

        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }

    @Test // 7 .查询多条记录，封装成emp对象(简化，使用别人的轮子）
    public void test7() {
        String sqlQuery = "select * from account where name = ?";
        List<Emp> empList = template.query(sqlQuery,new BeanPropertyRowMapper<>(Emp.class),"alice");

        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }

    @Test // 7 .查询结果数
    public void test8() {
        String sqlQuery = "select count(id) from account ";
        Long total = template.queryForObject(sqlQuery,Long.class); //这个方法一般是用来执行聚合函数
        System.out.println(total);

    }

    @Before
    public void start() {
        System.out.println("start");
    }

    @After
    public void end() {
        System.out.println("end");
    }

}
