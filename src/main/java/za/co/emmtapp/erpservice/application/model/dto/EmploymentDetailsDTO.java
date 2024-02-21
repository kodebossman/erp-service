package za.co.emmtapp.erpservice.application.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmploymentDetailsDTO {
    private String applicantId;
    private String nameOfEmployer;
    private String position;
    private String address;
    private String startDate;
    private  String endDate;
    private String employmentStatus;
    private String city;
    private String region;
    private String country;
}
