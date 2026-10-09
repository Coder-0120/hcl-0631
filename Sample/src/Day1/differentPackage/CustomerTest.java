package Day1.differentPackage;
import  Day1.accessspecifier.BankAccount;
public class CustomerTest extends BankAccount{
    public static void main(String[] args) {
        BankAccount ac=new BankAccount();
//        System.out.println("Accessing acountNo which is default frrom another diff package java class "+ac.accountNo);// shows error
//        System.out.println("Accessing acountNo which is public frrom another diff package java class "+ac.accountNo);
//        System.out.println("Accessing acountNo which is protected frrom another diff package java class"+ac.accountNo);// same give error
//        System.out.println("Accessing acountNo which is protected by extends  another diff package java class"+accountNo);
        CustomerTest cust=new CustomerTest();
        System.out.println(cust.accountNo);



    }



}
