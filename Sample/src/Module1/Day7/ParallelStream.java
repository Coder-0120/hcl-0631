package Module1.Day7;

import java.util.ArrayList;
import java.util.Arrays;

public class ParallelStream {
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
        list.parallelStream().
                forEach(System.out::println); // order is not guaranteed
        System.out.println("Normal stream");
        list.stream().
            forEach(System.out::println); // order is guaranteed

        list.parallelStream().
                forEach(n->{
                    System.out.println(n + " "+ Thread.currentThread().getName());
                });

        Thread t1=new Thread(()->{
            System.out.println("Thread 1");
        });
        Thread t2=new Thread(()->{
            System.out.println("Thread 2");
        });
//        The order can change because both threads execute independently.
        t1.start();
        t2.start();
    }
}
