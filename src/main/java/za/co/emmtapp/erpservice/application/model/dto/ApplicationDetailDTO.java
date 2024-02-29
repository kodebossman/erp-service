package za.co.emmtapp.erpservice.application.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationDetailDTO {
    private String applicationId;
    private String applicationType;
    private String applicationDate;
    private String applicationStatus;
    private Double applicationFee;
}
