package cf.kongjinxing.chap01_01;

import java.util.Scanner;

/**
 * Created by Kong on 2019/11/25.
 */
public class DataManagement {
    //插入数据
    public int[] insertData()
    {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 10; i++)
        {
            System.out.println("请输入第" + i + "的数据：");
            int n = sc.nextInt();
            arr[i-1] = n;
        }
        return arr;
    }

    //显示所有数据
    public void showData(int[] a, int length)
    {
        System.out.println("数组元素为：");
        for (int i = 0; i < length; i++)
        {
            System.out.print(a[i] + "  ");
        }
        System.out.println();
    }

 //在指定处插入数据
    public void insertAtArray(int[] a, int n, int k)
    {
        if (k == 9)
        {
            a[9] = n;
        }else
        {
            for (int i = 9; i > k; i--)
            {
                a[i] = a[i - 1];
            }
            a[k] = n;
        }
    }

    //查询能被3整除的数据
    public void divThree(int[] a)
    {
        System.out.println("数组中能被3整除的元素为：");
        for (int n:a)
        {
            if (n % 3 ==0)
            {
                System.out.print(n + "  ");
            }
        }
        System.out.println();
    }

    //显示提示信息的方法
    public void notice()
    {
        System.out.println("*********************************");
        System.out.println("        1--插入数据               ");
        System.out.println("        2--显示所有数据           ");
        System.out.println("        3--在指定位置处插入数      ");
        System.out.println("        4--查询能被3整除的数据     ");
        System.out.println("        0--退出                   ");
        System.out.println("*********************************");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataManagement dm = new DataManagement();
        int[] arr = new int[10];
        boolean flag = false;

        while (true)
        {
            dm.notice();
            System.out.println("请输入对应的数字进行操作：");
            int n = sc.nextInt();
            switch (n)
            {
                case 1:
                    arr = dm.insertData();
                    dm.showData(arr, arr.length - 1);
                    break;
                case 2:
                    if (flag)
                    {
                        dm.showData(arr, arr.length);
                    }else{
                        dm.showData(arr,arr.length -1);
                    }
                    break;
                case 3:
                    System.out.println("请输入要插入的数据：");
                    n = sc.nextInt();
                    System.out.println("请输入要插入数据的位置：");
                    int k = sc.nextInt();
                    dm.insertAtArray(arr, n, k);
                    dm.showData(arr, arr.length);
                    flag = true;
                    break;
                case 4:
                    dm.divThree(arr);
                    break;
                case 0:
                    System.out.println("退出程序！");
                    System.exit(0);
            }
        }
    }
}
