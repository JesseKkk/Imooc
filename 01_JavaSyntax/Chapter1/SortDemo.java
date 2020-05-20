package cf.kongjinxing.chap01_01;

/**
 * Created by Kong on 2019/11/25.
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {12, 68, 49, 29, 30};
        System.out.println("排序前的数组：");
        for (int n: arr)
        {
            System.out.print(n + "  ");
        }

        System.out.println();
        System.out.println("排序后的数组：");
        int temp;
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = 0; j <arr.length - i - 1; j++)
            {
                if (arr[j] < arr[j + 1])
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int n: arr)
        {
            System.out.print(n + "  ");
        }

    }
}
