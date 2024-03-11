package za.co.emmtapp.erpservice.registration.model.dto;

import lombok.Data;
import za.co.emmtapp.erpservice.registration.model.CourseType;
@Data
public class CourseDTO {
    private Long id;

    private String courseName;

    String courseCode;

    private long capacity;

    private String courseDescription;

    private CourseType courseType;
}
