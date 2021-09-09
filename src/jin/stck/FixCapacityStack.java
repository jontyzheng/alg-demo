package jin.stck;

/**
 * FixCapacityStack<Item>：泛型 就是一个关键字，没有对应的类
 */
public class FixCapacityStack<Item> {
    Item[] a;
    int N;
    public FixCapacityStack(int cap) {
        a = (Item[])new Object[cap];
    }

    public void push(Item newStr) {
        a[N++] = newStr;
    }

    public int size() {
        return N;
    }

    public boolean hasEmpty() {
        return N == 0;
    }

    public Item pop() {
        return a[--N];
    }

    public void inStack() {
        for (int i = 0; i < N; i++) {
            System.out.print(" " + a[i] + " ");
        }
    }
}
