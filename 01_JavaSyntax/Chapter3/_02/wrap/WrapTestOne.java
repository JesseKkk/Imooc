package cf.kongjinxing.chap01_03._02.wrap;

/**
 * Created by Kong on 2019/12/18.
 */
public class WrapTestOne {
    public static void main(String[] args) {
        //装箱：把基本数据类型转换为包装类
        //1、自动装箱
        int t1 = 2;
        Integer t2 = t1;

        //2、手动装箱
        Integer t3 = new Integer(3);

        //测试
        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        System.out.println("t3 = " + t3);

        //拆箱：把包装类转换为基本数据类型
        //1、自动拆箱
        int t4 = t2;

        //2、手动拆箱
        int t5 = t2.intValue();

        //测试
        System.out.println("t4 = " + t4);
        System.out.println("t5 = " + t5);
    }
}
