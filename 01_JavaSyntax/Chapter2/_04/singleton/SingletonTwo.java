package cf.kongjinxing.chap01_02._04.singleton;

/**
 * 懒汉式：类内实例对象创建时并不直接初始化，直到第一次调用get方法时，才完成初始化操作 时间换空间
 * Created by Kong on 2019/12/7.
 */
public class SingletonTwo {
    private static SingletonTwo instance;

    private SingletonTwo() {}

    public static SingletonTwo getInstance() {
        if (instance == null)
            instance = new SingletonTwo();
        return instance;
    }
}
