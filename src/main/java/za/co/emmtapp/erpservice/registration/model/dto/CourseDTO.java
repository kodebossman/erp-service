package za.co.emmtapp.erpservice.registration.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CourseDTO {
    String courseName;

    long capacity;

    long enrolledUsers;
}
