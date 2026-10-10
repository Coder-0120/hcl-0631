package Day4;

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer,String>map=new TreeMap(); // sorted itselg
        map.put(1,"Aman");
        map.put(13,"Raj");
        map.put(2,"Anshul");
        map.put(4,"xy");
        System.out.println(map.get(3));
        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("Anshul"));
        System.out.println(map.firstEntry());
        System.out.println(map.lastEntry());
        System.out.println(map.size());
        map.remove(2);
        for(int k:map.keySet()){
            System.out.println(k + " "+map.get(k));
        }


    }
}
