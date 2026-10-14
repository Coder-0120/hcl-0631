package Module1.Day7;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class EmployeeAnalytics {
    record Employee(int id, String name, String dept, BigDecimal salary,
                    LocalDate hireDate, Set<String> skills) {}
    static Employee e(int id, String n, String d, int sal, String date, String... skills) {
        return new Employee(id, n, d, BigDecimal.valueOf(sal),
                LocalDate.parse(date), Set.of(skills));
    }
    public static void main(String[] args) {
        List<Employee> emps = List.of(
                e(1, "Asha",   "Engineering",  90000, "2019-03-01", "Java", "SQL"),
                e(2, "Ravi",   "Engineering", 120000, "2016-07-15", "Java", "Spring", "AWS"),
                e(3, "Meera",  "HR",           60000, "2020-01-10", "Recruiting"),
                e(4, "John",   "Sales",        70000, "2018-11-20", "Negotiation", "CRM"),
                e(5, "Priya",  "Engineering", 105000, "2021-05-05", "Java", "React"),
                e(6, "Karan",  "Sales",        65000, "2022-02-14", "CRM"),
                e(7, "Sara",   "HR",           62000, "2017-09-09", "Recruiting", "Payroll"),
                e(8, "Vikram", "Finance",      80000, "2015-04-30", "Excel", "SQL"));

        //-------------------------------Q1-----------------------------------------------------------------------------
        //        Names of Engineering employees, sorted by salary descending
//        emps.stream().filter(e->"Engineering".equals(e.dept)).
//                sorted((e1,e2)->e2.salary().compareTo(e1.salary())).
//                map(Employee::name). // Sort the objects, then map the fields
//                forEach(System.out::println);

        //-------------------------------Q2-----------------------------------------------------------------------------
//        Names of the top 3 earners overall
//        List<String>highestSalary=emps.stream().sorted((e1,e2)->e2.salary().
//                compareTo(e1.salary())).map(Employee::name).
//                limit(3).toList();
//
//        System.out.println(highestSalary);

        //-------------------------------Q3-----------------------------------------------------------------------------
//       Employees hired before 2018-01-01, oldest hire first, as "name (year)" strings
//        List<String>ans=emps.stream().
//                filter(e->e.hireDate().isBefore(LocalDate.of(2018,1,1))).
//                sorted((e1,e2)->e1.hireDate().compareTo(e2.hireDate())).
//                map(e->e.name() + "("+e.hireDate.getYear()+")").toList();
//        System.out.println(ans);

        //-------------------------------Q4-----------------------------------------------------------------------------
//       All names joined as "Asha, Ravi, ..." using Collectors.joining
        String result=emps.stream().
                map(Employee::name).
                collect(Collectors.joining(","));
        System.out.println(result);

        //-------------------------------Q5-----------------------------------------------------------------------------
//        Total payroll as a BigDecimal using reduce (not a loop)
    BigDecimal sum=emps.stream().map(Employee::salary).reduce(new BigDecimal(0),(a,b)->a.add(b));
        System.out.println(sum);

        //-------------------------------Q6-----------------------------------------------------------------------------
//        anyMatch skill "AWS"? allMatch salary > 50000? noneMatch salary > 150000?
        boolean ans1=emps.stream().anyMatch(e->e.skills().contains("AWS"));
        System.out.println(ans1);

        boolean ans2=emps.stream().allMatch(e->e.salary().compareTo(new BigDecimal(50000))>0);
        System.out.println(ans2);

        boolean ans3=emps.stream().noneMatch(e->e.salary().compareTo(new BigDecimal(150000))>0);
        System.out.println(ans3);

        //-------------------------------Q7-----------------------------------------------------------------------------
//        The highest-paid employee as an Optional; print the name or "none"
        emps.stream().sorted((e1,e2)->e2.salary().compareTo(e1.salary())).
                map(e->e.name()).limit(1).forEach(System.out::println);

        //-------------------------------Q8-----------------------------------------------------------------------------
//        Average salary per department (groupingBy + averagingDouble)
    }

} 