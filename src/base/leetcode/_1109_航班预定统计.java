package base.leetcode;

import java.util.Arrays;

public class _1109_航班预定统计 {
    public static void main(String[] args) {
        _1109_航班预定统计 t = new _1109_航班预定统计();
        int[][] bookings = {
                {1, 2, 10},
                {2, 3, 20},
                {2, 5, 25}
        };
        int n = 5;
        System.out.println(Arrays.toString(t.corpFlightBookings(bookings, n)));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
