package Day3.Practice;
interface inter2{
    void display();
}
interface  Payment{
    void pay();
}
class Child2 implements Payment,inter2{
    public void pay(){
        System.out.println("this is pay method content ");
    }
    public void display(){
        System.out.println("This is display mwthod");
    }
}
public class InterfaceClass {
    public static void main(String[] args) {
        Child2 obj1=new Child2();
        obj1.pay();
        obj1.display();
    }
}
