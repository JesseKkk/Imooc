package cf.kongjinxing.chap01_03._01;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Kong on 2019/12/10.
 */
public class TryDemoOne {
    public static void main(String[] args) {
        //定义两个整数，接收用户的键盘输入，输出两数之商
        Scanner input = new Scanner(System.in);
        System.out.println("======运算开始=======");
        try {
            System.out.print("请输入第一个整数：");
            int one = input.nextInt();
            System.out.print("请输入第二个整数：");
            int two = input.nextInt();
            System.out.println("one和two的商是：" + (one / two));
        }catch(ArithmeticException e){
            System.exit(1);//终止运行
            System.out.println("除数不允许为0");
            e.printStackTrace();
        } catch(InputMismatchException e) {
            System.out.println("请输入整数");
            e.printStackTrace();
        }catch(Exception e) {
            System.out.println("出错了~~");
            e.printStackTrace();
        }finally {
            System.out.println("======运算结束=======");
        }
    }
}
