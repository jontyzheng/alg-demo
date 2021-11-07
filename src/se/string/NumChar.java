package se.string;

/**
 * NumChar：
 */
public class NumChar {
    public static void main(String[] args) {
        String s = "1";
        int t = s.charAt(0) - 48;
        System.out.println("字符 1 的 ascii 码值：");
        System.out.println(t);
        int res = toInteger("12");
        System.out.println("调用字符串转整数的方法转 12：" + res);
    }

    static public int toInteger(String s) {
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - 48;
            // i：权重
            if (i == 0)
                number = value;
            else
                number = number * 10 + value;
        }
        return number;
    }
}
