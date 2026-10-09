package Day2.ConstructorExample;
class Test{
    String name;
    int age;

    Test() {
        this("Unknown", 0);
    }

    Test(String name) {
        this(name, 0);
    }

    Test(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.print(name +" "+ age);
    }
}
public class Prac {
    public static void main(String[] args) {
        Test t1=new Test();
        Test t2=new Test("Anshul");
        Test t3=new Test("Anshul",20);

    }
}
