package cf.kongjinxing.chap01_03._04.set;

import java.util.Objects;

/**
 * Created by Kong on 2019/12/19.
 */
public class Student {
    private int stuid;
    private String name;
    private float score;

    public Student() {
    }

    public Student(int stuid, String name, float score) {
        this.stuid = stuid;
        this.name = name;
        this.score = score;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return stuid == student.stuid &&
                Float.compare(student.score, score) == 0 &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuid, name, score);
    }
}
