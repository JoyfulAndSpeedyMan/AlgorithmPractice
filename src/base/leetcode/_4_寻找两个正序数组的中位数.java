package base.leetcode;

public class _4_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        _4_寻找两个正序数组的中位数 t = new _4_寻找两个正序数组的中位数();

        int[] nums1 = {1, 2}, nums2 = {3, 4};
//        int[] nums1 = {1}, nums2 = {2, 3, 4, 5, 6, 7};

        double result = t.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int k = len / 2;
        boolean two = len % 2 == 0;
        if (!two) {
            k++;
        }
        int ib = 0;
        int jb = 0;
        int i, j;
        i = j = k / 2 - 1;
        while (k > 1) {
            if (ib >= nums1.length) {
                return two ? (nums2[jb + k - 1] + nums2[jb + k]) / 2.0 : nums2[jb + k - 1];
            }
            if (jb >= nums2.length) {
                return two ? (nums1[ib + k - 1] + nums1[ib + k]) / 2.0 : nums1[ib + k - 1];
            }
            int ii = ib + i;
            int jj = jb + j;
            int n1 = ii >= nums1.length ? nums1[nums1.length - 1] : nums1[ii];
            int n2 = jj >= nums2.length ? nums2[nums2.length - 1] : nums2[jj];

            if (n1 <= n2) {
                int ex = ii >= nums1.length ? nums1.length - ib : k / 2;
                k -= ex;
                ib += ex;
            } else {
                int ex = jj >= nums2.length ? nums2.length - jb : k / 2;
                k -= ex;
                jb += ex;
            }
            i = j = k / 2 - 1;
        }

        double sum = 0;
        int n = 0;
        int findN = two ? 2 : 1;
        while (n < findN) {
            if (ib >= nums1.length) {
                sum += nums2[jb++];
            } else if (jb >= nums2.length) {
                sum += nums1[ib++];
            } else {
                if (nums1[ib] <= nums2[jb]) {
                    sum += nums1[ib++];
                } else {
                    sum += nums2[jb++];
                }
            }
            n++;
        }
        return sum / findN;
    }


}
