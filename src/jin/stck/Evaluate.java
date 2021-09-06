package jin.stck;

import java.util.Scanner;
import java.util.Stack;

/**
 * Evaluate：(1+((2+3)*(4*5)))
 * 一个实时看到栈里面的括号和数字的 demo
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (!s.equals("=")) {
                // s：下一个字符
                switch (s) {
                    // 当遍历到运算符时，压入 ops 栈
                    case "(":
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "sqrt":
                        ops.push(s);
                        System.out.println("push+1");
                        System.out.print("ops:");
                        peekStringStack(ops);
                        break;
                    case ")": {
                        // 当遍历到 ) 时，此时为第一次遇到优先级最高的一对，弹出 op 和 val 开始运算
                        String op = ops.pop();
                        System.out.println("ops：pop+1");
                        System.out.print("ops:");
                        peekStringStack(ops);
                        Double val = vals.pop();
                        System.out.println("vals：pop+1");
                        System.out.print("vals:");
                        peekDoubleStack(vals);
                        if (op.equals("+"))
                            val += vals.pop();
                        else if (op.equals("-"))
                            val = vals.pop() - val;
                        else if (op.equals("*"))
                            val = vals.pop() * val;
                        else if (op.equals("/"))
                            val = vals.pop() / val;
                        else if (op.equals("sqrt"))
                            val = Math.sqrt(val);
                        vals.push(val);
                        System.out.println("vals：push+1");
                        System.out.print("vals:");
                        peekDoubleStack(vals);
                    }
                    break;
                    default:
                        // 当遍历到既不是运算符，也不是 ) 剩下的只有数字了（输入规范的前提下）
                        vals.push(Double.valueOf(s));
                        System.out.println("push+1");
                        System.out.print("vals:");
                        peekDoubleStack(vals);
                }
            } else {
                System.out.println("结果：" + vals.pop());
            }
        }
    }

    static void peekStringStack(Stack<String> stack) {
        for (String s : stack) {
            System.out.print(s + "");
        }
        System.out.println();
    }

    static void peekDoubleStack(Stack<Double> stack) {
        for (Double s : stack) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
