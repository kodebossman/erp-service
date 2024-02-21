package za.co.emmtapp.erpservice.application.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Entity
@Table(name = "qualifications")
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PreviousQualifications extends BaseEntity {
    @Column(name = "owner_id")
    Long ownerId;

    @Column(name = "institution_name")
    String nameOfInstitution;

    @Column(name = "highest_qualification")
    String highestQualificationObtained;

    @Column(name = "is_cima_registered")
    String isCIMARegistered;

    @Column(name = "cima_level")
    @Enumerated(EnumType.STRING)
    CIMALevel CimaLevel;

    @Column(name = "cima_contact_id")
    String cimaContactId;

    @Column(name = "cima_email")
    String cimaEmail;

    @Column(name = "professional_bodies")
    String listOfProfessionalBodies;

    @Column(name = "papers_left")
    Long papersLeft;

    @Column(name = "is_member_of_prof_body")
    String isMemberOfProfessionalBody;

    @Column(name = "study_package_duratiom")
    Long packageStudyDuration;

    @Column(name = "consent_form_url")
    String consentFormUrl;

    @Column(name = "has_consented")
    String hasConsented;
}
