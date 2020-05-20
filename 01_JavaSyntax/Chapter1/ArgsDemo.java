package cf.kongjinxing.chap01_01;


/**
 * Created by Kong on 2019/11/25.
 */
public class ArgsDemo {
    public void sum(int... n){
        int sum = 0;
        for (int a:n){
            sum = sum + a;
        }
        System.out.println("sum = " + sum);
    }

    public static void main(String[] args) {
        ArgsDemo ad = new ArgsDemo();
        ad.sum(1, 2, 3);
        ad.sum(1, 2);
    }
}
