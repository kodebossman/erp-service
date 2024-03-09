package za.co.emmtapp.erpservice.registration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends BaseEntity {
    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

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

    @Column(name = "phone", nullable = false, length = 12) // unique = true,
    private String mobileNumber;

    @Column(name = "email_address",  nullable = false, length = 45) // unique = true,
    private String emailAddress;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "gender")
    private String gender;
}
