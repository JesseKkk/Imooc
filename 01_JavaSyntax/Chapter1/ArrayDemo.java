package cf.kongjinxing.chap01_01;

import java.util.Arrays;

/**
 * Created by Kong on 2019/11/25.
 */
public class ArrayDemo {
    //定义一个用于修改某个数组元素值的方法
    public void updateArray(int[] a)
    {
        a[3] = 1;
        System.out.println("数组a的元素为：");
        System.out.println(Arrays.toString(a));

    }

    public static void main(String[] args) {
        int[] arr = {12, 14, 15, 16, 17};
        System.out.println("数组改变前：");
        System.out.println(Arrays.toString(arr));
        ArrayDemo ad = new ArrayDemo();
        ad.updateArray(arr);
        System.out.println("数组改变后：");
        System.out.println(Arrays.toString(arr));
    }
}
