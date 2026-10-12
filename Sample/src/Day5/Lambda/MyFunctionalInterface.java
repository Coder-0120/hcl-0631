package Day5.Lambda;

public interface MyFunctionalInterface{
    void Calculate(int x,int y);
}
public class Main {
    public static void main(String[] args) {
        MyFunctionalInterface i=(x,y)->{
            System.out.println("Square of x : "+x*x);
            System.out.println("Addition  : "+ x + y);
            System.out.println("Division: "+x/y);
            System.out.println("Multiplication : "+y*x);
        }
        i.calculate(20,20);
    }
}
