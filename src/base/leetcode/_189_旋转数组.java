package base.leetcode;

import java.util.Arrays;

public class _189_旋转数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        _189_旋转数组 s = new _189_旋转数组();
        System.out.println(Arrays.toString(nums));
        s.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
    }
}
