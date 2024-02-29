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
        name = "PersonalDetails",
        description = "Schema to hold Personal Details information"
)
public class PersonalDetailsDTO {
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
