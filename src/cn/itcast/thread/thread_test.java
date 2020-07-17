package cn.itcast.thread;

public class thread_test implements Runnable {
    private static int money = 50;

    @Override
    public void run() {
        if (money == 50){
            --money;
            System.out.println(money);
        }else {
            System.out.println("lose");
        }
        /*synchronized (this)*/ {

        }

    }
}
