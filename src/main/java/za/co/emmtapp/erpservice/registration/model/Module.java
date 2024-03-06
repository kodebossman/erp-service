package za.co.emmtapp.erpservice.registration.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Getter
@Setter
@Entity
public class Module extends BaseEntity {
    private String moduleName;
    private String moduleDescription;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;
}
