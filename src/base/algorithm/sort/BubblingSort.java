package base.algorithm.sort;

public class BubblingSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    k = j;
                }
            }
            if (k != i) {
                int t = arr[i];
                arr[i] = arr[k];
                arr[k] = t;
            }
        }
        return arr;
    }
}
