package za.co.emmtapp.erpservice.application.model.dto;

import lombok.Getter;
import lombok.Setter;
import za.co.emmtapp.erpservice.application.model.ApplicationStatus;

@Getter
@Setter
public class ApplicationDetailDTO {
    private String applicationId;
    private String applicationType;
    private String applicationDate;
    private ApplicationStatus applicationStatus;
    private Double applicationFee;
}
