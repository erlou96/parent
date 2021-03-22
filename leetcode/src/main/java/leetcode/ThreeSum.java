package leetcode;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
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
        System.out.println(Arrays.toString(p));
        System.out.println(Arrays.toString(pb));
        dfs(3,p,pb,new ArrayList<Integer>(),res);
        return res;
    }
    void dfs(int length, int[] p,int[] pb,List<Integer> chain,List<List<Integer>> res) {
        if (chain.size() == length) {
            if ((chain.get(0)+chain.get(1)+chain.get(2)) == 0) {
                List<Integer> tmp = chain;
                Collections.sort(tmp);
                System.out.println(tmp);
                //if (!res.contains(tmp)) {
                    res.add(new ArrayList(chain));
                //}

            }
            return;
        }
        for (int i=0; i<p.length; i++) {
            int c = p[i];
            if (pb[i] > 0) {
                --pb[i];
                chain.add(c);
                dfs(3,p, pb, chain, res);
                pb[i]++;
                chain.remove(chain.size()-1);
            }
        }
    }
    public List<String> dfs() {
        return null;
    }
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("nihao");
            }
        };
        thread.start();
    }
}
