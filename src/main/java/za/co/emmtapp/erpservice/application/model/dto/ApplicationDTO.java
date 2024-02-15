package za.co.emmtapp.erpservice.application.model.dto;

import lombok.Data;
import za.co.emmtapp.erpservice.common.BaseDto;
import za.co.emmtapp.erpservice.application.model.Documentation;
import za.co.emmtapp.erpservice.application.model.EmploymentDetails;
import za.co.emmtapp.erpservice.application.model.NextOfKin;
import za.co.emmtapp.erpservice.application.model.PreviousQualifications;

@Data
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
    private NextOfKin nextOfKin;
    private Documentation documentation;
    private EmploymentDetails employmentDetails;
    private PreviousQualifications previousQualifications;

}
