package base.leetcode;

import java.util.Stack;

public class _227_基本计算器II {
    public static void main(String[] args) {
        String exp = "(-4+3+(5+3))*-2";
        _227_基本计算器II calc = new _227_基本计算器II();
        System.out.println(calc.calculate(exp));
    }

    Stack<Integer> ns = new Stack<>();
    Stack<Character> ops = new Stack<>();

    int cur = 0;

    public int calculate(String s) {
        while (cur < s.length()) {
            int nextOpn = findNextOpn(s);
            if (nextOpn >= 0) {
                ns.push(nextOpn);
            } else {
                char op = (char) -nextOpn;
                switch (op) {
                    case '+':
                        ops.push(op);
                        break;
                    case '-':
                        ops.push(op);
                        int nextOpn1 = findNextOpn(s);
                        ns.push(-nextOpn1);
                        break;
                    case '*':
                        int np = findNextOpn(s);
                        if (np < 0 && -np == '-') {
                            np = -findNextOpn(s);
                        }
                        ns.push(ns.pop() * np);
                        break;
                    case '/':
                        int n1 = ns.pop();
                        int n2 = findNextOpn(s);
                        if (n2 < 0 && -n2 == '-') {
                            n2 = -findNextOpn(s);
                        }
                        ns.push(n1 / n2);
                        break;
                    case '(':
                        ops.push('(');
                        ns.push(0);
                        break;
                    case ')':
                        popAndCalcUntil();
                        break;
                }
            }
        }
        return ns.stream().reduce(Integer::sum).get();
    }

    private void popAndCalcUntil() {
        int sum = 0;
        char op;
        do {
            op = ops.pop();
            sum += ns.pop();

        } while (op != '(');
        ns.push(sum);
    }

    private int findNextOpn(String s) {
        char c = s.charAt(cur);
        if (!Character.isDigit(c)) {
            cur++;
            return -c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = cur; i < s.length(); i++) {
            c = s.charAt(i);
            if (!Character.isDigit(c)) {
                cur = i;
                return Integer.parseInt(sb.toString());
            }
            sb.append(c);
        }
        cur = s.length();
        return Integer.parseInt(sb.toString());
    }
}
