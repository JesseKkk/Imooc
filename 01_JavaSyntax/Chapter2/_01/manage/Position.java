package cf.kongjinxing.chap01_02._01.manage;


/**
 * Created by Kong on 2019/12/16.
 */
public class Position {
    /**
     * 成员属性
     */
    private String positionNu;
    private String positionNa;

    //无参构造方法
    public Position() {}

    //带参构造方法
    public Position(String positionNu, String positionNa) {
        this.setPositionNu(positionNu);
        this.setPositionNa(positionNa);
    }

    public String getPositionNu() {
        return positionNu;
    }

    public void setPositionNu(String positionNu) {
        this.positionNu = positionNu;
    }

    public String getPositionNa() {
        return positionNa;
    }

    public void setPositionNa(String positionNa) {
        this.positionNa = positionNa;
    }

    //职务信息介绍，包括职务编号和职务名称
    public String info()
    {
        String str = "职务信息如下：\n职务编号：" + this.getPositionNu() +
                "\n职务名称：" + this.getPositionNa();
        return str;
    }
}
