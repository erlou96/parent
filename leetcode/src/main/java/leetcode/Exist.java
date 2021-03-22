package leetcode;

public class Exist {
    public int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[1];
        }
        int x = 1;
        while(n > 0) {
            x = 10 * x;
            n--;
        }
        int[] res = new int[x];
        for (int i=0; i<x-1; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
