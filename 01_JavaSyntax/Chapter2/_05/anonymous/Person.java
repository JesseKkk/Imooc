package cf.kongjinxing.chap01_02._05.anonymous;

/**
 * Created by Kong on 2019/12/9.
 */
public abstract class Person {
    private String name;

    public Person() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void read();
}
