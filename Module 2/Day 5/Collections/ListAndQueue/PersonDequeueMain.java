package listAndQueue;
import java.util.*;

public class PersonDequeueMain {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Choose sorting option:");
            System.out.println("1 - Sort by Age");
            System.out.println("2 - Sort by First Name");
            System.out.println("3 - Sort by Last Name");

            int choice = sc.nextInt();

            Comparator<PersonDequeue> comparator;

            switch (choice) {
                case 1:
                    comparator = (p1, p2) -> p1.getAge() - p2.getAge();
                    break;
                case 2:
                    comparator = (p1, p2) -> p1.getFname().compareToIgnoreCase(p2.getFname());
                    break;
                case 3:
                    comparator = (p1, p2) -> p1.getLname().compareToIgnoreCase(p2.getLname());
                    break;
                default:
                    System.out.println("Invalid choice.");
                    comparator = (p1, p2) -> p1.getAge() - p2.getAge();
            }

            Deque<PersonDequeue> de = new ArrayDeque<>();

            de.add(new PersonDequeue("John", "Doe", 30));
            de.add(new PersonDequeue("Alice", "Smith", 25));
            de.add(new PersonDequeue("Bob", "Brown", 35));
            de.add(new PersonDequeue("Charlie", "Adams", 28));


            List<PersonDequeue> list = new ArrayList<>(de);

            list.sort(comparator);

            System.out.println("Sorted Output:");
            for (PersonDequeue p : list) {
                System.out.println(p);
            }

            sc.close();
        }

    }
