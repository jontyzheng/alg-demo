package se.list;

import java.util.ArrayList;
import java.util.List;

/**
 * DoubleList：二维List声明的方式
 * List<List<Integer>> list = new ArrayList<>();
 */
public class DoubleList {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        List<Integer> seq2 = new ArrayList<>();
        seq.add(1);
        seq2.add(2);
        list.add(seq);
        list.add(seq2);
        System.out.println(list);

    }
}
