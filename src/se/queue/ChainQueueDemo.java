package se.queue;

public class ChainQueueDemo {
    public static void main(String[] args) {
        ChainQueue<String> queue = new ChainQueue<>();
        queue.in("aaa");
        queue.in("bbb");
        queue.toString();

    }
}
