package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成，利用回溯法
 * 回溯法 三个原则
 * 1. 有终止条件
 * 2. 遍历节点
 * 3. 筛选节点
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        int left = n;
        int right = n;
        dfs(n,left,right,new StringBuilder(), res);
        return res;
    }

    void dfs(int n,int left,int right,StringBuilder sb,List<String> res) {

        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            sb = sb.append("(");
            dfs(n, left-1, right, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }if (right > 0) {
            sb = sb.append(")");
            dfs(n, left, right-1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }
}
