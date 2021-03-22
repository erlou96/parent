package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *  46. 全排列
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] pb = new boolean[nums.length];
        if (nums.length == 0) {
            return res;
        }
        dfs(nums,pb,0,new ArrayList<>(),res);
        return res;
    }
    void dfs(int[] nums,boolean[] pb,int n,List<Integer> chain,List<List<Integer>> res) {
        // 1. 终止条件
        if (n == nums.length) {
            res.add(new ArrayList<>(chain));
            return;
        }
        // 2. 遍历节点
        for (int i=0; i<nums.length; i++) {
            // 3. 筛选节点
            if (!pb[i]) {
                chain.add(nums[i]);
                pb[i] = true;
                dfs(nums, pb, n+1, chain, res);
                pb[i] = false;
                chain.remove(chain.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1,2,3}));
    }
}
