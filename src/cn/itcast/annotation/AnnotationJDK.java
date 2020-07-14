package cn.itcast.annotation;


@SuppressWarnings("all") //压制警告
public class AnnotationJDK {
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1() {
        //有缺陷
    }


    public void show2() {
        //替代show1
    }

    public void demo(){


    }
}
