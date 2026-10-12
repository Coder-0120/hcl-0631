package Day5.Comparator_and_Comparable;

public class MyComparator implements Comparable<Student> {
  public  int compare(Student s1,Student s2){
      return Integer.compare(s1.roll_no,s2.roll_no);
  }
}
