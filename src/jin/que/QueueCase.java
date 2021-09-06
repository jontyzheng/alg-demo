package jin.que;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 队列 demo：数字怎么输入的就怎么输出的
 * */
public class QueueCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> q = new LinkedList<Integer>();

        System.out.println("请【从左往右按顺序输入】一组数字：");

        int cnt = 0;
        while (cnt < 5) {
            q.add(scanner.nextInt());
            cnt++;
        }
        System.out.println("结束输入");
        int size = q.size();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = q.poll();    // 返回值为 T 的出队方法
        }

        for(int i : a) {
            System.out.print(i + " ");
        }
    }
}
