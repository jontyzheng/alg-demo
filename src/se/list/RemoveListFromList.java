package se.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * removeAll()
 * addAll()
 * */
public class RemoveListFromList {
    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5};
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, a);

        // list1
        Integer[] b = {1,2,3};
        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, b);
        // list2
        list.removeAll(list2);
        System.out.println(list.toString());
    }
}
