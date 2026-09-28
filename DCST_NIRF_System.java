import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class DCST_NIRF_System {

    // Feature 6: Message Passing Function accepting Interface type
    public static void processAndDisplay(Displayable item) {
        item.displayDetails(); // Message passed to the target instance
    }

    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println(" DCST, GOA UNIVERSITY - NIRF DATA MANAGEMENT SYSTEM");
        System.out.println(" Student Development Officer Reporting Interface");
        System.out.println("==========================================================================");

        // ----------------------------------------------------------------------
        // 1. OBJECT REFERENCING & CONSTRUCTORS
        // ----------------------------------------------------------------------
        System.out.println("\n--- 1. Object Referencing & Side-Effects ---");
        Student s1 = new Student("REC001", "21P045001", "Aarav Naik", Program.MCA, 8.85);
        Student s2 = s1; // Both s1 and s2 share the same memory reference

        System.out.println("Original Name via s1: " + s1.getName());
        System.out.println("Original Name via s2: " + s2.getName());
        
        s2.addSubject("Advanced Database Management Systems");
        System.out.println("Adding subject via s2 reference...");
        System.out.println("Subjects in s1: " + s1.getEnrolledSubjects());

        // ----------------------------------------------------------------------
        // 2. STATIC ATTRIBUTES, METHODS & ENUMS
        // ----------------------------------------------------------------------
        System.out.println("\n--- 2. Static Attributes, Methods & Enums ---");
        Faculty f1 = new Faculty("REC002", "F001", "Dr. Jyoti Pawar", "Professor", "Data Mining & AI");
        Faculty f2 = new Faculty("REC003", "F002", "Mr. Ramrao Wagh", "Associate Professor", "Software Engineering");
        DepartmentMember staff1 = new DepartmentMember("REC004", "NT001", "Suresh Parab", "System Administrator");

        System.out.println("Total Department Members Created (Static Counter): " + DepartmentMember.getTotalMemberCount());
        System.out.println("Sample Enum Value: " + Program.MSC_DATA_SCIENCE.getDescription());

        // ----------------------------------------------------------------------
        // 3 & 5. MULTIPLE INHERITANCE, ABSTRACT CLASSES & INTERFACES
        // ----------------------------------------------------------------------
        System.out.println("\n--- 3 & 5. Abstract Class & Multiple Interface Inheritance ---");
        Activity act1 = new Activity("ACT001", "ISA (In-Semester Assessment)", ActivityCategory.ACADEMIC, "Continuous internal evaluation");
        System.out.println("Abstract Method Call (getCategorySummary): " + act1.getCategorySummary());
        System.out.println("Multiple Interface Implementation (Exportable): " + act1.exportToCSV());

        // ----------------------------------------------------------------------
        // 4. ACCESS MODIFIERS
        // ----------------------------------------------------------------------
        System.out.println("\n--- 4. Access Modifiers ---");
        System.out.println("Public Attribute Access (departmentName): " + s1.departmentName);
        System.out.println("Protected Attribute Access (designation): " + s1.designation);
        System.out.println("Private Attribute accessed via Getter (memberId): " + s1.getMemberId());

        // ----------------------------------------------------------------------
        // 6 & 7. CLASS AS A TYPE, MESSAGE PASSING & POLYMORPHISM
        // ----------------------------------------------------------------------
        System.out.println("\n--- 6 & 7. Polymorphism & Message Passing ---");
        Displayable d1 = s1;
        Displayable d2 = f1;

        System.out.print("[Message Passing to Student]: ");
        processAndDisplay(d1);

        System.out.print("[Message Passing to Faculty]: ");
        processAndDisplay(d2);

        System.out.println("\n[Demonstrating Method Overloading]:");
        s1.displayDetails();            // Standard call
        s1.displayDetails(true);        // Overloaded call with boolean parameter

        // ----------------------------------------------------------------------
        // 8. GENERICS & COLLECTION FRAMEWORKS
        // ----------------------------------------------------------------------
        System.out.println("\n--- 8. Generics and Collection Frameworks ---");
        NIRFDataStore<NIRFRecord> dataStore = new NIRFDataStore<>();

        List<Activity> academicActivities = new ArrayList<>();
        academicActivities.add(act1);
        academicActivities.add(new Activity("ACT002", "SEA (Semester End Assessment)", ActivityCategory.ACADEMIC, "Final term theory & practical examinations"));
        academicActivities.add(new Activity("ACT003", "Midpoint Seminar", ActivityCategory.ACADEMIC, "M.Tech & MCA dissertation review evaluation"));
        academicActivities.add(new Activity("ACT004", "Industrial Study Tour", ActivityCategory.ACADEMIC, "Exposure visit to tech hubs"));

        Set<String> nonAcademicEvents = new LinkedHashSet<>();
        nonAcademicEvents.add("InfoFest (National Level IT Festival)");
        nonAcademicEvents.add("Plateaunia (Inter-Faculty Cultural Event)");
        nonAcademicEvents.add("Play-On (Annual Sports Tournament)");

        Map<String, List<String>> courseCatalog = new HashMap<>();
        courseCatalog.put("MCA", Arrays.asList("Data Structures", "Machine Learning", "Cloud Computing", "Web Technologies"));

        System.out.println("DCST Academic Activities List Size: " + academicActivities.size());
        System.out.println("DCST Non-Academic Events Set: " + nonAcademicEvents);
        System.out.println("DCST MCA Subjects Map Entry: " + courseCatalog.get("MCA"));

        // ----------------------------------------------------------------------
        // 9. EXCEPTION HANDLING
        // ----------------------------------------------------------------------
        System.out.println("\n--- 9. Exception Handling (Try-Catch-Finally & Custom Exceptions) ---");
        try {
            System.out.println("Attempting to add valid student to Generic Store...");
            dataStore.addRecord(s1);
            
            System.out.println("Attempting to trigger Custom Exception by adding null record...");
            dataStore.addRecord(null);
        } catch (InvalidRecordException e) {
            System.err.println("Caught Custom Exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Generic Runtime Exception: " + e.getMessage());
        } finally {
            System.out.println("Finally Block Executed: Audit log captured for portal upload.");
        }

        // ----------------------------------------------------------------------
        // 10. REFLECTION, PERSISTENCE, FILE I/O & CLONING
        // ----------------------------------------------------------------------
        System.out.println("\n--- 10. Reflection, Persistence, File I/O & Cloning ---");

        // A. Shallow vs Deep Cloning
        try {
            Student s1_shallow = (Student) s1.clone();
            Student s1_deep = s1.deepClone();

            System.out.println("Shallow vs Deep Copy Check:");
            System.out.println("Same Subject List Reference (Shallow): " + (s1.getEnrolledSubjects() == s1_shallow.getEnrolledSubjects()));
            System.out.println("Same Subject List Reference (Deep): " + (s1.getEnrolledSubjects() == s1_deep.getEnrolledSubjects()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // B. Reflection
        System.out.println("\n[Reflection API Inspection]:");
        Class<?> studentClass = s1.getClass();
        System.out.println("Class Name: " + studentClass.getName());
        Method[] methods = studentClass.getDeclaredMethods();
        System.out.print("Declared Methods: ");
        for (int i = 0; i < Math.min(3, methods.length); i++) {
            System.out.print(methods[i].getName() + "()  ");
        }
        System.out.println();

        // C. Persistence & File I/O
        String fileName = "nirf_dcst_report.txt";
        System.out.println("\n[File I/O Operations]:");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("==============================================\n");
            writer.write("NIRF REPORT - DCST GOA UNIVERSITY\n");
            writer.write("==============================================\n");
            for (Activity act : academicActivities) {
                writer.write(act.exportToCSV() + "\n");
            }
            System.out.println("Successfully persisted data to file: " + fileName);
        } catch (IOException e) {
            System.err.println("IO Error writing file: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("\nReading contents back from " + fileName + ":");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("  [FILE DATA] " + line);
            }
        } catch (IOException e) {
            System.err.println("IO Error reading file: " + e.getMessage());
        }

        // ----------------------------------------------------------------------
        // FINAL NIRF REPORTING SUMMARY
        // ----------------------------------------------------------------------
        System.out.println("\n==========================================================================");
        System.out.println(" OFFICIAL NIRF DATA SUBMISSION SUMMARY FOR DCST, GBS");
        System.out.println("==========================================================================");
        System.out.println("1. PROGRAMS OFFERED:");
        for (Program p : Program.values()) {
            System.out.println("   - " + p.name() + ": " + p.getDescription());
        }

        System.out.println("\n2. ACADEMIC ACTIVITIES:");
        for (Activity act : academicActivities) {
            System.out.println("   - " + act.getName() + " (" + act.exportToCSV() + ")");
        }

        System.out.println("\n3. NON-ACADEMIC ACTIVITIES:");
        for (String event : nonAcademicEvents) {
            System.out.println("   - " + event);
        }

        System.out.println("\n4. RECENT PLACEMENT PARTNERS:");
        List<String> recruiters = Arrays.asList("TCS", "Infosys", "Wipro", "Deloitte", "Helix Tech", "Persistent Systems");
        System.out.println("   - Recruiters: " + String.join(", ", recruiters));
        System.out.println("==========================================================================");
    }
}