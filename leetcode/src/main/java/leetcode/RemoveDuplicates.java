package leetcode;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {

        if(nums.length ==0 || nums == null) return 0;
        int p = 0;
        int q = 1;
        while ( q < nums.length) {
            if (nums[p] != nums[q]){
                p++;
                nums[p] = nums[q];

            }
            q++;
        }
        return p+1;
    }
}
