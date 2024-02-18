package za.co.emmtapp.erpservice.application.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentationDTO {
    private Long ownerId;
    private String documentName;
    private String documentURL;
    private String documentType;
}
