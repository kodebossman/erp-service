package za.co.emmtapp.erpservice.exceptions;

public class SubscriptionAlreadyExistException extends RuntimeException {
    public SubscriptionAlreadyExistException(String message) {
        super(message);
    }
}
