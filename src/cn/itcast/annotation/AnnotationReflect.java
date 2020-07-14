package cn.itcast.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@ProStatic(className = "cn.itcast.annotation.Demo",methodName = "show")
public class AnnotationReflect {
    public static void main(String[] args) {
        /**
         * 1 解析注解
         * 1.1 获取该类的字节码文件对象
         */
        Class<AnnotationReflect> reflectClass = AnnotationReflect.class;
        // 2 获取注解对象
        // 其实就是在内存中生成了一个该注解接口的子类实现对象
        ProStatic Ps = reflectClass.getAnnotation(ProStatic.class);
        // 3 调用注解对象中的抽象方法，获取返回值
        String className = Ps.className();
        String methodName = Ps.methodName();
        System.out.println(className + "_______" + methodName);
    }


}
