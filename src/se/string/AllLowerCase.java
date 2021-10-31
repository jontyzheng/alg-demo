package se.string;

/**
 * AllLowerCase：将带有大小写的字符串一律转为小写的
 * 小写的字母在 ascii 值比较好匹配
 */
public class AllLowerCase {
    public static void main(String[] args) {
        String s = "Hello";
        String s1 = s.toLowerCase();
        System.out.println(s+"转小写字母后：" + s1);
    }
}
