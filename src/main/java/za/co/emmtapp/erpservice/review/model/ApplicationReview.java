package za.co.emmtapp.erpservice.review.model;

import lombok.Data;
import za.co.emmtapp.erpservice.common.BaseEntity;
@Data
public class ApplicationReview extends BaseEntity {

    private String reviewStatus;
    private String status;
    private String comments;
    private String description;
    private Long  applicationId;
}
