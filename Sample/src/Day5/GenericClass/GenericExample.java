package Day5.GenericClass;
class Box<T>{
    T value;
    void setValue(T value){
        this.value=value;
    }
    T getValue(){
        return value;
    }
}
public class GenericExample {
    public static void main(String[] args) {
        Box<Object>b1=new Box<>();
        b1.setValue(20);
        System.out.println(b1.getValue());
        b1.setValue("Anshul");
        System.out.println(b1.getValue());

    }
}
