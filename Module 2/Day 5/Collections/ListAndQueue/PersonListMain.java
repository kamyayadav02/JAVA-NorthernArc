package listAndQueue;

import java.util.*;

public class PersonListMain {
    public static void main(String[] args) {

        // Using List like your example
        List<PersonList> list = new Vector<>();

        list.add(new PersonList("Sachin", "Tendulkar", 26));
        list.add(new PersonList("Sourav", "Ganguly", 24));
        list.add(new PersonList("Rahul", "Tendulkar", 29));
        list.add(new PersonList("Yuvraj", "Tendulkar", 21));
        list.add(new PersonList("Abhishek", "Tendulkar", 25));
        list.add(new PersonList("Virat", "Kohli", 36));

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        // Using set()
        list.set(0, new PersonList("MS", "Dhoni", 42));

        // Using remove()
        list.remove(5);
        list.remove(4);

        System.out.println("After modification: " + list);

        // Sorting part
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        System.out.println("1: fname Asc");
        System.out.println("2: lname Asc");
        System.out.println("3: age Asc");

        int num = sc.nextInt();

        switch (num) {
            case 1:
                Collections.sort(list, new Comparator<PersonList>() {
                    public int compare(PersonList o1, PersonList o2) {

                        return o1.getFname().compareTo(o2.getFname());
                    }
                });
                break;

            case 2:
                Collections.sort(list, new Comparator<PersonList>() {
                    public int compare(PersonList o1, PersonList o2) {
                        return o1.getLname().compareTo(o2.getLname());
                    }
                });
                break;

            case 3:
                Collections.sort(list, new Comparator<PersonList>() {
                    public int compare(PersonList o1, PersonList o2) {
                        return o1.getAge() - o2.getAge();
                    }
                });
                break;
        }

        System.out.println("Sorted List: " + list);

        sc.close();
    }
}