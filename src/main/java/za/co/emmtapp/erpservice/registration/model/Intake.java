package za.co.emmtapp.erpservice.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Entity
@Table(name = "intake")
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Intake extends BaseEntity {
    @Column(name = "intake_name", nullable = false, length = 45)
    String intakeName;

    @Column(name = "course_id", nullable = false, length = 45)
    Long courseId;

    @Column(name = "start_date", nullable = false, length = 45)
    String startDate;

    @Column(name = "end_date", nullable = false, length = 45)
    String endDate;
}
