package za.co.emmtapp.erpservice.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Entity
@Table(name = "next_of_kin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NextOfKin extends BaseEntity {

    @Column(name = "applicant_id")
    private String applicantId;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "preferred_name", nullable = false, length = 45)
    private String preferredName;

    @Column(name = "id_number", nullable = false, length = 10) //, unique = true,
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

    @Column(name = "phone", nullable = false, length = 12) // unique = true,
    private String mobileNumber;

    @Column(name = "email_address", nullable = false, length = 45) //  unique = true,
    private String emailAddress;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "gender")
    private String gender;

    @Column(name = "relationship_to_applicant")
    private String relationshipToApplicant;
}
