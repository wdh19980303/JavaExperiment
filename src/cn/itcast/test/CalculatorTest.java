package cn.itcast.test;

import cn.itcast.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /*
     *测试add方法
     */

    @Test
    public void testAdd() {
//        System.out.println("运行");
//        1.创建对象
//        2.调用对象方法
        Calculator c = new Calculator();
        int result = c.add(1, 2);

//        3.断言，将理想结果与实际结果做比较
        Assert.assertEquals(4, result);

//        System.out.println(result);
    }

    @Test
    public void testSub() {
//        System.out.println("运行");
//        1.创建对象
//        2.调用对象方法
        Calculator c = new Calculator();
        int result = c.sub(1, 2);
        System.out.println("testSub");

//        3.断言，将理想结果与实际结果做比较
        Assert.assertEquals(-1, result);

//        System.out.println(result);
    }


    /**
     * 初始化方法
     * 用于资源申请
     * 在测试方法运行之前执行
     */
    @Before
    public void init() {
        System.out.println("init...");
    }

    /**
     * 释放资源的方法
     * 在所有测试方法执行完过后，都会自动执行该方法
     */
    @After
    public void close() {
        System.out.println("close");
    }

}
