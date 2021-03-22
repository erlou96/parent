package leetcode;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        int[] res = new int[2];
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = i;
                res[1] = map.get(nums[i]);
                return res;
            }else {
                map.put(target-nums[i],i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        Set<Character> set = new HashSet();
        List<Integer> list = new ArrayList<>();
        Queue<Integer> link = new LinkedList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        Collections.sort(list);

        System.out.println(list);
        int[] res = new int[]{1,3,7,4,5,7,6};
        String str = new String();
        int dp[] = new int[4];
        str.length();
        int[][] dump = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        Arrays.sort(dump, (v1, v2) -> {
            if(v1[0] == v2[0]) {
                return v2[1] - v1[1];
            }
            return v1[0] - v2[0];
        });
        for (int i = 0; i < dump.length ; i++) {
            for (int j = 0; j < dump[i].length; j++) {
                System.out.print(dump[i][j]);
            }
            System.out.println();
        }
    }
}
