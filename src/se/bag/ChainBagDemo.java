package se.bag;

import java.util.Iterator;

public class ChainBagDemo {
    public static void main(String[] args) {
        ChainBag<String> bag = new ChainBag<>();
        bag.add("456");
        bag.add("678");

        Iterator<String> iterator = bag.iterator();
        System.out.println(iterator.next());    // 因为是随机访问，iterator 也是随机遍历
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
