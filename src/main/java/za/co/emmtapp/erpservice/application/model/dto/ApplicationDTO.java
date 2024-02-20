package za.co.emmtapp.erpservice.application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {

    private PersonalDetailsDTO personalDetails;
    private NextOfKinDTO nextOfKin;
    private DocumentationDTO documentation;
    private EmploymentDetailsDTO employmentDetails;
    private PreviousQualificationsDTO previousQualifications;
    private String applicationStatus;
    private String applicationType;
    private String applicationFee;

}
