package za.co.emmtapp.erpservice.application.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Application",
        description = "Schema to hold Application Details"
)
public class ApplicationDTO {

    private PersonalDetailsDTO personalDetails;
    private NextOfKinDTO nextOfKin;
    private DocumentationDTO documentation;
    private EmploymentDetailsDTO employmentDetails;
    private PreviousQualificationsDTO previousQualifications;
//    private String applicationStatus;
//    private String applicationType;
//    private String applicationFee;
}
