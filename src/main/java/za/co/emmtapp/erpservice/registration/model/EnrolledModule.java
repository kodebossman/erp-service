package za.co.emmtapp.erpservice.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Entity
@Table(name = "enrolled_module")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EnrolledModule extends BaseEntity {
    @Column(name = "enrollement_id", nullable = false, length = 45)
    Long enrollmentId;

    @Column(name = "module_id", nullable = false, length = 45)
    Long moduleId;
}
