package za.co.emmtapp.erpservice.application.model.dto;

import lombok.Getter;
import lombok.Setter;
import za.co.emmtapp.erpservice.application.model.CIMALevel;

@Getter
@Setter
public class PreviousQualificationsDTO {
    Long ownerId;
    String nameOfInstitution;
    String highestQualificationObtained;
    String isCIMARegistered;
    CIMALevel CimaLevel;
    String cimaContactId;
    String cimaEmail;
    String listOfProfessionalBodies;
    Long papersLeft;
    String isMemberOfProfessionalBody;
    Long packageStudyDuration;
    String consentFormUrl;
    String hasConsented;
}
