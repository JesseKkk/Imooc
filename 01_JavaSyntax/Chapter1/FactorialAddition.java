package cf.kongjinxing.chap01_01;

/**
 * Created by Kong on 2019/11/24.
 */
public class FactorialAddition {
    public static void main(String[] args) {
        int s = 1;
        int sum = 0;

        for(int i = 1; i <= 4; i++)
        {
            s = 1;
            for(int j = 1; j <= i; j++)
            {
                s = j * s;
            }
            sum = sum + s;
        }
        System.out.println(sum);
    }
}
