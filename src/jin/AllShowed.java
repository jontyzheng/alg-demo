package jin;

/**
 * AllShowed：俩字符串，要判断前一个可以通过后一个抽离几个字符获取
 * 换句话说，前者在第二个字符串中顺序不变地出现过
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * s：子串，t：堆串
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class AllShowed {
    static public boolean isSubsequence(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        if (ss.length == 0)
            return true;    // 子串为空，必有
        if (tt.length == 0)
            return false;   // 堆串为空，必无
        int sCnt = 0;
        boolean allShowed = false;
        // 在长串中遍历前面字符串的字符，只有遇到了才更新计数器
        for (int i = 0; i < t.length(); i++) {
            char s1 = ss[sCnt];
            if (tt[i] == s1) {
                sCnt++;
                if (sCnt == s.length())
                    break;
            }
        }
        // 当计数器加满时，说明前者里的每一个字符都依次在第二个字符串中出现过
        if (sCnt == s.length())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String s = "b";
        String t = "abc";
        System.out.println(isSubsequence(s, t));
    }
}
/**
 * 效果：
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 84.76% 的用户
 * */