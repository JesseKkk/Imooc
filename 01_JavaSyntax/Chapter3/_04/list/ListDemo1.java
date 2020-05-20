package cf.kongjinxing.chap01_03._04.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kong on 2019/12/19.
 */
public class ListDemo1 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("语文");
        list.add("数学");
        list.add("英语");
        list.add("化学");
        list.add("物理");
        list.add("生物");
        System.out.println("列表中元素的个数为：" + list.size());
        for (int i = 0; i < list.size();i++)
        {
            System.out.println("第" + (i+1) + "个为" + list.get(i));
        }

    }
}
