package cf.kongjinxing.chap01_02._05.tel;

/**
 * 原始手机
 * Created by Kong on 2019/12/9.
 */
public class Telphone {
    private String brand;
    private int price;

    public Telphone()
    {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void call()
    {
        System.out.println("手机可以打电话");
    }
}
