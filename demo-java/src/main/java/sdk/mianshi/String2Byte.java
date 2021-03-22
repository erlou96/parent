package sdk.mianshi;

public class String2Byte {
    public static void string2Byte() {
        String str = "Hello World";
        byte[] bytes = str.getBytes();
        String str1 = new String(bytes);
    }
}
