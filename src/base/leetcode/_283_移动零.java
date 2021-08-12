package base.leetcode;

import java.util.Arrays;

public class _283_移动零 {
    public static void main(String[] args) {
        int[] arr = {6, 1, 0, 3, 12};
        _283_移动零 s = new _283_移动零();
        System.out.println(Arrays.toString(arr));
        s.moveZeroes2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void moveZeroes2(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return;
        int i, j;
        i = j = 0;
        while (j < len) {
            if (nums[j] != 0) {
                if (i != j)
                    swap2(nums, i, j);
                i++;
            }
            j++;
        }
    }

    /**
     * 位运算交换
     */
    public void swap2(int[] nums, int i, int j){
        nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];
    }
}
