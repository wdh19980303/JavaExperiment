package cn.itcast.annotation;

import java.io.PushbackInputStream;

public @interface AnnotationCustom {
    int show1() default 1 ;
    String show2();
    Person per();


}
