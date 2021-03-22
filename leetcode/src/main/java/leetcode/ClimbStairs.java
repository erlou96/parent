package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStairs {

    HashMap<Character,String> hashMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        List<String> res = new ArrayList<String>();
        int n = digits.length();
        dfs(0,digits,new StringBuilder(), res);
        return res;
    }

    void dfs(int n, String digits, StringBuilder sb, List<String> res) {

        // 截止条件
        if (n == digits.length()) {
            res.add(sb.toString());
            return;
        }

        char index = digits.charAt(n);
        String str = hashMap.get(index);
        // 遍历候选节点
        for (int i=0; i<str.length(); i++) {
            // 筛选节点
            sb.append(str.charAt(i));
            dfs(n+1, digits, sb, res);
            sb.deleteCharAt(n);
        }
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        climbStairs.letterCombinations("23");
    }
}

