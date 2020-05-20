package cf.kongjinxing.chap01_03._07.queue;

/**
 * Created by Kong on 2019/12/23.
 */
public class Test {
    public static void main(String[] args) {
        Queue queue = new Queue();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
