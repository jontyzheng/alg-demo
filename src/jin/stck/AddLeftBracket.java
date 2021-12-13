package jin.stck;

import java.util.Stack;

/**
 * 算法 1.3.9
 * "字符串版的栈"
 * 原字符串：1+2)*3-4)*5-6)))
 * 最终结果：((1+2)*((3-4)*(5-6)))
 * */
public class AddLeftBracket {
    public String addLeftBracket(String exp) {
        Stack<String> stack = new Stack<>();
        // Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < exp.length(); i++) {
            String x = exp.charAt(i) + "";
            /**
             * 如果不是右括号：一个个入栈
             * */
            if (!x.equals(")")) {
                stack.push(x);
            } else {
                /**
                 * 如果遇到右括号：(假设给定数据规范，遇到右括号左边一定有元素)
                 * 1.从栈里弹出最近的两个操作数
                 * 2.构造字符串(左加左括号)
                 * 3.整个入栈--右括号入栈
                 * (将有左右括号包围的一个字符串作为一个元素)
                 * */
                Stack<String> rightStack = new Stack<>();
                rightStack.push(x);            // (
                String numB = stack.pop();     // 第二个操作数
                rightStack.push(numB);         // (2
                String op = stack.pop();
                rightStack.push(op);            // (2-
                String numA = stack.pop();      // 第一个操作数
                rightStack.push(numA);          // (2-1
                rightStack.push("(");      // (2-1)
                StringBuilder builder = new StringBuilder();
                while (rightStack.isEmpty()==false) {
                    builder.append(rightStack.pop());// (1-2)
                }
                String nextOp1 = builder.toString();
                stack.push(nextOp1);
            }
        }
        String pop = stack.pop();
        // System.out.println(pop);
        return pop;
    }

    public static void main(String[] args) {
        AddLeftBracket jonty = new AddLeftBracket();
        String exp = "1+2)*3-4)*5-6)))";
        String res = jonty.addLeftBracket(exp);
        System.out.println("最终结果：" + res);

    }
}
