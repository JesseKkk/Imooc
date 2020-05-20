package cf.kongjinxing.chap01_02._05.tel;

/**
 * Created by Kong on 2019/12/9.
 */
public interface Iphone {
    public void photo();

    default void connection()
    {
        System.out.println("我是IPhoto的connection");
    }
}
