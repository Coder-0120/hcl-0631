package Day3.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CollectionExample {
    public static void main(String[] args) {
        // list
        ArrayList<Integer>list=new ArrayList<>();
        ArrayList<Integer>list2=new ArrayList<>(Arrays.asList(3,4,5,6,7,8,9,10));
        list.add(1);
        list.add(1,2); // add 2 @ index 1
        list.addAll(list2);
        System.out.println("List before updating");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + ",");
        }
        System.out.println("");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("List after Update..");
        list.set(0,1000);

        for(int i=0;i< list.size();i++){
            System.out.print(list.get(i) + ",");
        }
        System.out.println("element at this index "+list.get(0));
        System.out.println("list is empty "+list.isEmpty());
        System.out.println("list contains 5 "+list.contains(5));
        System.out.println("element's index  "+list.indexOf(400)); // give -1 if not exist
        System.out.println("element last index is  "+list.lastIndexOf(9));
        list.remove(0); // to remove element @ particular index
        list.retainAll(Arrays.asList(10,2,3,4,5,5,6)); // it only keeps these element we specify in it
        System.out.println("size is "+ list.size());



        // HashSet
//        HashSet<Integer>set=new HashSet<>();
//        set.add(10);
//        set.add(10);
//        set.add(10);
//        System.out.println(set.size());


    }
}
