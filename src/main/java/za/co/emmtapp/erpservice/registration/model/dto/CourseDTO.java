package za.co.emmtapp.erpservice.registration.model.dto;

import lombok.Data;
import za.co.emmtapp.erpservice.registration.model.CourseType;
import za.co.emmtapp.erpservice.registration.model.User;

import java.util.HashSet;
import java.util.Set;

@Data
public class CourseDTO {
    private String courseName;

    private long capacity;

    private String courseDescription;

    private CourseType courseType;
}
