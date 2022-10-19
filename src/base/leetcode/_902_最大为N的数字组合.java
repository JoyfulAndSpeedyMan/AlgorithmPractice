package base.leetcode;

import java.util.Arrays;

/**
 * 81 / 84 个通过测试用例 <br>
 * 最后执行的输入： "1","5","7","8"]<br>
 * 10212<br>
 * 答案预期输出：340 <br>
 * 实际输出：356 <br>
 */
public class _902_最大为N的数字组合 {

    int[] digits;
    int n;
    int[] powerNumbers;
    int nb;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            this.digits[i] = Integer.parseInt(digits[i]);
        }
        this.n = n;
        nb = 0;
        int t = n;
        while (t != 0) {
            t /= 10;
            nb++;
        }
        powerNumbers = new int[nb];
        powerNumbers[0] = 1;
        int sum = 0;
        for (int i = 1; i < powerNumbers.length; i++) {
            powerNumbers[i] = powerNumbers[i - 1] * digits.length;
            sum += powerNumbers[i];
        }
        powerNumbers[0] = 0;
        int i = calcLess(n);
        return sum + i;
    }

    public int calcLess(int num) {
        if (num == 0) {
            return 0;
        }
        int h1 = 0;
        int t = num;
        int nb = 0;

        while (t != 0) {
            h1 = t % 10;
            nb++;
            t /= 10;
        }
        if (nb == 1) {
            return findLE(num);
        }
        int powMax = (int) Math.pow(10, nb - 1);
        int n = num % powMax;
        int factor = 1;
        if(n/ (powMax * 1.0) < 0.1){
            factor = 0;
        }
        int i = Arrays.binarySearch(digits, h1);
        return findLE(h1 - 1) * powerNumbers[nb - 1] + (i >= 0 ? calcLess(n) : 0) * factor;
    }

    public int findLE(int num) {
        int count = 0;
        for (int digit : digits) {
            if (digit <= num) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }


    public static void main(String[] args) {
//        String[] digits = {"1", "4", "9"};
//        int n = 2000000203;
//        String[] digits = {"7"};
//        int n = 8;
//        String[] digits = {"5", "6"};
//        int n = 19;
//        String[] digits = {"9"};
//        int n = 55;
//        String[] digits = {"1", "3", "5", "7"};
//        int n = 100;
//        String[] digits = {"5", "7", "8"};
//        int n = 59;

//        String[] digits = {"3", "4", "5", "6"};
//        int n = 64;

//        String[] digits = {"1"};
//        int n = 834;

//        String[] digits = {"1","5","7","8"};
//        int n = 10212;

        String[] digits = {"1","2","3","6"};
        int n = 4023;

        _902_最大为N的数字组合 a902最大为N的数字组合 = new _902_最大为N的数字组合();
        int num = a902最大为N的数字组合.atMostNGivenDigitSet(digits, n);
        System.out.println(num);
    }

}
