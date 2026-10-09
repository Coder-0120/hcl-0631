package Day3.Practice.Abstraction;
abstract class A{
    void Method1(){
        System.out.println("Convert abstract method to normal method as we are not able to make obj until we have abstract method ");
    }
//    void Method2(){
//        System.out.println("Normal Method in abstract Class");
//    }
    abstract void Method3();
}

class Child extends A{
    void Method3(){
        System.out.println("This is method 3 content in child class which extednds abstract class");

    }
}
public class AbstractClass {
    public static void main(String[] args) {
//        A obj1=new A(); //. cannot create object if we have
//        obj1.Method1();
        Child c=new Child();
        c.Method3();
    }
}
