package package1;
import  java.util.*;
class Student2 {
    private int marks=20;
    public void display(){
        System.out.println("Hello Students");
    }
    public void getter(){
        System.out.println("Aman marks are :"+ marks);
    }
    public void Setter(int x){
        marks=x;
    }
}
public class Student{
    public static  void main(String[] args) {
        Student2 Aman = new Student2();
        Aman.display();
//        System.out.println("Aman marks : "+Aman.marks);
        Aman.Setter(50);
        Aman.getter();

    }
}
