package base.algorithm.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 2, 9, 8, 10, 32, 53, 22};
        bubbling(copyOf(arr));
    }
    public static int [] copyOf(int [] arr){
        return Arrays.copyOf(arr, arr.length);
    }

    public static void bubbling(int [] arr){
        BubblingSort bubblingSort = new BubblingSort();
        arr = bubblingSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
