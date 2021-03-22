package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  40. 组合总和 II
 *  输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] pb = new boolean[candidates.length];
        if (candidates.length == 0) {
            return res;
        }
        dfs(candidates,pb,0, target, new ArrayList<>(), res);
        return res;
    }
    void dfs(int[] candidates,boolean[] pb,int n,int target,List<Integer> chain,List<List<Integer>> res) {
        if (n > candidates.length) {
            return;
        }
        if (target <= 0) {
            if (target == 0) {
                List<Integer> tmp = new ArrayList<>(chain);
                Collections.sort(tmp);
                if (!res.contains(tmp)) {
                    res.add(new ArrayList<>(tmp));
                }
            }
            return;
        }
        for (int i=0; i<candidates.length; i++) {
            if (!pb[i]) {
                chain.add(candidates[i]);
                pb[i] = true;
                dfs(candidates, pb, n+1, target-candidates[i],chain,res);
                pb[i] = false;
                chain.remove(chain.size()-1);

            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(new int[]{1,3,2,1}, 4));
    }
}
