package se.string;

/**
 * ContainsChar
 */
public class ContainsChar {
    public static void main(String[] args) {
        String testStr = "123";
        char c = '2';
        boolean containsOrNot = testStr.contains("1");
        boolean containsOrNot2 = testStr.contains("e");
        boolean containsOrNot3 = testStr.contains(c+"");    // 此时换成char类型
        System.out.println(containsOrNot);
        System.out.println(containsOrNot2);
        System.out.println(containsOrNot3); // 是否包含该字符
    }
}
