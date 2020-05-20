package cf.kongjinxing.chap01_02._05.tel;

/**
 * Created by Kong on 2019/12/9.
 */
public interface IFather2 {
    void fly();

    default  void connection()
    {
        System.out.println("IFather2中的connection");
    }
}
