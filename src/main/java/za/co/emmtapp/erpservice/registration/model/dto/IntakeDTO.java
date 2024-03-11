package za.co.emmtapp.erpservice.registration.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntakeDTO {
    private Long id;
    private String intakeName;
    private Long courseId;
    private String startDate;
    private String endDate;
}
