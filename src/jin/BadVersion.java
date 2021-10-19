package jin;

/**
 * BadVersion：你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * https://leetcode-cn.com/problems/first-bad-version/
 */
public class BadVersion {
    static String[] str = {"-","bad"};

    public static void main(String[] args) {
        int pos = firstBadVersion(2);
        System.out.println(pos);
    }

    public static  boolean isBadVersion(int index) {
        return str[index].equals("bad");
    }

    static public int firstBadVersion(int n) {
        if (n <= 1)
            return n;
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // <-- 【left, mid】
                right = mid;
            } else {
                // -->  (mid, right】
                left = mid+1;
            }
        }
        return left;    // 最后浓缩成一个点
    }
}
/**
 * 今天学到的，不能用（left+right）/2形式，当left和right都是int，
 * 两个值的初始值都超过int限定大小的一半，那么left+right就会发生溢出，所以应该用left+(right-left)/2来防止求中值时候的溢出。
 * https://leetcode-cn.com/problems/first-bad-version/comments/1060944
 * */
