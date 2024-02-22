package za.co.emmtapp.erpservice.application.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(
        name = "EmploymentDetails",
        description = "Schema to hold Employment Details"
)
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
