package za.co.emmtapp.erpservice.application.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(
        name = "Documentation",
        description = "Schema to hold Documentation Details"
)
public class DocumentationDTO {
    private String ownerId;
    private String documentName;
    private String documentURL;
    private String documentType;
}
