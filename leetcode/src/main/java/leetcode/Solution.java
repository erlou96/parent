package leetcode;

public class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int ans = 0;
        int num = x;
        while (num != 0){
            ans = ans * 10 + num % 10;
            num = num /10; }
        return ans == x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
    }
}
