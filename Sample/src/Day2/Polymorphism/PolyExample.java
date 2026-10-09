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
public class PolyExample {
    public static void main(String[] args) {
        Test a=new Test();
        System.out.println(a.Add(20,30));
        System.out.println(a.Add(20,30,50));
        System.out.println(a.Add(20.334,30.332));

    }
}
