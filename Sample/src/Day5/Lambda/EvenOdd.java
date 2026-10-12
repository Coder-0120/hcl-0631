package Day5.Lambda;

public interface EvenOdd {
    boolean Check(int x);
}
class EvenAndOdd {

    public static void main(String[] args) {
        EvenOdd i=(a)->a%2==0;
        System.out.println(i.Check(10));
        System.out.println(i.Check(121));

    }
}