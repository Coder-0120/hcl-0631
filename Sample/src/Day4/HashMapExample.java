package Day4;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class HashMapExample {
    public static void main(String[] args) {
        int[]arr=new int[]{1,2,3,4,21,3,1,3,4};
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int x:arr){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int key:map.keySet()){
            System.out.println("freq of "+key +"  is "+map.get(key));
        }
        HashMap<Integer, String> map1 = new HashMap<>();

        map1.put(101, "Rahul");
        map1.put(102, "Anshul");
        map1.put(103, "Priya");

        System.out.println(map1);
        map1.put(101,"Anshul Verma");
        System.out.println(map1);
        System.out.println(map1.containsKey(102));
        System.out.println(map1.containsValue("Anshul"));
        map1.remove(101);
        System.out.println(map1);

        LinkedHashMap<Integer,String>map3=new LinkedHashMap<>();
        map3.put(10,"aman");
        map3.put(2,"rahul");
        map3.put(21,"krish");
        map3.put(12,"rohit");
        map3.put(5,"ansh");
        for(int key:map3.keySet()){
            System.out.println("key of "+key +"  is "+map3.get(key));
        }




    }
}
