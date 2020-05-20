package cf.kongjinxing.chap01_02._05.tel;

/**
 * 接口类的访问权限只能为：public和默认
 * Created by Kong on 2019/12/9.
 */
public interface INet {
    /**
     * 接口中抽象方法可以不写abstract关键字
     * 方法访问修饰符默认为public
     */
    void network();

    //接口可以包含常量，默认public static final
    int TEMP = 20;

    //default：默认方法，可以带方法体  jdk1.8后新增
    //可以在实现类中重写，并可以通过接口的引用调用
    default  void connection()
    {
        System.out.println("我是接口中的默认连接");
    }

    //static：静态方法，可以带方法体
    //不可以在实现类中重写，可以用接口名调用
    static void stop()
    {
        System.out.println("我是接口中的静态方法");
    }
}
