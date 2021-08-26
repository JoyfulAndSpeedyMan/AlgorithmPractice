package base.leetcode;

import java.util.Arrays;

public class _881_救生艇 {
    public static void main(String[] args) {
        _881_救生艇 t = new _881_救生艇();
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        System.out.println(t.numRescueBoats(people, limit));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int count=0;
        while (i <= j) {
            if(people[i]+people[j]<=limit)
                i++;
            j--;
            count++;
        }
        return count;
    }
}
