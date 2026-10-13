package Day6.ExceptionHandling.Examples;
// Multiple try catch block
public class Example1 {
    public static void main(String[] args) {
        try {


            int[] arr = new int[]{1, 2, 4, 5, 6};
            int res1 = arr[5];
            System.out.println(res1);

            int a = 10;
            int b = 0;
            int res2 = a / b;
            System.out.println(res2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("index out of bounds");
        } catch (ArithmeticException e) {
            System.out.println("cannot divide by zero");
        }
        finally {
            System.out.println("Program completed");
        }
    }

}
