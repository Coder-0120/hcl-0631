package Day1.accessspecifier;

public class BankTest {
    public static void main(String[]args){
        BankAccount account=new BankAccount();
        account.showBalance();
        account.deposit(34000);
        account.showBalance();
        account.withDraw(10000);
        account.showBalance();
        account.withDraw(50000);
        System.out.print(account.accountNo);
//        System.out.println(account.balance);
    }
}
