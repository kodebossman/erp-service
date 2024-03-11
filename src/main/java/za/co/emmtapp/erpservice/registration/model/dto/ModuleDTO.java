package za.co.emmtapp.erpservice.registration.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModuleDTO {
    private Long id;

    private String moduleName;

    private String moduleCode;

    private Long courseId;

    private String moduleDescription;
}
