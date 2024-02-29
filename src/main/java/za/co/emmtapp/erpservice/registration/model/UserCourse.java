package za.co.emmtapp.erpservice.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Entity
@Table(name = "user_course")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserCourse {
    @Id
    @Column(name = "user_id", nullable = false, length = 45)
    long userId;

    @Column(name = "course_id", nullable = false, length = 45)
    long courseId;
}
