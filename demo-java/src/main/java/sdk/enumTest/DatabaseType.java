package sdk.enumTest;

public enum DatabaseType {

    MYSQL(0,"MySql"),
    ORACLE(1,"Oracle");

    DatabaseType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}

class Test6{
    public static void main(String[] args) {
        DatabaseType mysql = DatabaseType.MYSQL;
        int code = mysql.getCode();
        System.out.println(code);

    }
}
