package cn.itcast.check;

import java.sql.SQLOutput;

public class Calculator {
    //自定义的计算器
    @Check
    public void add() {
        String string = null;
        string.toString();
        System.out.println("1 + 0 = " + (1 + 0));
    }

    @Check
    public void sub() {
        System.out.println("1 - 0 = " + (1 - 0));
    }

    @Check
    public void div() {
        System.out.println("1 / 0 = " + (1 / 0));
    }

    @Check
    public void mul() {
        System.out.println("1 * 0 = " + (1 * 0));
    }


}
