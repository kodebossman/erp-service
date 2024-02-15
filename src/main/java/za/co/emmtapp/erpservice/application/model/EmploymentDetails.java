package za.co.emmtapp.erpservice.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Entity
@Table(name = "employment_detail", indexes = {@Index(name = "indx_empldetail", columnList = "applicantId", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmploymentDetails extends BaseEntity {

    private String nameOfEmployer;
    private String position;
    private String address;
    private String startDate;
    private  String endDate;
    private String employmentStatus;
    private String city;
    private String region;
    private String country;
    private Long applicantId;

}
