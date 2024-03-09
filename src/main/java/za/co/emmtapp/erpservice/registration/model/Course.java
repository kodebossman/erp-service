package za.co.emmtapp.erpservice.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Entity
@Table(name = "courses")
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course extends BaseEntity {

    @Column(name = "course_name", nullable = false, length = 45)
    String courseName;

    @Column(name = "course_description", nullable = false, length = 45)
    String courseDescription;

    @Column(name = "capacity", nullable = false, length = 45)
    long capacity;
}
