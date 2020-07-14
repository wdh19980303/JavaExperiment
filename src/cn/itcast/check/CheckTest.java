package cn.itcast.check;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 * 当主方法执行后，会自动执行被检测的所有方法（加了check注解的方法），判断是否有异常
 */
public class CheckTest {
    public static void main(String[] args) throws IOException {
        // 1.创建计算器对象
        Calculator c = new Calculator();
        // 2.获取字节码文件对象
        Class cal = c.getClass();
        // 3.获取所有方法
        Method[] methods = cal.getMethods();
        int number = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method : methods) {
            // 4.判断方法上是否有Check注解
            if (method.isAnnotationPresent(Check.class)) {
                // 5.有，执行
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    // 6.捕获异常
                    // 记录到文件
                    number++;
                    bw.write("异常方法：" + method.getName());
                    bw.newLine();
                    bw.write("异常名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因：" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-----------------------------");
                    bw.newLine();

                }
            }
        }

        bw.write("本次测试一共出现 "+number +" 异常");
        bw.flush();
        bw.close();
    }
}
