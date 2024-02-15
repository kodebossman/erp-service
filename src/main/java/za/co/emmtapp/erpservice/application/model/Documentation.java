package za.co.emmtapp.erpservice.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "documentation", indexes = {@Index(name = "indx_documentations", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Documentation {

    private String documentName;
    private String documentURL;
    private String documentType;
    private String ownerId;
}
