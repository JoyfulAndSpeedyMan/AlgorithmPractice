package base.leetcode;

import java.util.Arrays;

public class _152_乘积最大子数组 {
    public static void main(String[] args) {
        _152_乘积最大子数组 s = new _152_乘积最大子数组();
        int[] nums = {2, 3, -2, 4};
        System.out.println(s.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];

        max[0] = nums[0];
        min[0] = nums[0];

        for (int i = 1; i < len; i++) {
            int n = nums[i];
            max[i] = max(max[i - 1] * n, min[i - 1] * n, n);
            min[i] = min(max[i - 1] * n, min[i - 1] * n, n);
        }
        return Arrays.stream(max).max().getAsInt();
    }

    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
