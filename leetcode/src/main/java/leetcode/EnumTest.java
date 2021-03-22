package leetcode;

public enum  EnumTest {
    MYSQL("mysql",1),
    ORACLE("oracle",2),;
    private String sex;
    private int num;
    EnumTest(String sex, int num) {
        this.sex = sex;
        this.num = num;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
