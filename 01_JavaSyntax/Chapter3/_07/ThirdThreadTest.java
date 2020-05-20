package cf.kongjinxing.chap01_03._07;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Kong on 2019/12/23.
 */
class ThirdThread implements Callable<String>
{

    @Override
    public String call() throws Exception {
        String str = "多线程的第三种创建方式";
        return str;
    }
}


public class ThirdThreadTest {
    public static void main(String[] args) {
        Callable<String> call = new ThirdThread();
        FutureTask<String> ft = new FutureTask<>(call);
        Thread t3 = new Thread(ft);
        t3.start();
        try {
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
