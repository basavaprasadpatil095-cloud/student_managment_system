import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        // Load saved data
        manager.loadFromFile();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Save Data");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:

                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = Double.parseDouble(sc.nextLine());

                        manager.addStudent(new Student(id, name, email, marks));
                        break;

                    case 2:

                        manager.viewAllStudents();
                        break;

                    case 3:

                        System.out.print("Enter Student ID: ");
                        int searchId = Integer.parseInt(sc.nextLine());

                        manager.searchStudent(searchId);
                        break;

                    case 4:

                        System.out.print("Enter Student ID: ");
                        int updateId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Email: ");
                        String newEmail = sc.nextLine();

                        System.out.print("Enter New Marks: ");
                        double newMarks = Double.parseDouble(sc.nextLine());

                        manager.updateStudent(updateId, newName, newEmail, newMarks);
                        break;

                    case 5:

                        System.out.print("Enter Student ID to Delete: ");
                        int deleteId = Integer.parseInt(sc.nextLine());

                        manager.deleteStudent(deleteId);
                        break;

                    case 6:

                        manager.saveToFile();
                        break;

                    case 0:

                        manager.saveToFile();
                        System.out.println("Data saved successfully.");
                        System.out.println("Thank you for using Student Management System.");
                        break;

                    default:

                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter valid numeric input.");
                choice = -1;
            }

        } while (choice != 0);

        sc.close();
    }
}
