import java.util.ArrayList;
import java.io.*;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.txt";

    // Add Student
    public void addStudent(Student student) {

        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        students.add(student);
        System.out.println("Student added successfully!");
    }

    // View All Students
    public void viewAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n---------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-25s %-8s %-5s\n",
                "ID", "Name", "Email", "Marks", "Grade");
        System.out.println("---------------------------------------------------------------");

        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("---------------------------------------------------------------");
    }

    // Search Student
    public void searchStudent(int id) {

        for (Student s : students) {

            if (s.getId() == id) {
                System.out.println("\nStudent Found:");
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Update Student
    public void updateStudent(int id, String name, String email, double marks) {

        for (Student s : students) {

            if (s.getId() == id) {

                s.setName(name);
                s.setEmail(email);
                s.setMarks(marks);

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete Student
    public void deleteStudent(int id) {

        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed)
            System.out.println("Student deleted successfully!");
        else
            System.out.println("Student not found.");
    }

    // Save Data
    public void saveToFile() {

        try (FileWriter writer = new FileWriter(FILE_NAME)) {

            for (Student s : students) {

                writer.write(
                        s.getId() + "," +
                        s.getName() + "," +
                        s.getEmail() + "," +
                        s.getMarks() + "\n");
            }

            System.out.println("Data saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving file.");
        }
    }

    // Load Data
    public void loadFromFile() {

        File file = new File(FILE_NAME);

        if (!file.exists())
            return;

        students.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 4) {

                    students.add(new Student(
                            Integer.parseInt(data[0]),
                            data[1],
                            data[2],
                            Double.parseDouble(data[3])));
                }
            }

        } catch (IOException e) {

            System.out.println("Error loading file.");
        }
    }
}
