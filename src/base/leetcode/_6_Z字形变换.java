package base.leetcode;

public class _6_Z字形变换 {
    public static void main(String[] args) {
        _6_Z字形变换 t = new _6_Z字形变换();
        String s = "PAYPALISHIRING";
        int n =3;

//        String s = "AB";
//        int n =1;
        System.out.println(t.convert(s, n));
//        PAHNAPLSIIGYIR
//        PAYPALISHIRING
    }

    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int x = 0;
        if (s.length() > numRows) {
            x = (s.length() - numRows) / (2 * numRows - 2);
        }
        int cn = 1 + x * 2;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder(cn);
        }

        boolean add = true;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            rows[j].append(s.charAt(i));
            if (add) {
                j++;
                if (j == numRows-1) {
                    add = false;
                }
            } else {
                j--;
                if (j == 0) {
                    add = true;
                }
            }
        }
        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0; i < rows.length; i++) {
            result.append(rows[i]);
        }
        return result.toString();
    }
}
