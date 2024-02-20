package za.co.emmtapp.erpservice.review.model.dto;

import lombok.Data;
import za.co.emmtapp.erpservice.common.BaseDto;

@Data
public class ApplicationReviewDTO extends BaseDto {
    private String reviewStatus;
    private String status;
    private String comments;
    private String description;
    private Long  applicationId;
}