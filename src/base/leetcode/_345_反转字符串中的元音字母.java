package base.leetcode;

import java.util.HashSet;

public class _345_反转字符串中的元音字母 {
    public static void main(String[] args) {
        _345_反转字符串中的元音字母 v = new _345_反转字符串中的元音字母();
        String s = "hello";
        System.out.println(v.reverseVowels(s));
    }

    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        StringBuilder sb = new StringBuilder(s);
        int i=0;
        int j = s.length() - 1;
        while (i < j) {
            while (j > i && !set.contains(Character.toLowerCase(sb.charAt(j))))
                j--;
            if(i==j)
                break;
            while (j > i && !set.contains(Character.toLowerCase(sb.charAt(i))))
                i++;
            if(i==j)
                break;
            char t = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, t);
            i++;
            j--;
        }
        return sb.toString();
    }
}
