package Day5.Comparator_and_Comparable;

public class Student {
    String name;
    int roll_no;
    int marks;
    public String getName(){
        return name;
    }
    public Student(String name,int roll_no,int marks){
        this.name=name;
        this.roll_no=roll_no;
        this.marks=marks;
    }
    public  void setName(String name){
        this.name=name;
    }
    public int getRollno(){
        return roll_no;
    }
    public void setRoll_no(int rollNo){
        this.roll_no=rollNo;
    }
    public void setMarks(int marks){
        this.marks=marks;
    }
    public int getMarks(){
        return  marks;
    }
}
