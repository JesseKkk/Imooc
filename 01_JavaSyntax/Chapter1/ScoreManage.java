package cf.kongjinxing.chap01_01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Kong on 2019/12/13.
 */
public class ScoreManage {
    /**
     * 显示菜单
     */
    public void displayMenu()
    {
        System.out.println("**************************************");
        System.out.println("        1--初始化数学成绩              ");
        System.out.println("        2--求成绩的平均值              ");
        System.out.println("        3--统计成绩大于85分的人数      ");
        System.out.println("        4--修改指定位置处的成绩        ");
        System.out.println("        5--打印输出所有成绩            ");
        System.out.println("        0--退出                       ");
        System.out.println("**************************************");
    }

    /**
     * 初始化数学成绩
     * @return 成绩数组
     */
    public float[] initScore()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要存储的数学成绩的数量：");
        while (!input.hasNextInt())
        {
            System.out.println("输入的数据格式有误，请重新输入数据！");
            input.next();
        }
        int n = input.nextInt();
        float[] arr = new float[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个数据：");
            try {
                arr[i] = input.nextFloat();
            }catch (InputMismatchException e)
            {
                System.out.println("输入的数据格式有误，请重新输入数据！");
                input.next();
                i--;
            }
        }
        return arr;
    }

    /**
     * 求平均成绩
     * @param f 成绩数组
     * @return 平均值
     */
    public float average(float[] f)
    {
        float sum = 0f;
        for (float i:f)
        {
            sum = sum + i;
        }
        return sum/f.length;
    }

    /**
     * 统计成绩大于85分的人数的方法
     * @param f 成绩数组
     * @return 成绩大于85分的人数
     */
    public int count(float[] f)
    {
        int n = 0;
        for (float i:f)
        {
            if (i > 85)
            {
                n++;
            }
        }
        return n;
    }

    /**
     * 修改指定位置处成绩的方法
     * @param f 成绩数组
     * @param index 位置，从0开始
     * @param newScore 新的成绩
     */
    public void update(float[] f, int index, float newScore)
    {
        f[index] = newScore;
    }

    /**
     * 打印输出所有成绩
     * @param f 成绩数组
     */
    public void displayAllScore(float[] f)
    {
        for (float i:f)
        {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ScoreManage sm = new ScoreManage();
        Scanner input = new Scanner(System.in);
        int in = 0;//in为选项功能
        float[] arr = null;
        int index;//index表示要修改数据的位置
        float newScore;//newScore代表新的成绩
        while (true)
        {
            sm.displayMenu();
            System.out.println("请输入对应的数字进行操作：");
            try {
                in = input.nextInt();
            }catch (InputMismatchException e)
            {
                System.out.println("输入的数据格式有误!");
                input.next();
                continue;
            }
            if (in == 0)
            {
                System.out.println("退出程序！");
                break;
            }
            switch (in)
            {
                //初始化数学成绩
                case 1:
                    arr = sm.initScore();
                    break;
                 //成绩的平均值
                case 2:
                    if (arr != null)
                    {
                        System.out.println("数学的平均成绩为：" + sm.average(arr));
                    }
                    else
                    {
                        System.out.println("请先初始化数学成绩！");
                    }
                    break;
                //统计成绩大于85的人数
                case 3:
                    if (arr != null)
                    {
                        System.out.println("成绩大于85分的人数为：" + sm.count(arr));
                    }
                    else
                    {
                        System.out.println("请先初始化数学成绩！");
                    }
                    break;
                //修改指定位置处的成绩
                case 4 :
                    if (arr != null)
                    {
                        System.out.println("修改前：");
                        System.out.println("成绩为：");
                        sm.displayAllScore(arr);
                        try {
                            System.out.println("请输入要修改数据的位置（0-" + (arr.length - 1) +"）：");
                            index = input.nextInt();
                            System.out.println("请输入新的数据：");
                            newScore = input.nextFloat();
                        }catch (InputMismatchException e)
                        {
                            System.out.println("输入的数据格式有误!");
                            input.next();
                            break;
                        }
                        sm.update(arr,index,newScore);
                        System.out.println("修改后：");
                        System.out.println("成绩为：");
                        sm.displayAllScore(arr);

                    }
                    else
                    {
                        System.out.println("请先初始化数学成绩！");
                    }
                    break;
                //打印输出所有成绩
                case 5:
                    if (arr != null)
                    {
                        sm.displayAllScore(arr);
                    }
                    else
                    {
                        System.out.println("请先初始化数学成绩！");
                    }
                    break;
                //输入数字超出范围，无效！
                default:
                    System.out.println("请输入0-5之间的数字！");
                    break;
            }

        }
    }
}
