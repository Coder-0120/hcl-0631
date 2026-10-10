package Day4;
import  java.util.LinkedList;
public class LinkedListExample {
    public static void main(String[] args) {
       LinkedList<Integer> list=new LinkedList<>();
       list.add(10);
       list.add(20);
       list.add(30);
        System.out.println(list);
        list.remove(2);
        list.addFirst(100);
        list.addLast(200);
        list.add(1,500);
        System.out.println(list);

        // acceess element
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(0));

        // update
        list.set(2,50000);
        list.remove();  // delete firstOne
        list.remove(1); // delte index element
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        System.out.println(list.contains(20));
        System.out.println(list.indexOf(50000));
        System.out.println(list.lastIndexOf(500));

    }
}
