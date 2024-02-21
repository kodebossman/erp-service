package za.co.emmtapp.erpservice.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Entity
@Table(name = "employment_details")
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmploymentDetails extends BaseEntity {
    @Column(name = "applicant_id")
    private String applicantId;
    @Column(name = "name_of_employer")
    private String nameOfEmployer;
    @Column(name = "position")
    private String position;
    @Column(name = "address")
    private String address;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private  String endDate;
    @Column(name = "employment_status")
    private String employmentStatus;
    @Column(name = "city")
    private String city;
    @Column(name = "region")
    private String region;
    @Column(name = "country")
    private String country;

}
