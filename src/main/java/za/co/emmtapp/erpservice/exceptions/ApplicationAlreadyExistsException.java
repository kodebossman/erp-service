package za.co.emmtapp.erpservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ApplicationAlreadyExistsException extends RuntimeException {
    public ApplicationAlreadyExistsException(String message) {
        super(message);
    }
}
