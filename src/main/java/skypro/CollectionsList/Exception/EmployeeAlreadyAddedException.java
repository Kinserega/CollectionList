package skypro.CollectionsList.Exception;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException() {
    }

    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
