package za.co.emmtapp.erpservice.review.model.dto;

import lombok.Data;
import za.co.emmtapp.erpservice.review.model.ApplicationReviewStatus;

@Data
public class ApplicationReviewDTO {
    private String reviewStatus;
    private ApplicationReviewStatus status;
    private String comments;
    private String description;
    private String  applicationId;
}