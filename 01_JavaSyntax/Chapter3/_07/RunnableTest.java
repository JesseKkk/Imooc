package cf.kongjinxing.chap01_03._07;

/**
 * Created by Kong on 2019/12/23.
 */
class PrintRunnable implements Runnable
{
    int i = 1;
    @Override
    public void run() {
        while (i <= 10)
        {
            System.out.println(Thread.currentThread().getName() + "正在运行！" + (i++));
        }
    }
}

public class RunnableTest {
    public static void main(String[] args) {
        PrintRunnable pr = new PrintRunnable();
        Thread t1 = new Thread(pr);
        t1.start();
        PrintRunnable pr1 = new PrintRunnable();
        Thread t2 = new Thread(pr1);
//        Thread t2 = new Thread(pr); //多线程共享资源
        t2.start();
    }
}
