public class Faculty extends DepartmentMember {
    private String specialization;

    public Faculty(String recordId, String facultyId, String name, String designation, String specialization) {
        super(recordId, facultyId, name, designation);
        this.specialization = specialization;
    }

    @Override
    public void displayDetails() {
        System.out.println("Faculty ID: " + getMemberId() + " | Name: " + getName() + 
                           " | Rank: " + designation + " | Specialization: " + specialization);
    }
}