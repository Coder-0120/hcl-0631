package Day2.Polymorphism;
class Test{
    public  int Add(int x,int y){
        return x+y;
    }
    public  int Add(int x,int y,int z){
        return x+y+z;
    }public  double Add(double x,double y){
        return x+y;
    }
}
class Par{
    void Method1(){
        System.out.println("method 1 of Par class");
    }
}
class Par2 extends Par{
    void Method1(){
        System.out.println("method overriding done..");
    }
}
public class PolyExample {
    public static void main(String[] args) {
        Test a=new Test();
        System.out.println(a.Add(20,30));
        System.out.println(a.Add(20,30,50));
        System.out.println(a.Add(20.334,30.332));

        // override;
        Par2 b=new Par2();
        b.Method1();

    }
}
