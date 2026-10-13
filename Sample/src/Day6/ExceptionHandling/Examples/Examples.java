package Day6.ExceptionHandling.Examples;

public class Examples {
    public static void main(String[] args) {
        int a=10;
        int b=0;
//        System.out.println(a/b);
        try{
            int res=a/b;
            System.out.println(res);
        }
        catch (ArithmeticException e){
            System.out.println("Cannot divide by zero"); // only this part run if arthimetic exception occurs
        }
    }
}
