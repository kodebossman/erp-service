package za.co.emmtapp.erpservice.registration.model.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String password;
    private String title;
    private String firstName;
    private String lastName;
    private String preferredName;
    private String idNumber;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private String country;
    private String mobileNumber;
    private String emailAddress;
    private String nationality;
    private String gender;
}
