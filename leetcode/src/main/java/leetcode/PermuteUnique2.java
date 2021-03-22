package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全排列 II
 */
public class PermuteUnique2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        for (int i:nums) {
            map.put(i, map.containsKey(i) ? map.get(i)+1:1);
        }
        int[] p = new int[map.size()];
        int[] pb = new int[map.size()];
        int[] index = new int[1];
        map.forEach((k,v) -> {
            p[index[0]] = k;
            pb[index[0]] = v;
            index[0]++;
        });
        List<List<Integer>> res = new ArrayList();
        if (nums.length <= 0) {
            return res;
        }
        int length = nums.length;
        dfs(p,pb,length,new ArrayList<Integer>(),res);
        return res;
    }
    void dfs(int[] p,int[] pb,int length,List<Integer> chain,List<List<Integer>> res) {
        if(chain.size() == length) {
            res.add(new ArrayList(chain));
            return;
        }
        for(int i=0; i<p.length; i++) {
            if(pb[i] > 0) {
                pb[i]--;
                chain.add(p[i]);
                dfs(p,pb,length,chain,res);
                chain.remove(chain.size()-1);
                pb[i]++;
            }
        }
    }

    public static void main(String[] args) {
        PermuteUnique2 p = new PermuteUnique2();
        System.out.println(p.permuteUnique(new int[]{1,2,1,3}));
    }
}
