package jin.string;

/**
 * 字符串模拟加法
 * https://leetcode-cn.com/problems/add-strings/
 * (由于字符串字面值的)
 * */
public class IntStringSum {
    public String addStrings(String num1, String num2) {
        // return Integer.valueOf(num1) + Integer.valueOf(num2) + "";
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int add = 0;    // 用一个变量存储末位数相加的和
        StringBuilder builder = new StringBuilder();
        /**
         * 情形1：i 提前加完
         * 情形2：j 提前加完
         * 情形3：一个数比数字的位数多
         * */
        while (index1 >= 0 || index2 >= 0 || add != 0) {
            // 每次个位数相加总不会越界，结果用 add 暂存
            int x = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int y = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int result = x + y + add;   // 累加上一步的 add(进位)
            add = result / 10;    // add 只取进位
            result = result % 10; // 追加位取个位
            builder.append(result);
            // 将每次个位数累加得到的个位逐个追加
            index1--;
            index2--;
        }
        builder.reverse();  // 倒序
        return builder.toString();
    }


    public static void main(String[] args) {
        IntStringSum focus = new IntStringSum();
        String s = focus.addStrings("6913259244", "71103343");
        System.out.println("6913259244+71103343=" + s);
        /**
         * int 内存空间只有 64 位，最多可存储的数字区间是从 -2^31 到 2^31-1
         * 也就是 21百万
         * 69_1325_9244 本身就超出 int 的可表示范围了
         * */
        long a = 69_1325_9244L;
        long b = 71103343;
        long l = Long.valueOf(a) + Long.valueOf(b);
        System.out.println(l+"");
    }
}
/**
 * 执行用时： 2 ms , 在所有 Java 提交中击败了 94.51% 的用户
 * */
