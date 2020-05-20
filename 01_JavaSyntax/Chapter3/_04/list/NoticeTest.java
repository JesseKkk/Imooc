package cf.kongjinxing.chap01_03._04.list;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kong on 2019/12/19.
 */
public class NoticeTest {
    public static void main(String[] args) {
        Notice notice1 = new Notice(1,"上课","管理员",new Date());
        Notice notice2 = new Notice(2,"下课","老师",new Date());
        Notice notice3 = new Notice(1,"放学","老师",new Date());

        ArrayList noticList = new ArrayList();
        noticList.add(notice1);
        noticList.add(notice2);
        noticList.add(notice3);

        System.out.println("公告的内容为：");
        for (int i = 0; i < noticList.size(); i++)
        {
            System.out.println((i+1) + ":" + ((Notice)(noticList.get(i))).getTitle());
        }
    }
}
