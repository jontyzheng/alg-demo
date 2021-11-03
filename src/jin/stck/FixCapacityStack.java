package jin.stck;

/**
 * FixCapacityStack<Item>：泛型 就是一个关键字，没有对应的类
 * 数组结构
 */
public class FixCapacityStack<Item> {
    Item[] a;
    int N;
    public FixCapacityStack(int cap) {
        a = (Item[])new Object[cap];
    }

    public void push(Item newStr) {
        // 后期添加
        if (N == a.length)  resize(2*N);
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

    public void show() {
        for (int i = 0; i < N; i++) {
            System.out.print(" " + a[i] + " ");
        }
    }

    public void resize(int cap2) {
        Item[] items2 = (Item[]) new Object[cap2];
        for (int i = 0; i < N; i++) {
              items2[i] = a[i];
        }
        a = items2;
        // a 总是内置的数组
    }
}
