package za.co.emmtapp.erpservice.registration.model.dto;

import lombok.Data;
import za.co.emmtapp.erpservice.registration.model.User;

import java.util.HashSet;
import java.util.Set;

@Data
public class CourseDTO {
    String courseName;

    long capacity;

    Set<User> enrolledUsers = new HashSet<>();
}
