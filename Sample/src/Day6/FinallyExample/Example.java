package Day6.FinallyExample;

public class Example {
    public static void main(String[] args) {
        try{
            int a=10;
            int b=2;
            System.out.println(a/b);
            System.exit(0); // it skips the finally block as well
        }
        finally {
            System.out.println("Finally done");
        }
    }
}
