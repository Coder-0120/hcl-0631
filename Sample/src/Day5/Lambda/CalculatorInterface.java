package Day5.Lambda;
public  interface  CalculatorInterface{
    int Calculate(int x,int y);
}
class Calculator {
    public static void main(String[] args) {
        CalculatorInterface i=(a,b)->a+b;
        System.out.println(i.Calculate(10,20));

        CalculatorInterface i1=(a,b)->a*b;
        System.out.println(i1.Calculate(10,20));

        CalculatorInterface i2=(a,b)->a/b;
        System.out.println(i2.Calculate(10,20));

    }
}
