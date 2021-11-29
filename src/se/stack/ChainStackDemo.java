package se.stack;

/**
 * 链条栈の应用
 * */
public class ChainStackDemo {
    public static void main(String[] args) {
        ChainStack<String> stack = new ChainStack<String>();
        stack.push("123");
        stack.push("234");
        System.out.println("chainStack 的长度是：" + stack.size());
        String pop = stack.pop();
        System.out.println("chainStack 出栈的(链头)：" + pop);
        System.out.println("出栈后的长度：" + stack.size());
        String peek = stack.peek();
        System.out.println("chainStack 的栈顶元素是(链头)：" + peek);
        System.out.println("peek 后的长度：" + stack.size());

    }
}
