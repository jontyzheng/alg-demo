package jin.stck;

/**
 * FixCapacityStackOfStirng：
 */
public class FixCapacityStackOfString {
    String[] a;
    int N;
    public FixCapacityStackOfString(int cap) {
        a = new String[cap];
    }

    public void push(String newStr) {
        a[N++] = newStr;
    }

    public int size() {
        return N;
    }

    public boolean hasEmpty() {
        return N == 0;
    }

    public String pop() {
        return a[--N];
    }

    public void inStack() {
        for (int i = 0; i < N; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
