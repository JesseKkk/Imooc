package cf.kongjinxing.chap01_01;

import java.util.Scanner;

/**
 * Created by Kong on 2019/11/22.
 */
public class WeekDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入星期的英文字母：");
        String n = sc.next();
        n = n.toUpperCase();

        switch(n)
        {
            case "MONDAY":
                System.out.println("星期一");break;
            case "TUESDAY":
                System.out.println("星期二");break;
            case "WEDNESDAY":
                System.out.println("星期三");break;
            case "THURSDAY":
                System.out.println("星期四");break;
            case "FRIDAY":
                System.out.println("星期五");break;
            case "SATURDAY":
                System.out.println("星期六");break;
            case "SUNDAY":
                System.out.println("星期七");break;
            default:
                System.out.println("该数字超出了1-7的范围");
        }
    }
}
