// Feature 9: Custom Exception Class
public class InvalidRecordException extends Exception {
    public InvalidRecordException(String message) {
        super(message);
    }
}