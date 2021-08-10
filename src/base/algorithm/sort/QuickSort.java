package base.algorithm.sort;

/**
 * @author Shipin
 * 快速排序
 */
public class QuickSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public void sort(int[] arr, int start, int end) {
        if (end > arr.length || start >= end)
            return;
        int t = arr[start];
        int i = start, j = end;
        while (i < j) {
//            print("", start, end, i, j);
            while (i < j && arr[j] >= t) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] < t) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = t;
        sort(arr, 0, i - 1);
        sort(arr, i + 1, end);

    }

    void print(String prefix, int start, int end, int i, int j) {
        System.out.printf("%s: start= %d, end=%d, i=%d,j=%d\n", prefix, start, end, i, j);
    }
}
