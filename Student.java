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
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getMarks() {
        return marks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Grade
    public String getGrade() {
        if (marks >= 90)
            return "A+";
        else if (marks >= 75)
            return "A";
        else if (marks >= 60)
            return "B";
        else if (marks >= 50)
            return "C";
        else
            return "F";
    }

    @Override
    public String toString() {
        return String.format(
                "%-5d %-15s %-25s %-8.1f %-5s",
                id, name, email, marks, getGrade());
    }
}
