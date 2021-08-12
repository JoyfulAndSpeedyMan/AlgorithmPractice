package base.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class _239_滑动窗口最大值 {
    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int k = 3;

//        int[] nums = {7, 2, 4};
//        int k = 2;

        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
        System.out.println(Arrays.toString(nums));
        _239_滑动窗口最大值 s = new _239_滑动窗口最大值();
        System.out.println(Arrays.toString(s.maxSlidingWindow2(nums, k)));

    }

    /**
     * 优先队列
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k >= nums.length)
            return new int[]{Arrays.stream(nums).max().getAsInt()};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        for (int i = 0; i < k - 1; i++)
            queue.offer(new int[]{nums[i], i});
        int len = nums.length - k + 1;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int j = i + k - 1;
            queue.offer(new int[]{nums[j], j});
            while (queue.peek()[1] < i)
                queue.poll();
            ans[i] = queue.peek()[0];
        }
        return ans;
    }

    /**
     * 双端队列
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (k >= nums.length)
            return new int[]{Arrays.stream(nums).max().getAsInt()};
        int len = nums.length - k + 1;
        int[] ans = new int[len];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k - 1; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offer(i);
        }

        for (int i = 0; i < len; i++) {
            int j = i + k - 1;
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j])
                deque.pollLast();
            deque.offer(j);
            while (deque.peek() < i)
                deque.poll();
            ans[i] = nums[deque.peek()];
        }
        return ans;
    }
}
