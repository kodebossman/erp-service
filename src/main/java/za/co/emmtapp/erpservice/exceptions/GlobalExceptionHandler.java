package za.co.emmtapp.erpservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import za.co.emmtapp.erpservice.application.model.dto.ErrorResponseDto;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleApplicationAlreadyExistsException(ApplicationAlreadyExistsException exception,
                                                                                    WebRequest webRequest){
        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ApplicationNotFoundException exception,
                                                                            WebRequest webRequest){
        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
//        String errorMessage = "Error occurred due to database constraint violation: ";
//        if (ex.getMessage().contains("unique constraint")) {
//            errorMessage += "ID Number provided is not unique.";
//        } else {
//            errorMessage += ex.getMessage(); // Or provide a generic error message
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
//    }
}
