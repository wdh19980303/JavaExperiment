package cn.itcast.thread;

import java.io.OutputStreamWriter;

public class execution {
    public static void main(String[] args) {
        thread_test run1 = new thread_test();
        thread_test run2 = new thread_test();

        Thread thread1 = new Thread(run1,"run1");
        Thread thread2 = new Thread(run2,"run2");
        thread1.start();
        thread2.start();
        Season Spring = Season.Spring;
        String spring = Spring.getChinese();
        System.out.println(spring);

    }
}
