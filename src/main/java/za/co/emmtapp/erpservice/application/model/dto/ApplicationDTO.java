package za.co.emmtapp.erpservice.application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.emmtapp.erpservice.application.model.PreviousQualifications;
import za.co.emmtapp.erpservice.common.BaseDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO extends BaseDto {

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
    private String applicationType;
    private String applicationDate;
    private NextOfKinDTO nextOfKin;
    private DocumentationDTO documentation;
    private EmploymentDetailsDTO employmentDetails;
    private PreviousQualifications previousQualifications;

}
