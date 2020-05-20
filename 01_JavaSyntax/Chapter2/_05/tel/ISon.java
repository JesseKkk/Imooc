package cf.kongjinxing.chap01_02._05.tel;

/**
 * 接口可以实现继承，并且可以继承多个父接口
 * Created by Kong on 2019/12/9.
 */
public interface ISon extends IFather, IFather2  {
    void run();

    default  void connection()
    {
        System.out.println("ISon中的connection");
    }
}
