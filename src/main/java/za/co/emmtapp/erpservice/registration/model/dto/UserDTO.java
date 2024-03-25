package za.co.emmtapp.erpservice.registration.model.dto;

import lombok.Getter;
import lombok.Setter;
import za.co.emmtapp.erpservice.common.BaseDto;

@Getter
@Setter
public class UserDTO extends BaseDto {
    private String firstName;
    private String lastName;
    private String email;
}
