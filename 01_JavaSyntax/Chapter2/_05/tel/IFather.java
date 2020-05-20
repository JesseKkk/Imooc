package cf.kongjinxing.chap01_02._05.tel;

/**
 * Created by Kong on 2019/12/9.
 */
public interface IFather {
    void say();

    default  void connection()
    {
        System.out.println("IFather中的connection");
    }
}
