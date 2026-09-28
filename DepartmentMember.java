// Feature 1, 2, 4, 7: Class featuring Static counters, Access Modifiers, and Method Overloading
public class DepartmentMember extends NIRFRecord implements Displayable {
    
    // Feature 2: Static Counter
    private static int totalMemberCount = 0;

    // Feature 4: Access Modifiers
    private String memberId;       // Private
    private String name;           // Private
    protected String designation;  // Protected
    public String departmentName;  // Public

    // Feature 1: Constructor
    public DepartmentMember(String recordId, String memberId, String name, String designation) {
        super(recordId);
        this.memberId = memberId;
        this.name = name;
        this.designation = designation;
        this.departmentName = "DCST, Goa Business School";
        totalMemberCount++; // Increment static counter
    }

    // Feature 2: Static Method
    public static int getTotalMemberCount() {
        return totalMemberCount;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    @Override
    public String getCategorySummary() {
        return "Member: " + name + " [" + designation + "]";
    }

    @Override
    public String exportToCSV() {
        return String.format("%s,%s,%s,%s", recordId, memberId, name, designation);
    }

    // Feature 7: Method Overriding (from Displayable interface)
    @Override
    public void displayDetails() {
        System.out.println("ID: " + memberId + " | Name: " + name + " | Role: " + designation + " | Dept: " + departmentName);
    }

    // Feature 7: Method Overloading
    public void displayDetails(boolean showTimestamp) {
        displayDetails();
        if (showTimestamp) {
            System.out.println("   [Record Created On: " + timestamp + "]");
        }
    }
}