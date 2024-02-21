package za.co.emmtapp.erpservice.exceptions;

public class ApplicationNotFoundException extends RuntimeException{
    public ApplicationNotFoundException(String message) {
        super(message);
    }
}
