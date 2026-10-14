
import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Store student names and marks using ArrayLists
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> marks = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Check whether the number of students is valid
        if (n <= 0) {
            System.out.println("Please enter at least one student.");
            sc.close();
            return;
        }

        // Get student names and marks
        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks (0-100): ");
            double mark = sc.nextDouble();
            sc.nextLine();

            // Validate the marks
            if (mark < 0 || mark > 100) {
                System.out.println("Invalid marks! Enter marks from 0 to 100.");
                i--;
                continue;
            }

            names.add(name);
            marks.add(mark);
        }

        // Initialize highest and lowest marks
        double highest = marks.get(0);
        double lowest = marks.get(0);
        double total = 0;

        // Calculate total, highest, and lowest marks
        for (double mark : marks) {
            total += mark;

            if (mark > highest) {
                highest = mark;
            }

            if (mark < lowest) {
                lowest = mark;
            }
        }

        // Calculate average marks
        double average = total / marks.size();

        // Display the student summary report
        System.out.println("\n===== STUDENT SUMMARY REPORT =====");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(
                names.get(i) + " - " + marks.get(i)
            );
        }

        System.out.printf("Average Marks: %.2f%n", average);
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);

        sc.close();
    }
}
