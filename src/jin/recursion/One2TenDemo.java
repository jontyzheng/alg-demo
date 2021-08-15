package jin.recursion;

// 从 1 到 10 输出的另类方式
public class One2TenDemo {
    static void print(int N) {
        if (N != 0) {
            System.out.print("\t" + N);
            print(N-1);
        }
        return;
    }

    public static void main(String[] args) {
        print(10);
        print(100000);
    }
}
