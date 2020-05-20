package cf.kongjinxing.chap01_02._05.anonymous;


/**
 * Created by Kong on 2019/12/9.
 */
public class PersonTest {
    public void getRead(Person person)
    {
        person.read();
    }

    public static void main(String[] args) {
        PersonTest test = new PersonTest();
        //匿名内部类
        /**
         * 1、匿名内部类没有类型名称、实例对象名称
         * 2、编译后的文件命名：内部类$数字.class
         * 3、无法使用private、public、protected、abstract、static修饰
         * 4、无法编写构造方法，可以添加构造代码块
         * 5、不能出现静态成员
         * 6、匿名内部类可以实现接口也可以继承父类，但是不可兼得
         */
        test.getRead(new Person()
        {
            @Override
            public void read() {
                System.out.println("男生喜欢看科幻类的书籍");
            }
        });
        test.getRead(new Person()
        {

            @Override
            public void read() {
                System.out.println("女生喜欢读言情小说");
            }
        });
    }
}
