package za.co.emmtapp.erpservice.review.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import za.co.emmtapp.erpservice.review.model.ApplicationReviewStatus;

@Data
@Schema(
        name = "ApplicationReview",
        description = "Schema to hold Application Review Information"
)
public class ApplicationReviewDTO {
    private String reviewStatus;
    private ApplicationReviewStatus status;
    private String comments;
    private String description;
    private String registrationLink;
    private String  applicationId;
}