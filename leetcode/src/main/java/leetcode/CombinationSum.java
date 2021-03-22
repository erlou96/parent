package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 39题
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        dfs(candidates,target,new ArrayList<>(), res);
        return res;
    }
    void dfs(int[] candidates,int target,List<Integer> chain,List<List<Integer>> res) {
        // 1.终止条件
        if ( target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> tmp = new ArrayList<>(chain);
            Collections.sort(tmp);
            if (!res.contains(tmp)) {
                res.add(tmp);
            }
            return;
        }
        // 2.遍历候选节点
        for (int i=0; i<candidates.length; i++) {
            chain.add(candidates[i]);
            dfs(candidates,target-candidates[i],chain,res);
            chain.remove(chain.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2,3,5},8));
    }
}
