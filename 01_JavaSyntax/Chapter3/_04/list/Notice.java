package cf.kongjinxing.chap01_03._04.list;

import java.util.Date;

/**
 * Created by Kong on 2019/12/19.
 */
public class Notice {
    private int id;
    private String title;
    private String creator;
    private Date creatTime;

    public Notice() {
    }

    public Notice(int id, String title, String creator, Date creatTime) {
        this.id = id;
        this.title = title;
        this.creator = creator;
        this.creatTime = creatTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
