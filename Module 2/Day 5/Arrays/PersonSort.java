package arraysDemo;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class PersonSort {
    public static void main(String[] args) {
        Person[] people= {
                new Person("Sachin","Tendulkar",26),
                new Person("Sourav","Ganguly",24),
                new Person("Rahul","Tendulkar",29),
                new Person("Yuvraj","Tendulkar",21),
                new Person("Abhishek","Tendulkar",25),
                new Person("Virat","Kohli",36)

        };
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number\n 1: fname Asc Comparator\n 2: lname Asc Comparator\n 3: age Asc Comparator ");
        int num= sc.nextInt();
        switch(num){
            case 1:
//                Arrays.sort(people, new fnameAscComparator());
//                System.out.println("fname Asc Comparator: " + Arrays.toString(people));
//                break;
                Arrays.sort(people, new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getFname().compareTo(o2.getFname());
                    }
                });
                System.out.println("fname Asc Comparator: " + Arrays.toString(people));
              break;
            case 2:
//                Arrays.sort(people, new lnameAscComparator());
//                System.out.println("lname Asc Comparator: " + Arrays.toString(people));
//                break;
                Arrays.sort(people, new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getLname().compareTo(o2.getLname());
                    }
                });
                System.out.println("lname Asc Comparator: " + Arrays.toString(people));
                break;
            case 3:
//                Arrays.sort(people, new ageAscComparator());
//                System.out.println("age Asc Comparator: " + Arrays.toString(people));
//                break;
                Arrays.sort(people, new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getAge() - o2.getAge();
                    }

                });
                System.out.println("age Asc Comparator: " + Arrays.toString(people));
                break;
        }
        sc.close();


    }
}
