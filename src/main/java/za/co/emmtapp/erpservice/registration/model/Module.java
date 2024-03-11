package za.co.emmtapp.erpservice.registration.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Getter
@Setter
@Entity
public class Module extends BaseEntity {
    @Column(name = "module_name", nullable = false, length = 45)
    private String moduleName;

    @Column(name = "module_code", nullable = false, length = 45)
    private String moduleCode;

    @Column(name = "course_id", nullable = false, length = 45)
    private Long courseId;

    @Column(name = "module_description", nullable = false, length = 45)
    private String moduleDescription;
}
