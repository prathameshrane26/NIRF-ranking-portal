public enum Program {
    MCA("Master of Computer Applications"),
    MSC_DATA_SCIENCE("M.Sc. Data Science & AI"),
    MTECH_CST("M.Tech Computer Science"),
    PHD_CST("Ph.D. Computer Science");

    private final String description;

    Program(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}