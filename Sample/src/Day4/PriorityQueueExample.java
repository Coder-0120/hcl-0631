package Day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer>list=new ArrayList<>(Arrays.asList(10,2,1,45,600,453));
        pq.addAll(list);
//        System.out.println(pq.peek());
//        System.out.println(pq.size());
//        while(!pq.isEmpty()){
//            System.out.println(pq.poll());
//        }
        pq.remove(2); // remove specific element
        System.out.println(pq.size());
        System.out.println(pq.contains(45));
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
        PriorityQueue<String>p=new PriorityQueue<>((a,b)->{
            int result=Integer.compare(a.length(),b.length());
            return result!=0?result:a.compareTo(b);
        });

        p.add("kiwi");
        p.add("Mango");
        p.add("Apple");
        p.add("Banana");
        p.add("Grapes");

//        System.out.println(p.peek());
//        System.out.println(p.poll());
        System.out.println("-----");
        while(!p.isEmpty()){
            System.out.println(p.poll());
        }



    }
}
