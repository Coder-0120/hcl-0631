package Module1.Day6.FinallyExample;

public class Example2 {
    static int Method1(){
        try{
            return 10;
        }
        finally {
            System.out.println("Finally part executed");
        }
    }
    public static void main(String[] args) {
        System.out.println(Method1());

    }
}
