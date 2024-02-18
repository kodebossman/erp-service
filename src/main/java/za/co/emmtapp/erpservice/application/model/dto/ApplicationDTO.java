package za.co.emmtapp.erpservice.application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.emmtapp.erpservice.application.model.PersonalDetails;
import za.co.emmtapp.erpservice.application.model.PreviousQualifications;
import za.co.emmtapp.erpservice.common.BaseDto;

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

}
