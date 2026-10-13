package Module1.Day6.ExceptionHandling.Examples;

class BankAccount {
    int balance=20000;
    void withDraw(int amt) throws InsufficientBalanceException{
        if(amt>balance){
            throw new InsufficientBalanceException("Balance is not sufficient");
        }
        balance-=amt;
        System.out.println("Payment withdraw done");
        System.out.println("Remaining ammount in account is "+ balance);
    }
}
class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String msg){
        super(msg);
    }
}
public class Example4 {
    public static void main(String[] args) {
        BankAccount b=new BankAccount();
        try{
            b.withDraw(28000);
        }
        catch (InsufficientBalanceException e){
            System.out.println("Balance is not sufficient in ur account to withdraw..");
        }
        System.out.println("Program continue..");
    }
}
