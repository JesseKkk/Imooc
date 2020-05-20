package cf.kongjinxing.chap01_01;

/**
 * Created by Kong on 2019/11/25.
 */
public class ArgsDemo3 {
    //可变参数列表所在的方法是最后被访问的
    public int add (int a,int b)
    {
        System.out.println("不可变参数的方法被调用！");
        return a + b;
    }

    public int add (int... a)
    {
        System.out.println("不可变参数的方法被调用！");
        int sum = 0;
        for (int n:a)
        {
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArgsDemo3 ad = new ArgsDemo3();
        System.out.println(ad.add(1,2));
    }
}
