package cf.kongjinxing.chap01_03._02.wrap;


/**
 * Created by Kong on 2019/12/18.
 */
public class WrapTestTwo {
    public static void main(String[] args) {
        //基本数据类型转换为字符串
        int t1 = 2;
        String t2 = Integer.toString(t1);

        //测试
        System.out.println("t2 = " + t2);

        //字符串转换为基本数据类型
        //1、包装类的parse
        int t3 = Integer.parseInt(t2);

        //2、包装类的valueOf
        int t4 = Integer.valueOf(t2);

        //测试
        System.out.println("t3 = " + t3);
        System.out.println("t4 = " + t4);
    }
}
