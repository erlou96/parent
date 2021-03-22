package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> ans = new HashMap();
        int left = 0;
        int right = 0;
        int res = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            right++;
            ans.put(c, ans.getOrDefault(c, 0) + 1);
            while (ans.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                ans.put(c, ans.get(c) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println( l.lengthOfLongestSubstring("pwwkew"));
    }
}
