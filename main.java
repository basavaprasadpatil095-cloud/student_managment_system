// Main.java - Entry point & Menu
import java.util.Scanner;
public class Main {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 StudentManager mgr = new StudentManager();
 mgr.loadFromFile(); // load existing data on startup
 System.out.println("╔══════════════════════════════════════╗");
 System.out.println("║ Student Management System v1.0 ║");
 System.out.println("╚══════════════════════════════════════╝");
 while (true) {
 System.out.println("\n──── MENU ────");
 System.out.println("1. Add Student");
 System.out.println("2. View All Students");
 System.out.println("3. Search Student by ID");
 System.out.println("4. Update Student");
 System.out.println("5. Delete Student");
 System.out.println("6. Save Data");
 System.out.println("0. Exit");
 System.out.print("Enter choice: ");
 try {
 int choice = Integer.parseInt(sc.nextLine().trim());
switch (choice) {
 case 1:
 System.out.print("ID : "); int id =
Integer.parseInt(sc.nextLine());
 System.out.print("Name : "); String name =
sc.nextLine();
 System.out.print("Email : "); String email =
sc.nextLine();
 System.out.print("Marks : "); double marks =
Double.parseDouble(sc.nextLine());
 mgr.addStudent(new Student(id, name, email, marks));
break;
 case 2: mgr.viewAll(); break;
case 3:
 System.out.print("Enter ID: ");
mgr.searchById(Integer.parseInt(sc.nextLine())); break;
 case 4:
 System.out.print("ID : "); int uid =
Integer.parseInt(sc.nextLine());
 System.out.print("Name : "); String un = sc.nextLine();
System.out.print("Email : "); String ue = sc.nextLine();
System.out.print("Marks : "); double um =
Double.parseDouble(sc.nextLine());
 mgr.updateStudent(uid, un, ue, um); break;
 case 5:
 System.out.print("ID to delete: ");
mgr.deleteStudent(Integer.parseInt(sc.nextLine())); break;
 case 6: mgr.saveToFile(); break;
 case 0:
 mgr.saveToFile();
System.out.println("Data saved. Goodbye!");
sc.close(); return;
 default: System.out.println("Invalid choice!");
 }
 } catch (NumberFormatException e) {
 System.out.println("Invalid input! Please enter numbers where
required.");
 }
 }
 }
}