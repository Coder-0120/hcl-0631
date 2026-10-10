package Day4;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        System.out.println(q.peek()); //  not give any error if q is empty
//        System.out.println(q.element()); // give error if q is empty

        System.out.println(q);
        q.offer(10);
        q.offer(20);
        q.offer(30);
        System.out.println(q);
        System.out.println(q.peek()); //View the front element
        System.out.println(q.poll()); // Remove the front element

        q.remove();
        System.out.println(q);

    }
}
