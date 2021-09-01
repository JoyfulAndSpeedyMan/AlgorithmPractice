package base.leetcode;

import java.util.Arrays;

public class _1480_一维数组的动态和 {
    public static void main(String[] args) {
        _1480_一维数组的动态和 t = new _1480_一维数组的动态和();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(t.runningSum(nums)));
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[i] = nums[i - 1] + nums[i];
        return nums;
    }
}
