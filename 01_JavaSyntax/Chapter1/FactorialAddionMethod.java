package cf.kongjinxing.chap01_01;

/**
 * Created by Kong on 2019/11/25.
 */
public class FactorialAddionMethod {

    //方法不能嵌套定义
    public int fac(int n)
    {
        int s = 1;
        int sum = 0;

        for (int i = 1; i <= n; i++)
        {
            s = 1;
            for (int j = 1; j <= i; j++)
            {
                s = s * j;
            }
            sum = sum + s;
        }
        return sum;
    }

    public static void main(String[] args) {
        FactorialAddionMethod factorialAddionMethod = new FactorialAddionMethod();
        int sum = factorialAddionMethod.fac(4);
        System.out.println(sum);
    }
}
