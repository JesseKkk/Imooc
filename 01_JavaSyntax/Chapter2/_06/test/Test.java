package cf.kongjinxing.chap01_02._06.test;

import cf.kongjinxing.chap01_02._06.circus.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Kong on 2019/12/17.
 */
public class Test {

    //显示菜单
    public void displayMenu()
    {
        System.out.println("***************欢迎来到太阳马戏团******************");
        System.out.println("*************    请选择表演者    *****************");
        System.out.println("*************     1、棕熊        *****************");
        System.out.println("*************     2、狮子        *****************");
        System.out.println("*************     3、猴子        *****************");
        System.out.println("*************     4、鹦鹉        *****************");
        System.out.println("*************     5、小丑        *****************");
    }

    //主方法
    public static void main(String[] args) {

        Test show = new Test();
        Scanner sc = new Scanner(System.in);
        int in;//in是选项功能
        IAct actor =null;
        boolean flag= true;

//        //创建数组，将实例化对象放入数组中
//        IAct[] arr = new IAct[5];
//        arr[0] = new Bear("Bill", 1);
//        arr[1] = new Lion("Lain", 2, "灰色","公");
//        arr[2] = new Monkey("Tom", 1, "金丝猴");
//        arr[3] = new Parrot("Ross", 1, "牡丹鹦鹉");
//        arr[4] = new Clown("Kahle", 5);

        while (true)
        {
            show.displayMenu();
            flag = true;

            //限定输入为1-5，否者报错
            try {
                in = sc.nextInt();
                if (in < 1 || in >5)
                {
                    System.out.println("数据超出范围，请输入1-5");
                    continue;
                }
            }catch (InputMismatchException e)
            {
                System.out.println("输入的数据格式有误!");
                sc.next();
                continue;
            }

//            arr[in-1].act();//表演
            switch (in)
            {
                case 1:
                    actor = new Bear("Bill", 1);
                    break;
                case 2:
                    actor = new Lion("Lain", 2, "灰色","公");
                    break;
                case 3:
                    actor = new Monkey("Tom", 1, "金丝猴");
                    break;
                case 4:
                    actor = new Parrot("Ross", 1, "牡丹鹦鹉");
                    break;
                case 5:
                    actor = new Clown("Kahle", 5);
                    break;
                default:
                    System.out.println("数据超出范围，请输入1-5");
                    break;
            }
            actor.act();//表演

            while (flag) {
                System.out.println("**********  是否继续观看（1/0）  ***********");
                //限定输入为1/0，否者报错
                try {
                    in = sc.nextInt();
                    if (in != 0 && in !=1)
                    {
                        System.out.println("请输入1/0：");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("输入的数据格式有误,请重新输入：");
                    sc.next();
                    continue;
                }
                if (in ==1)
                {
                    flag = false;
                }
                else
                {
                    System.out.println("欢迎光临~~");
                    System.exit(0);
                }

            }
        }

    }
}
