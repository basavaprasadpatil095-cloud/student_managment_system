// StudentManager.java - Business logic
import java.util.*;
import java.io.*;
public class StudentManager {
 private ArrayList<Student> students = new ArrayList<>();
 private static final String FILE = "students.txt";
 // ── CRUD ─────────────────────────────────────────────────
 public void addStudent(Student s) {
 for (Student st : students)
 if (st.getId() == s.getId()) {
 System.out.println("ID already exists!"); return;
 }
 students.add(s);
 System.out.println("Student added successfully!");
 }
 public void viewAll() {
 if (students.isEmpty()) { System.out.println("No students found.");
return; }
 System.out.println("\n" + "=".repeat(70));
 System.out.printf("%-6s %-15s %-20s %-8s
%s%n","ID","Name","Email","Marks","Grade");
 System.out.println("=".repeat(70));
 for (Student s : students) System.out.println(s);
 System.out.println("=".repeat(70));
 System.out.println("Total Students: " + students.size());
 }
 public void searchById(int id) {
 for (Student s : students)
 if (s.getId() == id) { System.out.println(s); return; }
 System.out.println("Student ID " + id + " not found.");
 }
 public void updateStudent(int id, String name, String email, double marks) {
 for (Student s : students) {
 if (s.getId() == id) {
 s.setName(name); s.setEmail(email); s.setMarks(marks);
System.out.println("Updated successfully!"); return;
 }
 }
 System.out.println("Student not found!");
 }
 public void deleteStudent(int id) {
 students.removeIf(s -> s.getId() == id);
 System.out.println("Deleted (if existed).");
 }
 // ── File I/O ──────────────────────────────────────────────
 public void saveToFile() {
 try (FileWriter fw = new FileWriter(FILE)) {
 for (Student s : students)

fw.write(s.getId()+","+s.getName()+","+s.getEmail()+","+s.getMarks()+"\n");
 System.out.println("Data saved to " + FILE);
 } catch (IOException e) { System.out.println("Save error: " +
e.getMessage()); }
 }
 public void loadFromFile() {
 File f = new File(FILE);
 if (!f.exists()) return;
 try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
 String line;
 while ((line = br.readLine()) != null) {
 String[] p = line.split(",");
students.add(new Student(Integer.parseInt(p[0]), p[1], p[2],
Double.parseDouble(p[3])));
 }
 System.out.println("Data loaded: " + students.size() + " students.");
 } catch (IOException e) { System.out.println("Load error: " +
e.getMessage()); }
 }
}