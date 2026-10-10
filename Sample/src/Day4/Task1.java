package Day4;

import java.util.ArrayList;
import java.util.Collections;

class Student{
    String name;
    int age;
    int roll_no;
    int marks;
    Student(String name,int age,int roll_no,int marks){
        this.name=name;
        this.age=age;
        this.roll_no=roll_no;
        this.marks=marks;
    }
}
public class Task1 {
    public static void main(String[] args) {
        ArrayList<Student>list=new ArrayList<>(10);
        list.add(new Student("Aman",20,1,98));
        list.add(new Student("Anshul",21,2,100));
        list.add(new Student("Rahul",18,3,94));
        list.add(new Student("Krish",19,4,85));
        list.add(new Student("Ansh",18,5,53));
        list.add(new Student("Sanket",17,6,68));
        list.add(new Student("Ashish",15,7,49));
        System.out.println("Students list without any sorting applied");
        System.out.println("name  age   roll_no marks");
        for(Student s:list){
            System.out.println(s.name + " "+ s.age+ " "+s.roll_no + " "+ s.marks);
        }

        System.out.println("Sort Students as per their Age");
        Collections.sort(list,(a,b)->a.age-b.age);
        System.out.println("name  age   roll_no marks");
        for(Student s:list){
            System.out.println(s.name + " "+ s.age+ " "+s.roll_no + " "+ s.marks);
        }
        System.out.println("Sort Students as per their Marks (highest Marks first and lower marks @bottom )");
        Collections.sort(list,(a,b)->b.marks-a.marks);
        System.out.println("name  age   roll_no marks");
        for(Student s:list){
            System.out.println(s.name + " "+ s.age+ " "+s.roll_no + " "+ s.marks);
        }
        System.out.println("Sort Students as per their roll no ascending");
        Collections.sort(list,(a,b)->a.roll_no-b.roll_no);
        System.out.println("name  age   roll_no marks");
        for(Student s:list){
            System.out.println(s.name + " "+ s.age+ " "+s.roll_no + " "+ s.marks);
        }
    }
}
