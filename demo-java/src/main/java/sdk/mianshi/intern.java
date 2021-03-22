package sdk.mianshi;

public class intern {
    public static void main(String[] args) {
        String str1=new StringBuilder("58").append("58").toString();

        System.out.println(str1.intern() == str1); // true

        String str2=new StringBuilder("ja").append("va").toString();

        System.out.println(str2.intern() == str2); // false
    }
}
