package Module1.Day6.Stream;

import java.util.ArrayList;
import  java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>(Arrays.asList(11,2,3,4,5,6,7,8));
        ArrayList<String >list2=new ArrayList<>(Arrays.asList("Apple","Mango","grapes","kiwi","Apple","kiwi"));
        ArrayList<String >list3=new ArrayList<>(Arrays.asList("Aman","Anshul","Arun","Akash","Ashish"));

//        // print only even no
//        list.stream().filter(n->n%2==0).forEach(x-> System.out.println(x));
//
//        // print fruits of even length only
//        list2.stream().filter(n->n.length()%2==0).forEach(x-> System.out.println(x));
//        // print list element by modify by multiply by 2
//        list.stream().map(x->x*2).forEach(x-> System.out.println(x));

//        System.out.println(list.stream().count());
//// sorted list
//        list.stream().sorted().forEach(x-> System.out.println(x));
//// add Fruits is in starting of fruits list
//        list2.stream().map(f->"Fruits is "+ f).forEach(x-> System.out.println(x));
//  // print fruits which starts with A
//        list2.stream().filter(f->f.startsWith("A")).forEach(x-> System.out.println(x));
//        List<Integer>newlist=list.stream().collect(Collectors.toList());
//        System.out.println(newlist);
//
//        list2.stream().distinct().forEach(System.out ::println);
//        list.stream().limit(3).forEach(System.out::println); // take only the first n elements
//        list.stream().skip(3).forEach(System.out::println); // skip only the first n elements
//        list.stream().min(Integer::compareTo).ifPresent(System.out::println);
//        list.stream().max(Integer::compareTo).ifPresent(System.out::println);
//        int sum=list.stream().mapToInt(Integer::intValue).sum();
//        System.out.println(sum);
//
//        list.stream().mapToDouble(Integer::doubleValue).average().ifPresent(System.out::println);
//        // filer name which starts with A and print in sorted format
//        list3.stream().filter(x->x.startsWith("A")).sorted().forEach(System.out::println);

//        // fruits to upper case amd lowercase
//list3.stream().map(String::toUpperCase).forEach(System.out::println);
//list3.stream().map(String::toLowerCase).forEach(System.out::println);

// decreasing alphabetical order
//        list3.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // give square after printing each element
        list.stream().
                peek(n-> System.out.println("Number is "+n)).
                map(n->n*n).
                forEach(System.out :: println);





    }
}
