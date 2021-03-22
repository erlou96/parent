package leetcode;

public class CountAndSay {
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuffer sb = new StringBuffer();
        String str = (countAndSay(n-1));
        int count =1;
        for (int i=0; i<str.length()-1; i++){
            if (str.charAt(i) != str.charAt(i+1)) {
                sb.append(count).append(str.charAt(i));
                count = 1;
                continue;
            }
            count++;
        }
        sb.append(count).append(str.charAt(str.length()-1));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(CountAndSay.countAndSay(8));
    }
}
