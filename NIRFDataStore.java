import java.util.ArrayList;
import java.util.List;

// Feature 8: Generic Class bounded by NIRFRecord
public class NIRFDataStore<T extends NIRFRecord> {
    private List<T> records = new ArrayList<>();

    public void addRecord(T record) throws InvalidRecordException {
        if (record == null) {
            throw new InvalidRecordException("Cannot add null record to NIRF Repository!");
        }
        records.add(record);
    }

    public List<T> getAllRecords() {
        return records;
    }

    // Feature 8: Generic Method
    public static <E> void printElements(List<E> list) {
        for (E element : list) {
            System.out.println("  - " + element.toString());
        }
    }
}