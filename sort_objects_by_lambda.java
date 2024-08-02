import java.util.*;
import java.util.stream.Collectors;
class Person{
    String name;
    Integer age;
    double salary;
    Person(String name,int age,double salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
    public String toString(){
        return this.name+" "+this.age+" "+this.salary;
    }
}
class sort_objects_by_lambda{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of objects to create: ");
        int n=sc.nextInt();
        String name;
        int age;
        double salary;
        List<Person> lp=new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.print("Enter name: ");
            name=sc.next();
            System.out.print("Enter age: ");
            age=sc.nextInt();
            System.out.print("Enter salary: ");
            salary=sc.nextDouble();
            Person p=new Person(name,age,salary);
            lp.add(p);
        }
        List<Person> pl=lp.stream().sorted((st1,st2)->st1.age.compareTo(st2.age)).collect(Collectors.toList());
        pl.forEach(System.out::println);
        //lp.stream().sorted((a,b)->a.age.compareTo(b.age)).collect(Collectors.toList()).forEach(System.out::println);
    }
}