package base.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        int[][] arrs = {
                {7, 56, 80, 56, 80, 25, 80, 46, 87, 48, 83}
        };
        arrs = randSource();
        Sort sort = new QuickSort();

        for (int i = 0; i < arrs.length; i++) {
            int[] arr = arrs[i];
            int[] source = copyOf(arr);
            int[] target = copyOf(arr);
            Arrays.sort(target);

            System.out.println("sort : " + Arrays.toString(source));
            System.out.println("target : " + Arrays.toString(target));
            int[] result = sort.sort(source);
            System.out.println("result : " + Arrays.toString(result));
            System.out.println();
            if (!Arrays.equals(target, result)) {
                System.out.println("error");
                return;
            }
        }
        System.out.println("测试通过");
    }

    public static int[] copyOf(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    public static int[][] randSource() {
        Random random = new Random();
        int n = 1000, max = 100, maxLength = 30;
        int arrs[][] = new int[n][];
        for (int i = 0; i < n; i++) {
            int len = random.nextInt(maxLength);
            arrs[i] = new int[len];
            for (int j = 0; j < len; j++) {
                arrs[i][j] = random.nextInt(max);
            }
        }
        return arrs;
    }
}
