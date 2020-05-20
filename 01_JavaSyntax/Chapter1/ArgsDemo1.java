package cf.kongjinxing.chap01_01;

/**
 * Created by Kong on 2019/11/25.
 */
public class ArgsDemo1 {
    public void search(int n, int... a)
    {
        boolean flag = false;
        for (int a1:a)
        {
            if (a1 == n)
            {
                flag = true;break;
            }
        }
        if (flag)
        {
            System.out.println("找到了" + n);
        }else
        {
            System.out.println("没找到" + n);
        }
    }

    public static void main(String[] args) {
        int[] arr = {23, 34, 53, 56};
        ArgsDemo1 ad = new ArgsDemo1();
        ad.search(1, 2, 3, 4, 1);
        ad.search(23, arr);
    }
}
