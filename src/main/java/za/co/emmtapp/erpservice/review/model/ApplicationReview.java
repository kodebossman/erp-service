package za.co.emmtapp.erpservice.review.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.co.emmtapp.erpservice.common.BaseEntity;
@Entity
@Table(name = "application_review")
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ApplicationReview extends BaseEntity {

    @Column(name = "application_id", nullable = false, length = 45)
    private String  applicationId;

    @Column(name = "review_status", nullable = false, length = 45)
    private String reviewStatus;

    @Column(name = "status", nullable = false, length = 245)
    @Enumerated(EnumType.STRING)
    private ApplicationReviewStatus status;

    @Column(name = "comments", nullable = false, length = 245)
    private String comments;

    @Column(name = "description", nullable = false, length = 245)
    private String description;
}
