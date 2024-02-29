package za.co.emmtapp.erpservice.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Entity
@Table(name = "applications")
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ApplicationDetails extends BaseEntity {
    @Column(name = "applicationId", nullable = false, length = 45)
    private String applicationId;

    @Column(name = "application_type")
    private String applicationType;

    @Column(name = "application_date")
    private String applicationDate;

    @Column(name = "status")
    private String applicationStatus;

    @Column(name = "fee")
    private Double applicationFee;

}
