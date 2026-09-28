public class Activity extends NIRFRecord implements Displayable {
    private String name;
    private ActivityCategory category;
    private String description;

    public Activity(String recordId, String name, ActivityCategory category, String description) {
        super(recordId);
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public String getName() { return name; }
    public ActivityCategory getCategory() { return category; }

    @Override
    public String getCategorySummary() {
        return "[" + category + "] " + name;
    }

    @Override
    public String exportToCSV() {
        return recordId + "," + name + "," + category + "," + description;
    }

    @Override
    public void displayDetails() {
        System.out.println("[" + category + "] " + name + " -> " + description);
    }
}