package Day4;

import java.util.Hashtable;

public class HashTableExample {
    public static void main(String[] args) {
        Hashtable<Integer,String>hts=new Hashtable<>();
        hts.put(1,"Aman");
        hts.put(13,"Raj");
        hts.put(2,"Anshul");
        hts.put(4,"xy");
        for(int key:hts.keySet()){
            System.out.println(key + " "+ hts.get(key));
        }
        System.out.println(hts);
        hts.put(101,"Anshul Verma");
        System.out.println(hts);
        System.out.println(hts.containsKey(102));
        System.out.println(hts.containsValue("Anshul"));
        hts.remove(101);
        System.out.println(hts);

    }
}
