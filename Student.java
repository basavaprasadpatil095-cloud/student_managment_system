// Student.java - Model class
public class Student {
 private int id;
 private String name;
 private String email;
 private double marks;
 public Student(int id, String name, String email, double marks) {
 this.id = id;
 this.name = name;
 this.email = email;
 this.marks = marks;
 }
 // Getters
 public int getId() { return id; }
 public String getName() { return name; }
 public String getEmail() { return email; }
 public double getMarks() { return marks; }
 // Setters
 public void setName(String n) { this.name = n; }
 public void setEmail(String e) { this.email = e; }
 public void setMarks(double m) { this.marks = m; }
 // Grade helper
 public String getGrade() {
 if (marks >= 90) return "A+";
 if (marks >= 75) return "A";
 if (marks >= 60) return "B";
 if (marks >= 50) return "C";
 return "F";
 }
 @Override
 public String toString() {
 return String.format("ID:%-4d Name:%-15s Email:%-20s Marks:%-6.1f
Grade:%s",
 id, name, email, marks, getGrade());
 