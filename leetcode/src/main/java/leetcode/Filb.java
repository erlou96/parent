package leetcode;

public class Filb {
    public int fib(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int[] pb = new int[n+1];
        pb[0] = 0;
        pb[1] = 1;
        for (int i=2; i<=n; i++) {
            pb[i] = pb[i-2] + pb[i-1];
            pb[i] %= 1000000007;
        }
        // 0 1 1 2 3 5 8 13 21 34
        return pb[n];
    }

    public static void main(String[] args) {
        Filb filb = new Filb();
        System.out.println(filb.fib(10));
    }
}
