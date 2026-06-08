import java.util.Scanner;

public class DayFinder {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

int[] daysInMonth = {
31, 28, 31, 30, 31, 30,
31, 31, 30, 31, 30, 31
};

String[] week = {
"Thursday", "Friday", "Saturday",
"Sunday", "Monday", "Tuesday", "Wednesday"
};

System.out.print("Enter month (1-12): ");
int month = sc.nextInt();

System.out.print("Enter date: ");
int date = sc.nextInt();

int totalDays = 0;

for (int i = 0; i < month - 1; i++) {
totalDays += daysInMonth[i];
}

totalDays += (date - 1);

int dayIndex = totalDays % 7;

System.out.println("Day is: " + week[dayIndex]);

sc.close();
}
}