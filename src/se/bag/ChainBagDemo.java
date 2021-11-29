package se.bag;

import java.util.Iterator;

public class ChainBagDemo {
    public static void main(String[] args) {
        ChainBag<String> bag = new ChainBag<>();
        bag.add("456");
        bag.add("678");

        Iterator<String> iterator = bag.iterator();
        System.out.println(iterator.next());    // 因为是随机访问，iterator 也是随机遍历
        System.out.println(iterator.next());    // 还有一个实现迭代器的原因：背包没有 pop 方法
        System.out.println(iterator.hasNext());

        // 小数除以大数
        int res = 1 / 2;
        System.out.println("1/2=" + res);
    }
}
