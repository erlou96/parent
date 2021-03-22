package leetcode;

public class MaxArea {

    public int maxArea(int[] height) {

        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int sum = 1;
        int ans = 1;
        while (left < right) {
            sum = Math.min(height[left],height[right]) * (right-left);
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(new int[]{2,3,4,5,18,17,6}));
    }
}
