package za.co.emmtapp.erpservice.application.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import za.co.emmtapp.erpservice.application.model.CIMALevel;

@Getter
@Setter
@Schema(
        name = "PreviousQualifications",
        description = "Schema to hold PreviousQualifications information"
)
public class PreviousQualificationsDTO {
    private String ownerId;
    private String nameOfInstitution;
    private String highestQualificationObtained;
    private String isCIMARegistered;
    private CIMALevel CimaLevel;
    private String cimaContactId;
    private String cimaEmail;
    private String listOfProfessionalBodies;
    private Long papersLeft;
    private String isMemberOfProfessionalBody;
    private Long packageStudyDuration;
    private String consentFormUrl;
    private String hasConsented;
}
