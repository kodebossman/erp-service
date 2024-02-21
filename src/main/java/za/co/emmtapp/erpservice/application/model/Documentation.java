package za.co.emmtapp.erpservice.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.emmtapp.erpservice.common.BaseEntity;

@Entity
@Table(name = "documentation")
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Documentation extends BaseEntity {
    @Column(name = "owner_id")
    private String ownerId;
    @Column(name = "document_name")
    private String documentName;
    @Column(name = "document_url")
    private String documentURL;
    @Column(name = "document_type")
    private String documentType;
}
