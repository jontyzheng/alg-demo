package jin.recursion;

//
public class RecurDemo {
    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
        // 计算出p和q的余数后让q作被除数，r作除数
        // 继续运算，直到q%r计算出了终点值最后才传递返回给结果
        // 而让方法停止的条件也是，当后一个数字变成0，也就是除数r变成0
        // 除数变成0正是最后整除的一步。
    }
}
