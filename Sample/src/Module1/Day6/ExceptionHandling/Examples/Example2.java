package Module1.Day6.ExceptionHandling.Examples;

public class Example2 {
    public static void main(String[] args) {
        int a=10;
        if(a<18){
            throw  new IllegalArgumentException("a cannot be less than 18"); // throw: actually throws an exception
        }
        System.out.println("a age is greater than or equal to 18");
    }
}
