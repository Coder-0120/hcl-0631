package Day3.Collections;
import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        // Arraylist
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
        Collections.sort(list);
        Collections.reverse(list2);
        for(int i=0;i< list.size();i++){
            System.out.print(list.get(i) + ",");
        }
        System.out.println("");
        for(int i=0;i< list2.size();i++){
            System.out.print(list2.get(i) + ",");
        }
        System.out.println();
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        Object[]arr=list.toArray();
        System.out.println(arr.length);
        System.out.println("printing using itertor");
        Iterator<Integer>itr=list.iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println(" Checking size and capacity");
        ArrayList<Integer>tlist=new ArrayList<>(20);
        System.out.println(tlist.size());
        tlist.addAll(list2);

        System.out.println(tlist.size());
        // Stack

        Stack<Integer>stk=new Stack<>();
        for(int i=0;i<10;i++){
            stk.push(i);
        }
        System.out.println("Stk size"+stk.size());
        System.out.println("Stk is empty"+stk.isEmpty());
        System.out.println("Stk peek"+stk.peek());
        stk.pop();
        System.out.println("Stk size after pop 1 element"+stk.size());



    }
}
