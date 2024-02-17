package za.co.emmtapp.erpservice.application.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.emmtapp.erpservice.common.BaseEntity;

import java.util.List;

@Entity
@Table(name = "qualifications")
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PreviousQualifications extends BaseEntity {

    String nameOfInstitution;
    String highestQualificationObtained;
    String isCIMARegistered;
    CIMALevel CIMALevel;
    String cimaContactId;
    String cimaEmail;
    String listOfProfessionalBodies;
    Long papersLeft;
    String isMemberOfProfessionalBody;
    Long packageStudyDuration;
    String consentFormUrl;
    String hasConsented;
}
