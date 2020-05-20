package cf.kongjinxing.chap01_02._04.singleton;


/**
 * //恶汉式：创建对象实例的时候直接初始化 空间换时间
 * Created by Kong on 2019/12/7.
 */
public class SingletonOne {
    private static SingletonOne  singletonOne = new SingletonOne();

    private SingletonOne() {}

    public static SingletonOne getSingletonOne() {
        return singletonOne;
    }
}
