import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class MiniProject {

 
    private static final ArrayList<String> attendanceList = new ArrayList<>();
    private static final HashSet<String> studentSet = new HashSet<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0; 

        do {
            System.out.println("\n==== Attendance List Manager ====");
            System.out.println("1. Add Student");
            System.out.println("2. View Attendance");
            System.out.println("3. Update Student Name");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number (1-5): ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAttendance();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    System.out.println("Exiting program... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close(); 
    }

    private static void addStudent() {
        System.out.print("Enter student name to add: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        if (studentSet.add(name)) { 
            attendanceList.add(name);
            System.out.println(name + " has been added successfully!");
        } else {
            System.out.println("Student already exists in the list!");
        }
    }

    private static void viewAttendance() {
        System.out.println("\n--- Attendance List ---");
        if (attendanceList.isEmpty()) {
            System.out.println("No students added yet.");
        } else {
            for (int i = 0; i < attendanceList.size(); i++) {
                System.out.println((i + 1) + ". " + attendanceList.get(i));
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter current student name: ");
        String oldName = scanner.nextLine().trim();

        if (studentSet.contains(oldName)) {
            System.out.print("Enter new student name: ");
            String newName = scanner.nextLine().trim();

            if (newName.isEmpty()) {
                System.out.println("Name cannot be empty.");
                return;
            }

           
            attendanceList.set(attendanceList.indexOf(oldName), newName);
            studentSet.remove(oldName);
            studentSet.add(newName);

            System.out.println("Student name updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void removeStudent() {
        System.out.print("Enter student name to remove: ");
        String name = scanner.nextLine().trim();

        if (studentSet.remove(name)) {
            attendanceList.remove(name);
            System.out.println(name + " has been removed from the list.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
