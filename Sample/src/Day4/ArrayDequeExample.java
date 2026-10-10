package Day4;

import java.util.ArrayDeque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        ArrayDeque<Integer>ard=new ArrayDeque<>();
        ard.push(10);
        ard.push(20);
        ard.push(30);
        System.out.println(ard);
        ard.addFirst(100);
        ard.addLast(500);
        ard.offerFirst(101);
        ard.offerLast(501);
        ard.peekFirst();
        ard.peekLast();
        System.out.println(ard);

    }
}
