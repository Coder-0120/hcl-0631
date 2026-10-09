package Day1.accessspecifier;

public class BankAccount {
    private  double balance=20000.80;
    protected int accountNo=204;
    public void showBalance(){
        System.out.println(balance);
    }
    public  void deposit(int amt){
        if(amt>0){
            balance+=amt;
        }
    }
    public void withDraw(int amt){
        System.out.println("accountNo acceess in same class "+ accountNo);
        if(amt<=balance){
            balance-=amt;
        }
        else{
            System.out.println("Invalid Amount..");
        }
    }
}
