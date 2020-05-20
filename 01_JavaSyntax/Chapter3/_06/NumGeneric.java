package cf.kongjinxing.chap01_03._06;

/**
 * Created by Kong on 2019/12/23.
 */
public class NumGeneric<T> {
    private T num;
    public T getTum() {
        return num;
    }
    public void setNum(T num)
    {
        this.num = num;
    }

    public static void main(String[] args)
    {
        NumGeneric<Integer> intNum = new NumGeneric<>();
        intNum.setNum(10);
        System.out.println("intNum = " + intNum.getTum());

        NumGeneric<Float> floatNum = new NumGeneric<>();
        floatNum.setNum(5.0f);
        System.out.println("floatNum = " + floatNum.getTum());
    }

}
