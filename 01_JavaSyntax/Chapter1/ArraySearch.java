package cf.kongjinxing.chap01_01;


import java.util.Scanner;

/**
 * Created by Kong on 2019/11/25.
 */
public class ArraySearch {
    public boolean search(int n, int[] arr)
    {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++)
        {
            if (n == arr[i])
            {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr = {12, 14, 15, 16, 20};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入查找的元素值：");
        int n = sc.nextInt();
        ArraySearch arraySearch = new ArraySearch();
        boolean as = arraySearch.search(n, arr);
        if (as)
        {
            System.out.println("找到了！");
        }else
        {
            System.out.println("没找到！");
        }

    }
}
