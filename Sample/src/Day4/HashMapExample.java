package Day4;

import java.util.HashMap;

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




    }
}
