package cf.kongjinxing.chap01_03._09.player;

import java.util.Objects;

/**
 * Created by Kong on 2019/12/24.
 */
public class Song {
    private String id;//歌曲id
    private String name;//歌曲名称
    private String singer;//演唱者

    /**
     * 构造方法 设置全部属性
     * @param id
     * @param name
     * @param singer
     */
    public Song(String id, String name, String singer) {
        this.id = id;
        this.name = name;
        this.singer = singer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) &&
                Objects.equals(name, song.name) &&
                Objects.equals(singer, song.singer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, singer);
    }

    @Override
    public String toString() {
        return "歌曲信息：id为：" + id +  "，歌曲名称为：" + name + "，演唱者为：" + singer;
    }
}
