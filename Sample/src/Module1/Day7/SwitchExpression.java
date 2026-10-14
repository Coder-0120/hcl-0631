package Module1.Day7;

public class SwitchExpression {
    public static void main(String[] args) {
        int day=20;
        switch (day){
            case 1-> System.out.println("monday");
            case 2-> System.out.println("Tuesday");
            case 3-> System.out.println("Wednesday");
            case 4-> System.out.println("Thrusday");
            case 5-> System.out.println("Friday");
            case 6-> System.out.println("Saturday");
            case 7-> System.out.println("Sunday");
            default -> System.out.println("Invalid day no");
        }
    }
}
