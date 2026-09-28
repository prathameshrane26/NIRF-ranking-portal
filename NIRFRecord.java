// Feature 3, 5 & 10: Abstract class implementing multiple interfaces and Cloneable
public abstract class NIRFRecord implements Identifiable, Exportable, Cloneable {
    protected String recordId;
    protected String timestamp;

    public NIRFRecord(String recordId) {
        this.recordId = recordId;
        this.timestamp = java.time.LocalDate.now().toString();
    }

    @Override
    public String getId() {
        return recordId;
    }

    // Abstract method to be overridden by subclasses
    public abstract String getCategorySummary();

    // Feature 10: Base Clone method
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}