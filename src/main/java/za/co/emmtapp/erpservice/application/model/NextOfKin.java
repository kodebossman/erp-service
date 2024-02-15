package za.co.emmtapp.erpservice.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "nextofkin", indexes = {@Index(name = "indx_nextofkin", columnList = "mobileNumber", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NextOfKin {

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "preferred_name", nullable = false, length = 45)
    private String preferredName;

    @Column(name = "id_number", unique = true, nullable = false, length = 10)
    private String idNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "phone", unique = true, nullable = false, length = 12)
    private String mobileNumber;

    @Column(name = "phone", unique = true, nullable = false, length = 12)
    private String emailAddress;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "gender")
    private String gender;

    @Column(name = "relationship_to_applicant")
    private String relationshipToApplicant;

    @Column(name = "applicant_id")
    private String applicantId;



}
