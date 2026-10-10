package Day4;

import java.util.ArrayList;
import java.util.Collections;

class Student implements  Comparable<Student>{
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
    public  int compareTo(Student other){
        if(this.age==other.age){
            if(this.marks==other.marks){
                return Integer.compare(this.roll_no, other.roll_no);
            }
            else{
                return Integer.compare(other.marks,this.marks);
            }
        }
        else{
            return Integer.compare(this.age,other.age);
        }
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
        Collections.sort(list);// using comparablee class
        System.out.println("Sort Students as per their Age");
//        Collections.sort(list,(a,b)->a.age-b.age);
//        Collections.sort(list,(a,b)->Integer.compare(a.age,b.age));

        System.out.println("name  age   roll_no marks");
        for(Student s:list){
            System.out.println(s.name + " "+ s.age+ " "+s.roll_no + " "+ s.marks);
        }
        System.out.println("Sort Students as per their Marks (highest Marks first and lower marks @bottom )");
//        Collections.sort(list,(a,b)->b.marks-a.marks);
//        Collections.sort(list,(a,b)->Integer.compare(b.marks,a.marks));

        System.out.println("name  age   roll_no marks");
        for(Student s:list){
            System.out.println(s.name + " "+ s.age+ " "+s.roll_no + " "+ s.marks);
        }
        System.out.println("Sort Students as per their roll no ascending");
//        Collections.sort(list,(a,b)->a.roll_no-b.roll_no);
//          Collections.sort(list,(a,b)->Integer.compare(a.roll_no,b.roll_no));

        System.out.println("name  age   roll_no marks");
        for(Student s:list){
            System.out.println(s.name + " "+ s.age+ " "+s.roll_no + " "+ s.marks);
        }
    }
}
