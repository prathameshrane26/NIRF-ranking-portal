import java.util.ArrayList;
import java.util.List;

// Subclass demonstrating Deep Cloning and Method Overriding
public class Student extends DepartmentMember {
    private Program program;
    private double gpa;
    private List<String> enrolledSubjects;

    public Student(String recordId, String studentId, String name, Program program, double gpa) {
        super(recordId, studentId, name, "Student");
        this.program = program;
        this.gpa = gpa;
        this.enrolledSubjects = new ArrayList<>();
    }

    public void addSubject(String subject) {
        enrolledSubjects.add(subject);
    }

    public List<String> getEnrolledSubjects() { 
        return enrolledSubjects; 
    }

    // Feature 7: Overriding displayDetails
    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + getMemberId() + " | Name: " + getName() + 
                           " | Program: " + program.getDescription() + " | GPA: " + gpa);
    }

    // Feature 10: Deep Cloning Implementation
    public Student deepClone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone(); // Shallow clone
        cloned.enrolledSubjects = new ArrayList<>(this.enrolledSubjects); // Deep clone reference
        return cloned;
    }
}