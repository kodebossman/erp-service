package za.co.emmtapp.erpservice.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Entity
@Table(name = "enrollments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Enrollment extends BaseEntity {
    @Column(name = "userId", nullable = false, length = 45)
    Long userId;

    @Column(name = "intake_id", nullable = false, length = 45)
    Long intakeId;
}
