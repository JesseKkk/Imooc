package cf.kongjinxing.chap01_03._04.list;

/**
 * Created by Kong on 2019/12/19.
 */
public class Employee {
    private int id;
    private String name;
    private double alary;

    public Employee() {
    }

    public Employee(int id, String name, double alary) {
        this.id = id;
        this.name = name;
        this.alary = alary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAlary() {
        return alary;
    }

    public void setAlary(double alary) {
        this.alary = alary;
    }
}
