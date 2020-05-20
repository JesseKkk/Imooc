package cf.kongjinxing.chap01_03._07;

/**
 * Created by Kong on 2019/12/23.
 */

class LetterRunnable implements Runnable
{
    @Override
    public void run() {
        char[] ch = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
        'o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i = 0; i <= ch.length; i++) {
            System.out.println(ch[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        LetterRunnable le = new LetterRunnable();
        Thread td = new Thread(le);
        td.start();
    }
}
