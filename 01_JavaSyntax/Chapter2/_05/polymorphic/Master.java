package cf.kongjinxing.chap01_02._05.polymorphic;

/**
 * Created by Kong on 2019/12/9.
 */
public class Master {
    /**
     * 喂宠物
     * Cat：吃完东西，主人带去玩线球
     * Dog：吃完东西，主人带去睡觉
     */

    //方案1
//    public void feed(Cat cat)
//    {
//        cat.eat();
//        cat.playBall();
//    }
//
//    public void feed(Dog dog)
//    {
//        dog.eat();
//        dog.sleep();
//    }

    //方案2
    public void feed(Animal obj)
    {
        obj.eat();
        if (obj instanceof Cat)
        {
            Cat temp = (Cat) obj;
            temp.playBall();
        } else if (obj instanceof Dog)
        {
            Dog temp = (Dog)obj;
            temp.sleep();
        }
    }

    /**
     * 饲养何种宠物
     * 空闲时间多：养狗
     * 空闲时间少：养猫
     */
//    //方案1
//    public Dog hasManyTime()
//    {
//        System.out.println("空闲时间多，养狗");
//        return new Dog();
//    }
//
//    public Cat hasLittleTime()
//    {
//        System.out.println("空闲时间少，养猫");
//        return new Cat();
//    }

    //方案2
    public Animal raise(boolean isManyTime)
    {
        if (isManyTime)
        {
            System.out.println("空闲时间多，养狗");
            return new Dog();
        }else
        {
            System.out.println("空闲时间少，养猫");
            return new Cat();
        }
    }
}
